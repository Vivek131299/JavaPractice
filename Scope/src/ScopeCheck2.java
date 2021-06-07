public class ScopeCheck2 {

    public int publicVar = 0;
    private int varOne = 1; // This variable has scope in entire ScopeCheck2 class even if its private. So not only is varOne
                            // in scope within the inner class it's also visible. Same is true for vice versa(see from line 22).

    public ScopeCheck2() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        int varTwo = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * varTwo);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
        // As we can see above, we can access fields of inner class in outer class even if they are private.
    }

    public class InnerClass {
        private int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass created, varOne = " + varOne +  ", varThree = " + varThree);
        }

        public void timesTwo() {
            System.out.println("varOne is still available here " + varOne);
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times three is " + i * varThree);
            }
        }
    }


}
