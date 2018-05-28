package pl.hentaininja.herocrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.DriverManager;
import java.sql.SQLException;

//import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import pl.hentaininja.herocrud.domain.Hero;
import pl.hentaininja.herocrud.repository.HeroRepository;
import pl.hentaininja.herocrud.repository.HeroRepositoryImpl;
import static org.hamcrest.CoreMatchers.*;

public class HeroRepositoryTest {
    
    HeroRepository heroRepository;

    @Before
    public void initDatabase() throws SQLException {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        heroRepository = new HeroRepositoryImpl(DriverManager.getConnection(url));
        
        Hero aDps = new Hero();
        aDps.setid(1);
        aDps.setname("Archer");
        aDps.setklasa("dps");

        Hero wDps = new Hero();
        wDps.setid(2);
        wDps.setname("Wizard");
        wDps.setklasa("dps");

        Hero wTank = new Hero();
        wTank.setid(3);
        wTank.setname("Warrior");
        wTank.setklasa("tank");           

        heroRepository.add(aDps);
        heroRepository.add(wDps);
        heroRepository.add(wTank);
    }

    @Test
    public void createHeroTest() throws SQLException {
       Hero tHero = new Hero();

       tHero.setid(4);
       tHero.setname("Knight");
       tHero.setklasa("tank");
       heroRepository.add(tHero);

       assertEquals(tHero.getname(), heroRepository.getById(4).getname());
    }

    @Test
    public void updateHeroTest() throws SQLException {
       
       Hero updateHero = heroRepository.getById(1);
       updateHero.setname("Archer");
       heroRepository.update(updateHero, 1);

       assertEquals("Archer", heroRepository.getById(1).getname());
       assertEquals("Wizard", heroRepository.getById(2).getname());
    }

    @Test
    public void deleteHeroTest() throws SQLException {
       
        heroRepository.delete(3);
        assertNull(heroRepository.getById(3).getname());
        assertFalse(heroRepository.getAll().isEmpty());
    }

    @Test
    public void getById() throws SQLException {

        assertEquals(1, heroRepository.getById(1).getid());
    }

    @Test
    public void getByName() {
        Hero hero = heroRepository.getByName("Wizard");
        assertThat(hero.getklasa(), is("dps"));
    }

    @Test
    public void getAll() throws SQLException {
        assertNotNull(heroRepository.getAll());
    }

}