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
import pl.hentaininja.herocrud.repository.HeroRepositoryImpl;
import static org.hamcrest.CoreMatchers.*;

public class HeroRepositoryTest {
    
    HeroRepository heroRepository;

    @Before
    public void initDatabase() throws SQLException {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        heroRepository = HeroRepositoryImpl(DriverManager.getConnection(url));
        
        Hero aDps = new Hero();
        aDps.setid(2);
        aDps.setname("Archer");
        aDps.setklasa("dps");

        Hero wDps = new Hero();
        wDps.setid(3);
        wDps.setname("Wizard");
        wDps.setklasa("dps");

        Hero wTank = new Hero();
        wTank.setid(4);
        wTank.setname("Warrior");
        wTank.setklasa("tank");           

        heroRepository.add(aDps);
        heroRepository.add(wDps);
        heroRepository.add(wTank);
    }

    @Test
    public void createHeroTest() throws SQLException {
       Hero tHero = new Hero();

       tHero.setid(1);
       tHero.setname("Knight");
       tHero.setklasa("tank");
       heroRepository.add(tHero);

       assertEquals(tHero.getname(), heroRepository.getById(1).getname());
    }

    @Test
    public void updateHeroTest() throws SQLException {
       
       Hero updateHero = heroRepository.getById(2);
       updateHero.setname("Archer");
       heroRepository.update(updateHero, 2);

       assertEquals("Archer", heroRepository.getById(2).getname());
       assertEquals("Wizard", heroRepository.getById(3).getname());
    }

    @Test
    public void deleteHeroTest() throws SQLException {
       
        heroRepository.delete(4);
        assertNull(heroRepository.getById(4).getname());
    }

    @Test
    public void getById() throws SQLException {

        Long idToFind = (long) 1;
        assertNotNull(heroRepository.getById(idToFind));
    }

    @Test
    public void getByName() {
        Hero hero = heroRepository.getByName("Wizard");
        assertThat(hero.getname(), is("Warrior"));
    }

    @Test
    public void getAll() throws SQLException {
        assertNotNull(heroRepository.getAll());
    }

}