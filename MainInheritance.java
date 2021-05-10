public class MainInheritance {

    public static void main(String[] args) {

        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
        Dog anotherDog = dog; // Here, we are referencing to a same object through 'anotherDog' and as well as
                              // 'dog' as we are assigning 'dog' to 'anotherDog'.
        // So if we change any variable
        // using the reference 'anotherDog', we will get changed variable even if we try
        // to access using 'dog' reference and vice versa.
        // Hence, even if the references are different, they are updating only one
        // variable because they are pointing to same address. And if anyone of the
        // references tries to change the value, then another will also affected.

        // Calling method eat() with Dog object which is defined in Animal
        // class as public, we can access this method because Dog class is inheriting
        // from Animal class, so we can use its public methods.(Inheritance)
        dog.eat();
        dog.walk();
        dog.run();
    }
}
