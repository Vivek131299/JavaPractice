public abstract class Bird extends AnimalAbstractClass implements CanFly { // We are creating this 'Bird' class as also abstract, because we
                                                        // want one abstract fly() method because not all birds can fly.
                                // So this is an abstract class itself which is extending from an another abstract class.
                            // Also, we are implementing an interface 'CanFly' (explanation on this in MainAbstractClasses file from line 9).

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, Breathe out, repeat");
    }

    //public abstract void fly(); // See MainAbstractClasses file(from line 9) for explanation for removing this method.
    // Instead of above, we do below:


    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wings.");
    }
}
