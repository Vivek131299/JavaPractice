import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* Our Game map is like below:
*
*                       /-----------------> 5. Forest                                         NORTH
*                       |                       ^                                               ^
*                       |                       |                                               |
*                       |                       |                                               |
*                       v                       v
*                  2. Hill  <------------- 1. Road  <------------->  3. Building
*                       ^                       ^
*                       |                       |
*                       |                       |
*                       |                       v
*                       \------------------ 4. Valley
* */


public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>(); // Defining a new HashMap for storing locations.
    // Here, Location is a class we defined which takes 2 parameters (locationID and description) in constructor while creating an instance.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
        Commenting this after we removed addExit() method from Location class and defined a new temporary Map below.
        Instead of this we are now pasting these line one ny one after putting exits for each location fromline 51.
        // Adding locations:
        locations.put(0, new Location(0, "You are sitting in front of computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road."));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));
        // As we can see above we are creating a new object Of Location class as a value for keys 0,1,2,3,4,5 which has
        // 2 parameters, 1st is locationID (0,1,2,3,4,5) and 2nd is description which is a String.
*/
        

        /*
        * We are adding this later on because we changed the constructor of Location class.
        * Since we have removed the addExit() method from Location class, we have to create a temporary Map here to 
        * add exits and then pass that to a constructor.
        * */
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        // For location 0
        locations.put(0, new Location(0, "You are sitting in front of computer learning Java", tempExit));


        // For location 1 (Road):
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road.", tempExit));

        // For location 2 (Hill):
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        // For location 3 (Building):
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building", tempExit));

        // For location 4 (Valley):
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        // For location 5 (Forest):
        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));

        // After doing above, we are also able to delete the part of the Map like:
        // tempExit().remove("S");
        // So if we run program then we will not find South direction for location 5.
        // This is happening because we are still referring to exits Map for location 5.
        // To solve this, we will do same as we did for getExits() method but only now we are going to apply it to setter
        // instead of a getter.
        // So we are now changing the constructor of Location class.(on line 14 of Location class). By doing this, we are
        // not sharing any references of tempExit Map of this class with the exits Map of Location class.

        // Now, even after we remove the direction from tempExit (like on line 87), we will still see South as direction.

        // And now we can say that the class is now a fully IMMUTABLE class.
        
        
        
/* Commenting this after we removed addExit() method from Location class and defined a new temporary Map above.
   Instead of this, we have written above code from line 47 to 66.
        // For adding exits to locations using addExit() method in Location class which takes
        // 2 parameters- direction(North, East, West, South) and location(0,1,2,3,5).

        // For location 1 (Road):
        locations.get(1).addExit("W", 2); // See above game map(from line 5) for directions and locations.
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
//        locations.get(1).addExit("Q", 0); // Q and 0 for quit.

        // For location 2 (Hill):
        locations.get(2).addExit("N", 5);
//        locations.get(2).addExit("Q", 0);

        // For location 3 (Building):
        locations.get(3).addExit("W", 1);
//        locations.get(3).addExit("Q", 0);

        // For location 4 (Valley):
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
//        locations.get(4).addExit("Q", 0);

        // For location 5 (Forest):
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
//        locations.get(5).addExit("Q", 0);             // We were adding Q for 0 to quit in every location, so to avoid redundant
                                                        // code, we are removing(commenting) this from here and adding to Location
                                                        // constructor.
*/

        // Map for some words that we will accept instead of just N,E,W,S :
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription()); // Here we are accessing the value of key 'loc' which is nothing but
                                                                     // the object of the Location class and then we are getting the 'description'
                                                                     // of that object from Location class by using .getDescription() method.
            if (loc == 0) {
                break;
            } // If we input 0 then description of key 0 will be printed and we will break this loop to stop running program.

            Map<String, Integer> exits = locations.get(loc).getExits(); // Getting the exits for location loc by .getExits() method into new Map 'exits'.
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) { // Looping through keys of exits Map using .keySet() method which returns set of keys.
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) { // if entered direction is other than N,E,W,S.
                String[] words = direction.split(" "); // getting words by splitting a String direction by " "(space).
                for (String word : words) { // looping through above splitted words array.
                    if (vocabulary.containsKey(word)) { // check if word is in vocabulary Map as a key.
                        direction = vocabulary.get(word); // getting corresponding direction(N,E,W,S) of word.
                        break;
                    }
                }
            }
            // Due to above if() condition, even if we entered "go east" (OR "can I go to east") instead of "E", then also
            // it will split our String into words ('go' and 'east') and check each of them in vocabulary Map and then
            // set corresponding value/direction (N,E,W,S) to the 'direction' variable.

            if (exits.containsKey(direction)) { // To check if entered direction is valid. Means to check entered direction(N,E,W,S) is available in that location's 'exits' Map or not.
                loc = exits.get(direction); // Getting location(0,1,2,3,4,5) of the corresponding direction entered.
            } else {
                System.out.println("You cannot go in that direction");
            }

        }


        /*
        /////////////// split() method of String class /////////////
        System.out.println("===================== split() method of String class =======================");

        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
        // Above, we are defining a new String array 'road'. But we are using .split() method to split the String("You are standing .....)
        // into elements of array by using specified delimeter/parameter(which is " "(space) in this case).
        // So it will split the String wherever it finds " "(space) and store it into array 'road'.
        // So our array 'road' will contain elements like: "You", "are", "standing", . . and so on.
        for (String i : road) {
            System.out.println(i);
        }
        System.out.println("-------------------------");

        String[] building = "You are inside a building, a well house for a small spring".split(", ");
        // Now, above .split() will split String wherever it finds ", " (comma followed by space) in the String.
        for (String i : building) {
            System.out.println(i);
        }
        */


        /*
        * /////////////////////////////// IMMUTABLE CLASSES ////////////////////////////////
        * 
        * Immutable classes cannot be changed once they are created just like final variables.
        * By doing this, instance of such class will be Immutable.
        * We do this for encapsulation.
        * If a class field or elements of immutable class like a list or a map is to be set once and never change again
        * then what it needs to be done and where it needs to be set is in the Constructor.
        * 
        * So we are now changing the Location class constructor to accept the map object and will change our constructor
        * signature and assign the passed map to our class fields. This means we can delete the addExits() method. 
        * */
    }
}
