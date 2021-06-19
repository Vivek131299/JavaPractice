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
    }
}
