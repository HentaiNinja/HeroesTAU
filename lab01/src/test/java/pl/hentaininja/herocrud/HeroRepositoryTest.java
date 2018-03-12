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
       
       Hero updateHero = heroRepository.getInstance().getById(1);
       updateHero.setFirstName("HeroOfLight");
       heroRepository.getInstance().update(updateHero, 1);

       assertEquals("HeroOfLight", heroRepository.getByNickName("Hero").);
    }

    @Test
    public void deleteHeroTest() {
       
       HeroRepositoryFactory.getInstance().delete(3);
       assertNull(HeroRepositoryFactory.getInstance().getById(3));
       assertNotNull(HeroRepositoryFactory.getInstance().getAll().isEmpty());
    }

    @Test
    public void getById() {
       
       //Hero hero = HeroRepositoryFactory.getInstance().getById(1);
       //assertEquals(HeroRepositoryFactory.getInstance().getById(1), hero.getId(1));
       Long idToFind = (long) 1;
       assertNotNull(HeroRepositoryFactory.getById(idToFind));
    }

    @Test
    public void getAll() {
        assertNotNull(HeroRepositoryFactory.getAll().isEmpty);
    }

    @Before
    public void initRepository() {
        heroRepository = HeroRepositoryFactory.getInstance();
        Hero tank = new Hero();
        Hero healer = new Hero();
        Hero meleeDps = new Hero();
        Hero rangedDps = new Hero();

            tank.setId((long) 1);
            tank.setType("Tank");
            healer.setId((long) 2);
            healer.setType("Healer");
            meleeDps.setId((long) 3);
            meleeDps.setType("MeleeDps");
            rangedDps.setId((long) 4);
            rangedDps.setType("RangedDps");

        HeroRepository.add(tank);
        HeroRepository.add(healer);
        HeroRepository.add(meleeDps);
        HeroRepository.add(rangedDps);
}

}