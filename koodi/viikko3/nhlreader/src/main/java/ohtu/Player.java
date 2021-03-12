package ohtu;

public class Player implements Comparable <Player>{

    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;
    private int tehopisteet;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setTehopisteet(){
        this.tehopisteet = goals + assists;
    }
    public int getTehopisteet(){
        return this.tehopisteet;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Player player) {
        setTehopisteet();
        int compareAssists = ((Player) player).getTehopisteet();
        return  compareAssists - this.tehopisteet;
    }

    @Override
    public String toString() {
        //Henrik Borgstrom team FLA goals 0 assists 0
        return name + " team " + team + " goals " + goals + " assists " + assists + " tehopisteet " + tehopisteet;
    }

}
