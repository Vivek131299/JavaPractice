public class StaticInitializers {

    // Static equivalent of constructors are Static Initializers or static initialization blocks.
    // Our normal constructors that we have used will be executed every tine we create a new instance of a class.
    // BUT Static Initialization Block is only executed once when the class is first loaded into the project.
    // static final variable must be initialized by the time all static initialization blocks terminate.

   public static final String owner;

   // Static initialization blocks are declared using the static keyword and followed by the actual code block.
    // There can be as many static initialization block as we want.(We have 2 here).
    // And these are called in the order they're declared in the class.
   static {
       owner = "Tim";
       System.out.println("SIBTest static initialization block called");
   }

    public StaticInitializers() {
        System.out.println("SIB constructed called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
