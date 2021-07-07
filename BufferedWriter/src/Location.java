import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

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
