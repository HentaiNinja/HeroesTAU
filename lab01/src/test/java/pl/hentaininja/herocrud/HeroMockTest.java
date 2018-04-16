package pl.hentaininja.herocrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pl.hentaininja.herocrud.domain.Hero;
import pl.hentaininja.herocrud.repository.HeroRepository;
import pl.hentaininja.herocrud.repository.HeroRepositoryImpl;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HeroMockTest {

    HeroRepository heroRepository;

    @Mock
    Connection connectionMock;

    @Mock
    PreparedStatement addStatementMock;

    @Mock
    PreparedStatement getAllStatementMock;

    @Mock
    PreparedStatement deleteStatementMock;

    @Mock
    PreparedStatement getByIdStatementMock;

    @Mock
    PreparedStatement getByNameStatementMock;

    @Mock
    PreparedStatement updateHeroStatementMock;

    @Before
    public void setupDatabase() throws SQLException {
        when(connectionMock.prepareStatement("INSERT INTO Hero(id,name,klasa) VALUES (?,?,?)")).thenReturn(addStatementMock);
        when(connectionMock.prepareStatement("SELECT id,name,klasa FROM Hero")).thenReturn(getAllStatementMock);
        when(connectionMock.prepareStatement("SELECT * FROM Hero WHERE id = ? ")).thenReturn(getByIdStatementMock);
        when(connectionMock.prepareStatement("UPDATE Hero SET name= ?, klasa= ? WHERE id = ?")).thenReturn(updateHeroStatementMock);
        when(connectionMock.prepareStatement("DELETE FROM Hero WHERE id = ?")).thenReturn(deleteStatementMock);
        when(connectionMock.prepareStatement("SELECT * FROM Hero WHERE name= ?")).thenReturn(getByNameStatementMock);
        heroRepository = new HeroRepositoryImpl();
        heroRepository.setConnection(connectionMock);

        verify(connectionMock).prepareStatement("INSERT INTO Hero(id,name,klasa) VALUES (?,?,?)");
        verify(connectionMock).prepareStatement("SELECT id,name,klasa FROM Hero");
        verify(connectionMock).prepareStatement("SELECT * FROM Hero WHERE id = ? ");
        verify(connectionMock).prepareStatement("UPDATE Hero SET name= ?, klasa= ? WHERE id = ?");
        verify(connectionMock).prepareStatement("DELETE FROM Hero WHERE id = ?");
        verify(connectionMock).prepareStatement("SELECT * FROM Hero WHERE name= ?");

    }

    @Test
    public void checkAdding() throws Exception {
        when(addStatementMock.executeUpdate()).thenReturn(1);
        Hero tKnight = new Hero();

        tKnight.setid(2);
        tKnight.setname("Knight");
        tKnight.setklasa("tank");

        assertEquals(1, heroRepository.add(tKnight));
        verify(addStatementMock, times(1)).setInt(1, 2);
        verify(addStatementMock, times(1)).setString(2, "Knight");
        verify(addStatementMock, times(1)).setString(3, "tank");
        verify(addStatementMock).executeUpdate();
    }

    @Test
    public void checkDeleting() throws SQLException {
        when(deleteStatementMock.executeUpdate()).thenReturn(1);
        assertEquals(1, heroRepository.delete(1));
        verify(deleteStatementMock,times(1)).setLong(1, 1);
        verify(deleteStatementMock).executeUpdate();
    }

    abstract class AbstractResultSet implements ResultSet {
        int i = 0;

        @Override
        public int getInt(String s) throws SQLException {
            return 1;
        }

        @Override
        public String getString(String columnLabel1) throws SQLException {
            if (columnLabel1 == "klasa") {
                return "tank";
            } else {
                return "Knight";
            }
        }


        @Override
        public boolean next() throws SQLException {
            if (i == 1)

                return false;
            i++;
            return true;
        }
    }

    @Test
    public void checkUpdating() throws SQLException {
        when(updateHeroStatementMock.executeUpdate()).thenReturn(1);
        Hero tKnight = new Hero();

        tKnight.setid(1);
        tKnight.setname("Warrior");
        tKnight.setklasa("tank");

        assertEquals(1, heroRepository.update(tKnight,1));
        verify(updateHeroStatementMock).executeUpdate();
    }


    @Test
    public void getByIdTest() throws SQLException {
        AbstractResultSet mockedResutSet = mock(AbstractResultSet.class);
        when(mockedResutSet.next()).thenCallRealMethod();
        when(mockedResutSet.getInt("id")).thenCallRealMethod();
        when(mockedResutSet.getString("name")).thenCallRealMethod();
        when(mockedResutSet.getString("klasa")).thenCallRealMethod();
        when(getByIdStatementMock.executeQuery()).thenReturn(mockedResutSet);

        assertEquals(1, heroRepository.getById(1).getid());

        verify(getByIdStatementMock, times(1)).executeQuery();
        verify(mockedResutSet, times(1)).getInt("id");
        verify(mockedResutSet, times(1)).getString("name");
        verify(mockedResutSet, times(1)).getString("klasa");
        verify(mockedResutSet, times(2)).next();
    }


    @Test
    public void getByName() throws SQLException {

        AbstractResultSet mockedResultSet = mock(AbstractResultSet.class);
        when(mockedResultSet.next()).thenCallRealMethod();
        when(mockedResultSet.getInt("id")).thenCallRealMethod();
        when(mockedResultSet.getString("name")).thenCallRealMethod();
        when(mockedResultSet.getString("klasa")).thenCallRealMethod();
        when(getByNameStatementMock.executeQuery()).thenReturn(mockedResultSet);

        assertEquals("Knight", heroRepository.getByName("Knight").getname());


        verify(getByNameStatementMock, times(1)).executeQuery();
        verify(mockedResultSet, times(1)).getInt("id");
        verify(mockedResultSet, times(1)).getString("name");
        verify(mockedResultSet, times(1)).getString("klasa");
        verify(mockedResultSet, times(2)).next();
    }

    @Test
    public void getAllTest() throws SQLException {
        AbstractResultSet mockedResultSet = mock(AbstractResultSet.class);
        when(mockedResultSet.next()).thenCallRealMethod();
        when(mockedResultSet.getInt("id")).thenCallRealMethod();
        when(mockedResultSet.getString("name")).thenCallRealMethod();
        when(mockedResultSet.getString("klasa")).thenCallRealMethod();
        when(getAllStatementMock.executeQuery()).thenReturn(mockedResultSet);

        assertEquals(1, heroRepository.getAll().size());

        verify(getAllStatementMock, times(1)).executeQuery();
        verify(mockedResultSet, times(1)).getInt("id");
        verify(mockedResultSet, times(1)).getString("name");
        verify(mockedResultSet, times(1)).getString("klasa");
        verify(mockedResultSet, times(2)).next();
    }

}