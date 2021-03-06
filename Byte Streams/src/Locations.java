import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        ////////////////////////// Byte Streams //////////////////////////

        ////////////////////////// Writing Binary data //////////////////////////
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID()); // For writing int value.(locationID).
                locFile.writeUTF(location.getDescription()); // For writing String value.(description).
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1); // Deducting 1 because we don't wanna recall 0 for quit.
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }

    }

    static {

        ////////////////////////// Reading Binary data //////////////////////////
        try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
//            while (true) {
            while (!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                } catch(EOFException e) {
                    eof = true;
                }

            }
        } catch(IOException io) {
            System.out.println("IO Exception");
        }
        // This while loop will be exited automatically after file has been completed reading by throwing EOF(End Of Line) Exception
        // which is a sub class of IOException.
        // So this EOFException will terminate the while loop and catch block will catch that Exception.
        // BUT this is not a good way of ending a while loop because if due to any other reason IOException is raised then
        // we won't be able to know that something else has caused the loop to terminate.
        // So we change the while loop condition with the boolean 'eof' variable and then adding another try block inside while loop
        // and then inside this try block we will read the data from the file.

//
//        ////////////////////////// FileReader //////////////////////////
//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")))) {
//            scanner.useDelimiter(","); // To tell the scanner that our information is separated by comma(,).
//            while(scanner.hasNextLine()) { // To loop through each line till we have data(lines) by using .hasNextLine().
//                int loc = scanner.nextInt(); // In file, we have stored the location which is int, so accessing that using scanner,nextInt() to 'loc'.
//                scanner.skip(scanner.delimiter()); // It will skip the delimiter which we have set above (which is comma) and continue forward.
//                String description = scanner.nextLine(); // This will get the String (description) on that line till the end of the line.
//                System.out.println("Imported loc: " + loc + ": " + description);
//
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // So, for reading the exits:
//        try(BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
//            String input;
//            while((input = dirFile.readLine()) != null) {
//                String[] data = input.split(","); // Saving that 'input' String into String array 'data' separated by comma.
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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
