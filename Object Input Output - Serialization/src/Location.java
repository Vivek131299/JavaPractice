import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

////////////////////////////////// SERIALIZATION //////////////////////////////////
// Previously we have seen that we use readInt/writeInt and readUTF/writeUTF to read and write each object field individually.
// If object had 20 fields, we would have to call 20 methods.
// So instead of that, we can use the ObjectInputStream and ObjectOutputStream classes to read and write objects as a single unit.
// When we write a object to a file, it has to be translated to a format that can be stored to a file and then reassembled into a
// object later when it's read by an application.
// This process is called as SERIALIZATION.
// So we achieve this we make the class Serializable by implementing Serializable Interface.
// So after making class Serializable, it is recommended tha we declare the long field called serialVersionUID. If we do not declare
// it, the compiler will take default value but this can lead to problems. It is like a version number for a class.
// We need to change this serialVersionUID if we make any change class like adding any field or method or changing return type,
// otherwise it will be a compatibility problem and runtime will throw an InvalidClassException.

public class Location implements Serializable { // Implementing Serializable Interface to use Serialization.
    // If we want a class to be serialize, then all the fields are also need to be serializable.
    // Here, Map already implements Serializable Interface, so no need to write code for that.
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    private long serialVersionUID = 1L;

    public Location(int locationID, String description, Map<String, Integer> exits) { // We are adding Map exits later on.(See comments from line 153 in Main class).
        this.locationID = locationID;
        this.description = description;
        //this.exits = new HashMap<String, Integer>();
        if (exits != null) { // This is to avoid crashing of a code after running from null pointer exception if we passed null as a exits Map.
            this.exits = new LinkedHashMap<String, Integer>(exits);
        } else {
            this.exits = new LinkedHashMap<String, Integer>(); // To create empty Map if we passed null as a exits Map because we don't have any directions now.
        }
        this.exits.put("Q", 0); // Q and 0 for quitting. (See comment from line 69 in Main class).
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits); // Here, instead of returning the exist Map, we are creating a new HashMap and
                                                    // passing exits in the constructor. Basically we are just returning the copy of exist Map,
                                                    // we are doing this because nothing outside this class can change exits.
    }

    /*
    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
    */ //Commenting addExit() method because we are getting all the the exits when the objects constructed in the constructor.
       // See comment on line 10.

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
