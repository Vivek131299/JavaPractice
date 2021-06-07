public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": privateVar = " + privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        int privateVar = 2; // This variable has local scope to this method only.
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * privateVar); // Here privateVar variable is used which we declared in this
                                                                        // method above and not on line 3.
            // Because by default the variable which is within the most local scope of method is preferred.
            // And if it doesn't finds any variable within the block then it checks the outer block which encloses the current block.
            // For e.g.- Above we used privateVar variable inside the for block, but we don't have variable declaration in for block,
            // so Java checks its outer block i.e. timesTwo() method block which has that variable so it takes that for execution.
            // In case, it our timesTwo() method does not have variable declaration, then Java will check again its outer block i.e.
            // ScopeCheck class and and then take that variable for execution i.e. variable declared on line 3.

            // But, in some case, if we want to use the privateVar variable from class scope(i.e. declared on line 3), while we have
            // also declared privateVar variable in method, then we can use "this.privateVar".
            // Here, 'this' will tell Java that we want to use variable from the class scope and not from any local scope.
        }
    }

    public class InnerClass {
        public int privateVar = 3;

        public InnerClass() {
            System.out.println("InnerClass created, privateVar = " + privateVar);
        }

        public void timesTwo() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times three is " + i * privateVar);
                // Here, it is taking privateVar variable from most local possible which is in this case from InnerClass
                // i.e. declared on line 32.
                // But, if we remove/comment declaration from this class (on line 32), then it will search for declaration
                // in its outer block which is in this case our ScopeCheck class, and take variable declared there(i.e. on line 3).

                // And as we know to access variable declared in class while also declared in local method, we use 'this'
                // keyword. BUT in this case, if we have declared variable in this class(InnerClass) and we also have
                // in outer class (ScopeCheck class) and then we want to access variable from outer class, then we can do:
                // ScopeCheck.this.privateVar     : so this will access privateVar declared in ScopeCheck class (i.e. on line 3).
                // And same as above if we want to access method from outer class then we can do:
                // ScopeCheck.this.timesTwo()    : this will call method declared in ScopeCheck class (i.e. on line 13).
            }
        }
    }


}
