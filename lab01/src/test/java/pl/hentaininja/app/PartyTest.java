package pl.hentaininja.app;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PartyTest {
    @Ignore
    @Test
    public void testCreatedObject(){
        Party party = new Party("Warrior", "strong", "slow", "dummy");
        assertNotNull(party);
    }
}