package pl.hentaininja.herocrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import pl.hentaininja.herocrud.domain.Hero;
import pl.hentaininja.herocrud.repository.HeroRepository;
import pl.hentaininja.herocrud.repository.HeroRepositoryFactory;
import static org.hamcrest.CoreMatchers.*;

public class HeroRepositoryTest {
    
    HeroRepository heroRepository;

    @Test
    public void createHeroTest() throws SQLException {
       Hero tHero = new Hero();

       tHero.setId(1);
       tHero.setName("Knight");
       tHero.setKlasa("tank");
       heroRepository.add(tHero);

       assertEquals(tHero.getName(), heroRepository.getById(1).getName());
    }

    @Test
    public void updateHeroTest() throws SQLException {
       
       Hero updateHero = heroRepository.getById(2);
       updateHero.setName("Archer");
       heroRepository.update(updateHero, 2);

       assertEquals("Archer", heroRepository.getById(2).getName());
       assertEquals("Wizard"), heroRepository.getById(3).getName());
    }

    @Test
    public void deleteHeroTest() throws SQLException {
       
        heroRepository.delete(4);
        assertNull(heroRepository.getById(4).getName());
    }

    @Test
    public void getById() throws SQLException {

        Long idToFind = (long) 1;
        assertNotNull(heroRepository.getById(idToFind));
    }

    @Test
    public boid getByName() {
        Hero hero = heroRepository.getByKlasa("tank");
        assertThat(hero.getName(), is("Warrior"));
    }

    @Test
    public void getAll() throws SQLException {
        assertNotNull(heroRepository.getAll());
    }

    @Before
    public void initRepository() throws SQLException {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        heroRepository = HeroRepositoryFactory(DriverManager.getConnection(url));
        
        Hero aDps = new Hero();
        aDps.setId(2);
        aDps.setName("Archer");
        aDps.setKlasa("dps");

        Hero wDps = new Hero();
        wDps.setId(3);
        wDps.setName("Wizard");
        wDps.setKlasa("dps");

        Hero wTank = new Hero();
        wTank.setId(4);
        wTank.setName("Warrior");
        wTank.setKlasa("tank");           

        heroRepository.add(aDps);
        heroRepository.add(wDps);
        heroRepository.add(wTank);
}

}