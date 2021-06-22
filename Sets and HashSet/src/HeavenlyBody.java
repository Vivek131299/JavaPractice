import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>(); // Initializing Set.
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(this.satellites);
    }


    // equals() and hashCode() methods. (we can also add by intellij shortcut, alt + insert)

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // check if the object is same as that of this class.
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57; // We are calling hashCode() method from String class because we are comparing only name
        // of HeavenlyBody which is a String.
        // We are adding 57 (we can add any number) to guarantee that number returned will be a non-zero integer.
    }

    // Now after overriding equals and hashCode methods we can see 'Pluto' once as expected in the Set and we have no duplicates now.
}
