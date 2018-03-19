package pl.hentaininja.com;

import pl.hentaininja.herocrud.domain.Hero;

import java.util.List;

public interface HeroRepository {
    public List<Hero> getAll();
    public int add(Hero h);
    public void delete(long id);
    public int update(Hero hero, long id) throws SQLException;
    public Hero getById(long id) throws SQLException;
    public Hero getByName(String name);
    public Hero getByClass(String class);
}