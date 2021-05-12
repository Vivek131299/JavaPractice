public class Player {

    // Here we are declaring variables as 'public' and not 'private'. Due to public,
    // any another class can access this variables and also change its values.
    // So, this does not applies ENCAPSULATION.
    public String fullName;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
            // Reduce no. of lives of player.
        }
    }

    public int healthRemaining() {
        return this.health;
    }

}