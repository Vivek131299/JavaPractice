import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
        this.exits.put("Q", 0); // Q and 0 for quitting. (See comment from line 69 in Main class).
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); // Here, instead of returning the exist Map, we are creating a new HashMap and
                                                    // passing exits in the constructor. Basically we are just returning the copy of exist Map,
                                                    // we are doing this because nothing outside this class can change exits.
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
