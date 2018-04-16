package pl.hentaininja.herocrud.repository;

import pl.hentaininja.herocrud.domain.Hero;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;

public interface HeroRepository {
     List<Hero> getAll();
     int add(Hero h);
     Hero getById(long id) throws SQLException;
     Hero getByName(String name);
     int update(Hero h, long id) throws SQLException;
     int delete(long id);
     void setConnection(Connection connection) throws SQLException;
}