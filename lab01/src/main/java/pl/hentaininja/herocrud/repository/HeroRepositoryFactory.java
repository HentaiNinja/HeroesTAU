package pl.hentaininja.repository;

import pl.hentaininja.herocrud.repository.HeroRepositoryImpl;

import java.sql.DriverManager;
import java.sql.SQLException;

class HeroRepositoryFactory {
    public static HeroRepository getInstance() {
        try {
            String url = "jdbc:hsqldb:hsql://localhost/workdb";
            return new HeroRepositoryImpl(DriverManager.getConnection(url));
        }
        catch (SQLException e){
            return null;
        }
    }
}