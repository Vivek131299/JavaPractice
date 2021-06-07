public class StaticTest {

    private static int numInstances = 0; // We changed this variable to static later. See comments in Main class for explanation.
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++; // This will get incremented each time we create instance of this class.
    }

    public static int getNumInstances() { // We changed this method to static later. See comments in Main class for explanation.
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
