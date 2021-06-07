
// Challenge:
// In the following interface declaration, what is the visibility of:
//
// 1. the Accessible interface?
// 2. the int variable SOME_CONSTANT?
// 3. methodA()?
// 4. methodB() and methodC()?
//
// Hint: think back to th lecture in interfaces before answering.

interface Accessible {

    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}

// ANSWER to challenge above
// 1. Accessible interface is set to package-private (as we wre not mentioning it as public). So, its accessible to all
//    classes in this package.
// 2. int variable SOME_CONSTANT, the visibility was set to public (all interface variables are public static final).
// 3. methodA() is also public.
// 4. methodB() and methodC() are also public because all interface methods are automatically public.
