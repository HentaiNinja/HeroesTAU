package pl.hentaininja.herocrud;

import static org.junit.Assert.*;
import org.junit.Test;
import pl.hentaininja.herocrud.domain.Battle;

public class CreateObjectTest
{
    @Test
    public void testCreateObject()
    {
     Battle battle = new Battle("WarriorsOfLight","Goblins","Victory");
     assertNotNull(battle);
    }
}