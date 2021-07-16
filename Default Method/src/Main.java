public class Main {

    ///////////////////// DEFAULT METHOD in Interface /////////////////////
    // As we know we can only DECLARE methods in an Interface and we cannot DEFINE them like in abstract class.
    // But from Java 8, we can also DEFINE methods in an Interface.
    // But we can't define it normally as we do like: void myMethod() {...}. This will give us an error.
    // So, we define a method in an Interface by using 'default' keyword like: default void myMethod() {...}.
    @FunctionalInterface // We can also make this Interface as functional even if it has 2 methods.(See comments from line 45).
    interface Demo {
        void myDeclaredMethod();
        default void myDefinedMethod() {
            System.out.println("Hello from default method.");
        }
    }

    static class DemoClass implements Demo {
        @Override
        public void myDeclaredMethod() {
            System.out.println("Hello from myDeclaredMethod from DemoClass.");
        }

        // As we can see above as we are implementing Demo Interface which has two methods, one of them is default.
        // So we don't have to compulsory implement/override that myDefinedMethod() method in this class as we have
        // already defined using 'default' it in our Demo Interface unlike myDeclaredMethod() method.

        // We can also override default method if we want.
        /**
        @Override
        public void myDefinedMethod() {
            System.out.println("Hello from overridden myDefinedMethod from DemoClass.");
        }**/
    }

    public static void main(String[] args) {

        DemoClass demoClass = new DemoClass();
        demoClass.myDeclaredMethod();
        demoClass.myDefinedMethod();

        // So as we can see we are able to access our default method by using DemoClass's object even if we have not
        // implemented/overridden it in DemoClass. That's because the method has already implemented in Demo Interface
        // and inherited from it while we implemented Demo Interface into DemoClass class (class DemoClass implements Demo).


        // Now we can make our Demo Interface as Functional Interface (Functional Interface is which has only one abstract method)
        // even if we have 2 methods in it. And that's because we have only one abstract method (myDeclaredMethod()) and
        // the other one is default method (myDefinedMethod()).
        // So as long as we have only one abstract method, we can make that Interface as Functional Interface even if we
        // have multiple default methods.

    }
}
