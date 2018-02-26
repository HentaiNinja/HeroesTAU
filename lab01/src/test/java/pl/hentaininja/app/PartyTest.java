package pl.hentaininja.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeroesStatsTest {
    @Test
    public void testCreatedObject(){
        Party party = new Party("Warrior", "strong", "slow", "dummy");
        assertNotNull(party);
    }
}