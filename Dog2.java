public class Dog2 extends AnimalAbstractClass {

    public Dog2(String name) {
        super(name); // This super(name) calls the constructor from the AnimalAbstractClass.
    }


    // Below we are implementing(Overriding) two abstract methods from abstract class 'AnimalAbstractClass' that we are inheriting from.
    @Override
    public void eat() {
        System.out.println(getName() + " is eating");  // Because we did implement the getter for the name, getName() in AnimalAbstractClass,
                                                        // its available in this class when we used it here in eat() method
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, Breathe out, repeat");
    }
}
