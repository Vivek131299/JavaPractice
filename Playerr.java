import java.util.ArrayList;
import java.util.List;

public class Playerr implements ISaveable {

    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Playerr(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Playerr{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    // The methods that we implement from Interface we used are called 'Stubs'.
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints); // We are adding "" (double quotes) and appending before hitPoints because we have to convert
                                                          // hitPoints to String as it is a int variable. We can also do this by .toString().
                                                            // But this can be used as a shortcut.
        values.add(2, "" + this.strength);
        values.add(3, this.weapon);

        return values;
    }

    @Override
    public void read(List<String> savedValues) { // In this parameter, we are creating List but we are passing ArrayList and still its working.
                                                // That's because List and ArrayList implements same Interface and
                                                // because of that we are also able to use .get() on List (like below).

        if (savedValues != null && savedValues.size() > 0) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1)); // We are converting String from savedValues to int because hitPoints is of int type.
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }
}
