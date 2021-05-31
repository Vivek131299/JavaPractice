public class MainAbstractClasses {

    // Java also allows ABSTRACT classes.
    // Abstract classes define methods, but do not provide an implementation of those methods.
    // The implementation itself is left to the classes that inherit from the abstract class.
    // This is different from inheriting an interface. You can also inherit from an actual class as well.
    // We CANNOT make an instance(create an object) of an abstract class.
    // Abstract classes can also have member variables that are inherited unlike Interfaces.
    // Interfaces can also have variables but they are all public static final variables which are going to be
    // constant values which are never going to be changed with a static scope. They are static because non-static variables
    // requires instance, and of course we know that we can instantiate an interface.
    // Abstract classes can also have constructors unlike Interfaces.

    // We should use and inherit from an Abstract class rather than interface if it is a 'IS-A' relationship.
    // For e.g.- A Dod is an Animal, Bird is an Animal, A Parrot is a Bird.
    // But problem in this example is that, Birds aren't the only Animals that can fly. Bats acn also fly which are not Birds.
    // So for that, we can rename our Bird class as FlyingAnimals, and have Bats and Birds both inherit from that.
    // But we should be able to see potential problems that can cause. (like all Animals can't fly). So it could be wrong.
    // So, what we are doing WRONG here is putting the fly() method in Bird class.
    // Its better to create a CanFly interface which both Bats and Birds can implement.

    public static void main(String[] args) {

        Dog2 dog = new Dog2("Yorkie");
        dog.breathe();
        dog.eat();

        // Bird bird = new Bird("Parrot"); // We can't do like this because as stated above,
                                            // we can't create an instance of an abstract class.
        // So what we did is, we created another class Parrot which extends from an abstract class Bird and then creating an instance of it.
        Parrot parrot = new Parrot("Ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
