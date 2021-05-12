public class EnhancedPlayer {

    // In this class, we will apply ENCAPSULATION unlike the 'Player' class.
    // So we are declaring fields as 'private'.
    private String name;
    private int health = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;

        // Validation
        if (health > 0 && health <= 100) {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
        }
        // Reduce no. of lives of player.
    }

    public int getHealth() {
        return health;
    }

    // Another advantage of encapsulation is that if we change any of the field name
    // in this class then we don't need to change it in another class as no other
    // class is accessing it(we are accessing it using getter from another class).
}
