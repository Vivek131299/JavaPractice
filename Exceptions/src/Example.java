import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        int result = divide();
        System.out.println(result);
        // Now, here we can get 2 exceptions - ArithmeticException (if we try to divide by 0), and
        // InputMismatchException (if we give input other than numbers/integers).

        ///////////////////////////// STACK TRACE /////////////////////////////
        // Whenever we call any method it is added to the top of stack by Java and after executing it, it's removed the stsck.
        // It is helpful in case of any exceptions to find where is code going wrong and in which method.
        // For e.g.- above, if we entered characters other than integer then it will throw InputMismatchException and it will
        // show in which methods and on which ine did error occurred. We need to Trace this Stack from bottom because the method
        // at bottom was called first. So we move from bottom to top.
        // For e.g.- In above InputMismatchException, it will show us main method at the bottom, then divide method above it
        // and then getInt method with respective line numbers.

        ///////////////////////////// CALL STACK /////////////////////////////
        // From above thrown InputMismatchException, we can see that above getInt method also there are some Java internal files
        // are shown. So this is Call Stack.
        // So this Calls stack one by one depending in which file and line did exception/error occurred.
        // Like we see in exception - nextInt method is shown then above it next method and above it throwFor method.
        // So basically, in case of any exception/error, java traces stack and calls back methods one by one till it finds
        // the one which can handle the exception and can throw it.
    }

    private static int divide() {
        int x = getInt();
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        return s.nextInt();
    }
}
