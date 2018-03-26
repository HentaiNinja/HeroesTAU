package pl.hentaininja.herocrud.repository;

import pl.hentaininja.herocrud.domain.Hero;

import java.util.List;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public interface HeroRepository {
    public List<Hero> getAll();
    public int add(Hero h);
    public Hero getById(long id) throws SQLException;
    public Hero getByName(String name);
    public int update(Hero h, long id) throws SQLException;
    public void delete(long id);
}