package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query1 = new QueryBuilder();
        
        Matcher m1 = query1.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(5, "goals").build();
        
        QueryBuilder query2 = new QueryBuilder();
        
        Matcher m2 = query2.playsIn("EDM")
                .hasAtLeast(40, "points").build();

        Matcher m = query2.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
