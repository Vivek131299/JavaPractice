public class Main_Encapsulation {

    public static void main(String[] args) {
        Player player = new Player();

        // Here, we are able to access the fields(fullName, health, weapon) of 'Player'
        // class as they are declared as public. So, this is why we should use
        // ENCAPSULATION by declaring that fields as private so that we cannot access
        // them outside its class.
        player.fullName = "Tim";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        damage = 11;
        player.health = 200; // Here we can change the value of variable 'health' due to lack
                             // of encapsulation. This may lead to system security issues.
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        // Another problem we may face due to lack of encapsulation that if we change
        // any variable name 'Player' class, then we need to also change in other
        // classes using it.

        // One more issue is that as we can assign value to any variable, there is no
        // validation happening here and anyone can set invalid value.

        //
        System.out.println("Output below is of EnhancedPlayer class in which we applied Encapsulation");
        // Below code is after applying ENCAPSULATION in 'EnhancedPlayer' class.
        //

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Tim", 50, "Sword");
        System.out.println("Initial health is " + enhancedPlayer.getHealth()); // Here, we cannot access the 'health'
                                                                               // field directy as we have declared them
                                                                               // as 'private', SO we are accessing it
                                                                               // through getter.

    }
}
