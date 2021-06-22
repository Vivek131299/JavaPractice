import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    /*
    /////////////////// Sets interface //////////////////////
    A Set has no defined ordering and it cannot contain duplicates unlike Lists.
    A Set is a generic like Maps but it takes a single argument.
    It has basic methods add, remove and clear to maintain the items in Set.
    It also has size and isEmpty methods.
    We can use contains method to check if a specific item is in the Set.
    There is no way to retrieve an item from a set, we can check if something exists and we can iterate over all the elements in the
    Set but attempting to get any specific element (for e.g. 10th element) is not possible.
    We have used Set before in HashMaps by using keySet() method in which we get set of all keys.
    */

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88); // Creating new Planet.
        solarSystem.put(temp.getName(), temp); // Adding to solarSystem HashMap.
        planets.add(temp); // Adding to planets Set.

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27); // Creating new Moon.
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // Adding tempMoon(Moon) to planet temp(Earth) by using addMoon() method of HeavenlyBody class.

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp here is Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp here is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp here is Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp here is still Jupiter

        tempMoon = new HeavenlyBody("ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp here is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp here is still Jupiter

        temp = new HeavenlyBody("Saturn", 10795);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        // We can perform operations like Union on Sets by using addAll() method.
        // Union between two Sets is a Set of all elements in these two Sets.
        // But each element occurs only once even if that element is present in both the Sets.

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) { // Looping through all planets.
            moons.addAll(planet.getSatellites()); // This will add all the elements of satellites Set of all planets in moons Set.
        }
        // So, after this for loop, moons Set will contain all the moons of all planets.

        System.out.println("All moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }


        /////////////////////////////////// equals() and hashCode() methods //////////////////////////////////

        // Java warns us that if we are using our own objects as keys in Maps or as elements in Sets, then we should override
        // the equals() and hashCode() methods.
        // Below is what will happen if we do not override these two methods.
        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842); // We are adding here Pluto again with different orbitalPeriod.
        planets.add(pluto);
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }
        // As we can see in the above code's output, we have 2 entries for Pluto planet, BUT we know that Set cannot contain
        // duplicate elements, still our 'planets' has 2 same variable named 'Pluto'.
        // This happened because Java objects do not compare equal, so the Set is happy to accept both of them.
        // Even if we use them as keys in Map, same thing will happen as well.
        // The reason that they don't compare equal is because the base object class from which all other classes are derived
        // just defines a very simple equals method that performs what is known as referential equality and both references
        // point to same object then they are equal otherwise they are not.
        // So that's why equals() method needs to be overwritten.

        // BUT if we are overriding the equals() method then we must also override the hashCode() method because if two objects
        // can compare equal then their hash codes must also be the same.

        // So when storing objects in a hashed collections(like HashSets or HashMaps), lets think if the collection is having
        // a number of buckets to store the objects in.
        // So the hashCode determines which bucket and objects gonna go into, Now here there is a requirement that any objects
        // that are equal had the same hashCode so that they can be in same bucket, but the opposite is not required.
        // So we first check the hashCode of the new object to the hashCode of each bucket and then if we find any bucket with
        // same hashCode then the collection class will check that the object is already in that bucket then it will not
        // be added to the collection.

        // So, if two objects compare equal then they must have same hash code.
        // So we add equals() and hashCode() methods in HeavenlyBody class.(from line 33).
    }
}
