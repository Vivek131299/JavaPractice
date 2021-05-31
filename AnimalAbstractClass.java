public abstract class AnimalAbstractClass { // This is the abstract class.

    private String name;

    public AnimalAbstractClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Below are abstract methods.
    public abstract void eat();
    public abstract void breathe();
    // Any class which is inheriting from this abstract class, will need to implement these 2 methods as they are abstract.

    // NOTE that not all methods have to be abstract(like we are defining getName() method which is not abstract).
    // This is one of the difference between abstract class an interface.
    // In interface, the entire interface is completely abstract, and there is no implementation whatsoever.
}
