import java.nio.IntBuffer;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    // Constructor for Dog class and which will call Animal constructor also.
    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight); // 'super' keyword is to call the constructor of the class that we are
                                         // extending from (Animal). This initialize the Animal class. We have set the
                                         // values of brain and body as 1.
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    // Overriding the eat() method of Animal super class in Dog class using
    // '@override'
    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat(); // This calls super equivalent of that class. So this will call the eat() method
                     // from Animal class.
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        super.move(5); // this will call move() method from Animal class and not move() from current
                       // class because of super keyword.
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10); // this will call move method from current class itself as we have not specified
                  // as super. If it does not find move() method in current class, then it will
                  // call move() method from Animal class.
    }

    private void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
