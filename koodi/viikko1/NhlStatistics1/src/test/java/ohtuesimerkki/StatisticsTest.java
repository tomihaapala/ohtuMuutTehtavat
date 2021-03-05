/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Tomi
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;
    Statistics stats2;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
        stats2 = new Statistics();
    }

    @Test
    public void test1() {

        List<Player> players = stats.topScorers(1);
        List<Player> players2 = stats.team("PIT");

        assertEquals("EDM", players.get(0).getTeam());
        assertEquals("PIT", players2.get(0).getTeam());

    }

    @Test
    public void testForSearch() {
        
        Player player = stats.search("Semenko");
Player players = stats.search("Semenkfo");
        assertEquals(4, player.getGoals());
        assertEquals(null, stats.search("Semenkfo"));
    }

}
