import java.util.ArrayList;
import java.util.List;

class Human {
    String name;
    Human(String name) { this.name = name; }
}

class Player extends Human {
    Player(String name) { super(name); }
}

class Referee extends Human {
    Referee(String name) { super(name); }

    void blowWhistle() {
        System.out.println(name + " blows the whistle! And we are off for this cracking mouth-watering fixture");
    }
}

class Team {
    String teamName;
    List<Player> players = new ArrayList<>();

    Team(String name) { this.teamName = name; }

    void addPlayer(Player p) {
        players.add(p);
    }
}

class Goal {
    Player scorer;
    Team team;
    int minute;

    Goal(Player scorer, Team team, int minute) {
        this.scorer = scorer;
        this.team = team;
        this.minute = minute;
    }
}

class Match {
    Team t1, t2;
    Referee referee;
    List<Goal> goals = new ArrayList<>();
    int t1Goals = 0;
    int t2Goals = 0;

    Match(Team t1, Team t2, Referee referee) {
        this.t1 = t1;
        this.t2 = t2;
        this.referee = referee;
    }

    //overload
    void addGoal(Goal g) {
        goals.add(g);
        if (g.team == t1) t1Goals++;
        else if (g.team == t2) t2Goals++;
        System.out.println(g.team.teamName+ " Scores: Golazoo by "+g.scorer.name+" "+g.minute+"'");
    }

    //overload
    void addGoal(Team t, Player p, int minute){
        goals.add(new Goal(p, t, minute));
        if (t == t1) t1Goals++;
        else if (t == t2) t2Goals++;
        System.out.println(t.teamName+ " Scores: Golazoo by "+p.name+" "+minute+"'");
    }

    //overload
    void addGoal(Goal g, String type){
        goals.add(g);
        if (g.team == t1) t1Goals++;
        else if (g.team == t2) t2Goals++;
        System.out.println(g.team.teamName+ " Scores: " + type + " goal by "+g.scorer.name+" "+g.minute+"'");
    }

    void start() {
        referee.blowWhistle();
        System.out.println("Match starts between " + t1.teamName + " and " + t2.teamName + "!\n");
    }

    void showResult() {
        System.out.println("\nFinal Score: " + t1.teamName + " " + t1Goals + " - " + t2Goals + " " + t2.teamName);
    }

    //overload
    void showResult(Boolean with_details){
        if (with_details){
            System.out.println("\nFinal Score: " + t1.teamName + " " + t1Goals + " - " + t2Goals + " " + t2.teamName);
            for (Goal g : goals){
                System.out.println(g.minute + "' - " + g.scorer.name + " (" + g.team.teamName + ")");
            }
        }
    }
}

public class Football {
    public static void main(String[] args) {
        // Players
        Player messi = new Player("Messi");
        Player reza = new Player("Sahil");
        Team barca = new Team("Barcelona");
        barca.addPlayer(messi);
        barca.addPlayer(reza);

        Player ronaldo = new Player("Ronaldo");
        Player faiz = new Player("Faiz");
        Team madrid = new Team("Real Madrid");
        madrid.addPlayer(ronaldo);
        madrid.addPlayer(faiz);

        // Referee
        Referee ref = new Referee("Pierluigi Collina");

        // Match
        Match elClasico = new Match(barca, madrid, ref);
        elClasico.start();

        elClasico.addGoal(new Goal(messi, barca, 12));
        elClasico.addGoal(new Goal(ronaldo, madrid, 47), "penalty");
        elClasico.addGoal(madrid, faiz, 92);

        // Final outcome
        elClasico.showResult();
        elClasico.showResult(Boolean.TRUE);
    }
}
