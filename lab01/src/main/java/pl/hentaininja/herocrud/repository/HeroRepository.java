package pl.hentaininja.com;

import pl.hentaininja.herocrud.domain.Hero;

import java.util.List;

public interface HeroRepository {
    public void initDatabase();
    public List<Hero> getAll();
    public void add(Hero h);
    public void delete(Hero hero);
    public void update(long oldId, Hero newHero);
    public Hero getById(long id);
    public Hero getByName(String name);
}