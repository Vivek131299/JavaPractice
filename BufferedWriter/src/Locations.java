import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException { // Instead of catching of exceptions below and doing nothing on them,
                                                                // it is better to throw an exception with the method.
                                                                // 'throws' tells that this method can throw the specified exception.
                                                                // So now no need of catch blocks below.(commented on line 27 and 38).


        ////////////////////////// BufferedWriter //////////////////////////
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            // In this 'try with resources', format is different, we create object in the bracket.
            // We can create multiple objects in try brackets separated by semicolon like we have done above.
            // We have two objects of FileWriter, locFile and dirFile.

            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
        // As we can see this 'try with resources' block is much neater than previous try block(commented above).
        // It automatically ensures that the FileWriter stream is closed whether the code executes normally or an exception occurs.

    }

    static {

        ////////////////////////// FileReader //////////////////////////
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")))) {
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
        }

        // As we are in static block, we can't just use 'throws' in the main method as we did with above try block (on line 50),
        // because static initialization block executes when the class is loaded. So any exceptions thrown in this will not be
        // caught by our 'throws' in main method.
        // We can throw unchecked exceptions in static initialization block but not checked ones, because unchecked exceptions
        // don't have to be caught.

        ////////////////////////// BufferedReader //////////////////////////
        // BufferedReader reads text from the input stream and buffers the characters into a character array.
        // We can define the size of buffer, but default is fine which is 8K bytes.
        // Now our both files are less than 8K bytes, means the entire contents of the file will be read into the buffer in
        // a single read and be available from there for the scanner to use it as it needs more data.

        // So, for reading the exits:
        try(BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
            String input;
            while((input = dirFile.readLine()) != null) {
                String[] data = input.split(","); // Saving that 'input' String into String array 'data' separated by comma.
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
