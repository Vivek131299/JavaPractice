public class MainInheritance {

    public static void main(String[] args) {

        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");

        // Calling method eat() with Dog object which is defined in Animal
        // class as public, we can access this method because Dog class is inheriting
        // from Animal class, so we can use its public methods.(Inheritance)
        dog.eat();
        dog.walk();
        dog.run();
    }
}
