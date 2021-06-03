import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> { // Here we are declaring this class as a Generic class. T indicates the type.
     // So how tis basically work is when we actually instantiate a class the T will be replaced automatically by Java with
    // the actual class(like BaseballPlayer, FootballPlayer, etc.) we are using with the real type in other words when
    // we are actually instantiating the class.

    // Also, we are extending this T fromPlayer class because we don't want to be the T of any type(like String, Integer, etc.),
    // so now T can be restricted of restricted type which we call as bounded parameters.
    // So, be extending T from Player class, we will be able to only pass type of T parameter which is of type
    // Player(or subclass of Player class) like FootballPlayer, etc..
    // We can also extend T from an interface like we are doing from class.

    // ALso, interfaces can also themselves specify type parameters like classes, so in other words, we can create instances
    // of a class that implement an interface and then we can ensure that the interface methods we implement act on a specific
    // type of object. (for e.g.- List<String> here List is an interface).

    // This is a single bound as we are extending from single class,
    // But it supports multiple bound in which it can extend from one class and many interfaces like normal inheritance.
    // e.g.- public class Team<T extends Player & Coach & Manager> {} where Player is class and Coach/Manger are interfaces.

    // And we are also implementing Comparable Interface to compare Teams scores but in that we are defining it as Generic
    // of type parameter <Team<T>> so that we can only compare two similar teams.(e.g. FootballTeam with FootballTeam only).

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    // Here we are creating an ArrayList that's using Generic for our Player objects.
    private ArrayList<T> members = new ArrayList<>(); // Here we also(like on line 3) put type parameter as 'T' instead if 'Player'.

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPLayer(T player) { // Here also we are replacing 'Player' type parameter with 'T' type parameter.
        if (members.contains(player)) {
            //System.out.println(((Player) player).getName() + " is already in this team"); // Here we are type casting the variable player which was of
                                                                                            // type T to the type Player as we want to access the getName()
                                                                                            // method of Player class.

            System.out.println(player.getName() + " is already in this team"); // Now no need to cast to Player(like above commented) because we have already
                                                                                // extended the type parameter T from Player class.
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }

    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) { // Here we are also defining Team of generic type because we want
                                                                                // to only calculate result if both teams are of same type
                                                                                // FootballTeam can call matchResult only if opponent is of type FootballTeam.
        String message;
        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = "lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore); // This is for updating opponent's score.
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
