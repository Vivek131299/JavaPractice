public class Main {

    public static void main(String[] args) {

        String privateVar = "this is private to main()";

        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("scopeCheck privateVar = " + scopeCheck.getPrivateVar());
        System.out.println(privateVar);

        scopeCheck.timesTwo();

        System.out.println("*************************************");

        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        innerClass.timesTwo();


        // Below code is for testing ScopeCheck2 class

        String varFour = "this is private to main()";

        ScopeCheck2 scopeCheck2 = new ScopeCheck2();
        scopeCheck2.useInner();
        System.out.println("scopeCheck varOne = " + scopeCheck2.getVarOne());
        System.out.println(varFour);

        scopeCheck2.timesTwo();

        System.out.println("*************************************");

        ScopeCheck2.InnerClass innerClass2 = scopeCheck2.new InnerClass();
        innerClass2.timesTwo();

        //System.out.println("varThree is not accessible here: " + innerClass2.varThree);
        // Above, we can't access varThree variable of InnerClass class of ScopeCheck2 class because, varThree has
        // private access and therefore has no visibility outside its class or a containing class(outer class) of its class.
    }
}
