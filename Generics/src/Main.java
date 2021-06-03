// Generics allow us to create classes, interfaces and methods that take types as parameters called Type Parameters.
// For e.g.- as we use when creating ArrayLists and LinkedLists passing type (like Integer, String) as parameters.

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        // Above, we are initializing the Team variable which is of type parameter FootballPlayer because we don't want to add
        // player of different sports(like pat and beckham) in other sport's team. So, only adding joe will be valid as
        // joe is of type FootballPlayer.

        adelaideCrows.addPLayer(joe);
        //adelaideCrows.addPLayer(pat);
        //adelaideCrows.addPLayer(beckham);

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPLayer(pat);

        // If we only define the 'Team' class generic with type parameter 'T', Problem here is that we can add any type
        // of type parameter(e.g.- String, Integer, etc.), like below:
        /*Team<String> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPLayer("no-one");*/ // This will give error because we are type casting this passed parameter name into
                                         // type 'Player' in Team class.

        Team<SoccerPlayer> soccerTeam = new Team<>("Soccer team");
        soccerTeam.addPLayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPLayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
        //adelaideCrows.matchResult(baseballTeam, 1, 1); // We can't do this because as adelaideCrows is of type FootballPlayer
                                                                        // and baseballTeam of type BaseballPlayer, and this is checked in matchResult()
                                                                        // method in Team class where we are defining opponent parameter as of type T.

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));
    }
}
