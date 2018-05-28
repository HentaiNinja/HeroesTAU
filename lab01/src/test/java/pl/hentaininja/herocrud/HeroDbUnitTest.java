package pl.hentaininja.herocrud;

import java.net.URL;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import pl.hentaininja.herocrud.domain.Hero;
import pl.hentaininja.herocrud.repository.HeroRepository;
import pl.hentaininja.herocrud.repository.HeroRepositoryImpl;

@RunWith(JUnit4.class)
public class HeroDbUnitTest extends DBTestCase
{

    public static String url = "jdbc:hsqldb:hsql://localhost/workdb";

    HeroRepository heroRepository;

    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        heroRepository = new HeroRepositoryImpl(DriverManager.getConnection(url));
    }

    @Test
    public void doNothing()
    {
        assertEquals(3,heroRepository.getAll().size());
    }
    @Test
    public void checkAdding() throws Exception
    {
        Hero hero = new Hero();
        hero.setname("Warrior");
        hero.setklasa("tank");

        assertEquals(1, heroRepository.add(hero));

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("HERO");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] {"ID"});
        IDataSet expectedDataSet = getDataSet("ds-1.xml");
        ITable expectedTable = expectedDataSet.getTable("HERO");
        Assertion.assertEquals(expectedTable, filteredTable);
        heroRepository.delete(3);
        getTearDownOperation();
}
@Override
protected DatabaseOperation getSetUpOperation() throws Exception
{
    return DatabaseOperation.INSERT;
}

@Override
protected DatabaseOperation getTearDownOperation() throws ExecutionException
{
    return DatabaseOperation.DELETE;
}
@Override
protected IDataSet getDataSet() throws Exception {
    return this.getDataSet("ds-0.xml");
}

protected IDataSet getDataSet(String dataset) throws Exception
{
    URL url = getClass().getClassLoader().getResource(dataset);
    FlatXmlDataSet ret = new FlatXmlDataSetBuilder().build(url.openStream());
    return ret;

}

}