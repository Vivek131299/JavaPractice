public class Main {

     ////////////// The FINAL statement ////////////////
    // We use FINAL keyword to generally define constant values.
    // Final fields are not actually constants, because they can be modified but only once, and any modification must
    // be performed before the class constructor finishes.
    // This means, we can assign a final field it's value either when we first declare it, or in the constructor.

    // The values which are constants are declared as STATIC FINAL.

    public static void main(String[] args) {
        SomeClass one = new SomeClass("One");
        SomeClass two = new SomeClass("Two");
        SomeClass three = new SomeClass("Three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        //one.instanceNumber = 4; // We can't do like this because instanceNumber is a Final variable in SomeClass so we
                                // can't modify it once the instance of class is created.

        // The values which are constants are declared as STATIC FINAL. For e.g.-
        System.out.println(Math.PI);
        // Here PI is declared as public static final double as it is constant as its value won't change.

        //Math math = new Math(); // Here we can't create an instance of Math class. Because creators of Math class has
                                // declared Math class constructor as Private so we can't initialize it.
                                // This is done because all fields and methods of Math class are static so we can access
                                // them without creating an instance, so there is no need of creating an instance.

        // But now we might think that we can create a subclass of Math which we can instantiate, but creators have think of
        // this and they have stopped us from doing this by declaring the Math class as FINAL.
        // So by marking a class as FINAL, it prevents the class from being sub-classed. So we can't do 'SomeClass extends MAth'.

        // But, if we only want some methods to prevent from overriding them then we can mark that methods as final instead
        // of declaring whole class as final. So, we will be able to extend that class and create its instance but we can't
        // only override the Final methods.(See Password class).

        int pw = 674312;
        Password password = new Password(pw);
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9773);
        password.letMeIn(-2);
        password.letMeIn(674312);

        // So we are encrypting and decrypting the password using encryptDecrypt() method in Password class,
        // But problem occurs when we try to override the storePassword() method by creating subclass of Password class.
        // For e.g.- See ExtendedPassword class.
        /*int pw2 = 674312;
        Password password2 = new ExtendedPassword(pw);
        password2.storePassword();*/
        // The output we see here is the original password and nit the encrypted password.
        // So this is how we have overridden the method and we have completely changed the security of Password class.

        // So to avoid this, what we can do is we need to declare the storePassword method as Final.


        /////////////// Below is code for testing StaticInitializers class //////////////////

        System.out.println("*********************************************");
        System.out.println("Main method called");
        StaticInitializers test = new StaticInitializers();
        test.someMethod();
        System.out.println("Owner is " + StaticInitializers.owner);

        // So in the output we can see that the both static initializers blocks are called before the constructor, because
        // that's how static initializers work.(See comments in StaticInitializers class).
    }

}
