import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException { // Instead of catching of exceptions below and doing nothing on them,
                                                                // it is better to throw an exception with the method.
                                                                // 'throws' tells that this method can throw the specified exception.
                                                                // So now no need of catch blocks below.(commented on line 27 and 38).

        // We can write below commented code with 'try with resources' approach (from line 50).
        /**
        FileWriter locFile = null;
        try {
            locFile = new FileWriter("locations.txt");
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                throw new IOException("test exception thrown while writing"); // We can throw exception purposely like this for testing.
            }
            //locFile.close();
            // Here is one problem that if there is any exception occurred in try block in for loop then control will be gone to
            // catch block by SKIPPING .close() method which will not close the file and file be still be opened.
            // So what we can do is we can write this close() method in finally{} block.
            // FINALLY BLOCK always executes no matter what is the situation of try and catch block.
            // try block can have either catch block or finally block. It need not to have both. It must have at least one.
//        } catch(IOException e) {
//            System.out.println("in catch block");
//            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
            // But directly writing close() here can also throw exception. So again, we will write it in try block here.
//            try {
                if (locFile != null) {
                    System.out.println("Attempting to close locFile");
                    locFile.close();
                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        // If there exists a folder of same name as of our file name (i.e.- locations.txt), then it will give us an
        // error/exception (FileNotFoundException).
**/

        ////////////////////////// TRY WITH RESOURCES //////////////////////////
        try (FileWriter locFile = new FileWriter("locations.txt");
             FileWriter dirFile = new FileWriter("directions.txt")) {
            // In this 'try with resources', format is different, we create object in the bracket.
            // We can create multiple objects in try brackets separated by semicolon like we have done above.
            // We have two objects of FileWriter, locFile and dirFile.

            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
        // As we can see this 'try with resources' block is much neater than previous try block(commented above).
        // It automatically ensures that the FileWriter stream is closed whether the code executes normally or an exception occurs.

    }

    static {
        // As we were adding exits manually before(commented below), now we try to read the data (from line 109)
        // from files created above instead of adding manually.
        /**
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
         **/

        ////////////////////////// FileReader //////////////////////////
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations.txt")); // To read from 'locations.txt' file.
            scanner.useDelimiter(","); // To tell the scanner that our information is separated by comma(,).
            while(scanner.hasNextLine()) { // To loop through each line till we have data(lines) by using .hasNextLine().
                int loc = scanner.nextInt(); // In file, we have stored the location which is int, so accessing that using scanner,nextInt() to 'loc'.
                scanner.skip(scanner.delimiter()); // It will skip the delimiter which we have set above (which is comma) and continue forward.
                String description = scanner.nextLine(); // This will get the String (description) on that line till the end of the line.
                System.out.println("Imported loc: " + loc + ": " + description);

                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close(); // When we close scanner, it takes care that any Stream its using (like FileReader here) closes itself.
                                 // So, no need to close FileReader object here.
            }
        }

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
