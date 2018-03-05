package pl.hentaininja.com;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    
    public List<Hero> heroDb;

    @Test
    public void createHeroTest() {
       Hero tHero = new Hero();

       HeroRepositoryFactory.getInstance().add(tHero);

       assertEquals(tHero.getNickName(), HeroRepositoryFactory.getInstance().getByName("Hero"));
       assertThat("Hero", HeroRepositoryFactory.getInstance().getById(1), );
    }

    @Test
    public void updateHeroTest() {
       
       Hero updateHero = HeroRepositoryFactory.getInstance().getById(1);
       updateHero.setFirstName("HeroOfLight");
       HeroRepositoryFactory.getInstance().update(updateHero, 1);

       assertEquals("HeroOfLight", HeroRepositoryFactory.getInstance().getByName("HeroOfLight"));
    }

    @Test
    public void deleteHeroTest() {
       
       HeroRepositoryFactory.getInstance().delete(3);
       assertNull(HeroRepositoryFactory.getInstance().getById(3));
       assertNotNull(HeroRepositoryFactory.getInstance().getAll());
    }

    @Test
    public void getById() {
       
       Hero hero = HeroRepositoryFactory.getInstance().getById(1);
       assertEquals(HeroRepositoryFactory.getInstance().getById(1), hero.getId(1));
    }

    @Test
    public void getByName() {
       
    }


}