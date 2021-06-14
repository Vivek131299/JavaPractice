public class SomeClass {

    public final int instanceNumber; // We can also initialize here instead in constructor.
    private static int classCounter = 0;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++; // Incrementing each time we create an instance of this class.
        instanceNumber = classCounter; // And assigning it to instanceNumber. This variable will not change after this constructor as it is Final.
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
