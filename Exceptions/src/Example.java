import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        try { // We are adding try here later. (See comments from divide method from line 88 and before).
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) { // Checking for multiple exceptions by using Bitwise OR operator.
            System.out.println(e.toString()); // e.toString() quotes the error into the String. So it will show like a String rather than in red error.
            System.out.println("Unable to perform division");
        }
        // Now we can REMOVE try catch blocks from divide method as we are checking in main method.

        // Now, here we can get 2 exceptions - ArithmeticException (if we try to divide by 0), and
        // InputMismatchException (if we give input other than numbers/integers).

        ///////////////////////////// STACK TRACE /////////////////////////////
        // Whenever we call any method it is added to the top of stack by Java and after executing it, it's removed from the stack.
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
        // InputMismatchException extends from NoSuchElementException.
        // and Exception extends from Throwable for throwing errors/exceptions.


        ///////////////////////////// Catching and Throwing Exceptions /////////////////////////////
        // There is no any sense in catching exceptions unless we are doing something with it.
        // For e.g.- If we found InputMismatchException, then we can ask user to input an integer again.
        // So we change getInt method now by adding while with try and catch blocks instead of just returning
        // the accepted value.
    }

    private static int divide() {
        int x, y;

        /**
        try {
            x = getInt();
            y = getInt();
        } catch(NoSuchElementException e) {
            // x = getInt(); // Now here, we are calling getInt again if we found exception but in getInt method we can still get
                             // NoSuchElementException as we are not checking for it there.
                             // So now we use 'throw' to throw an specific exception.

            throw new ArithmeticException("No suitable input"); // throwing ArithmeticException with a message.
        }
        System.out.println("x is " + x + ", y is " + y);

        // Similarly here we add another exception while dividing.
        try {
            return x / y;
        } catch(ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }
        **/


        // So now even if we do ctrl + D (end of line) in input or try to divide by xero then we will get ArithmeticException.
        // And also Stack Trace is a lot simpler now, it's now referring to our code only.

        /////////////// Multi Catch Exceptions ///////////////
        // As we can see above we have multiple try and catch blocks. We can combine them.
        // So what we can do is, we will put everything in try block and then add multiple catch block for each exception
        // that can occur.
        // So we can write above commented code (from line 51 to 68) as:

        /**
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("No suitable input");
        } catch(ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }
         **/

        // But we should check for exceptions in main method. So we add try and catch block in main method.

        // As we have added try catch blocks in main method, we can now remove it from here, instead of above commented code,
        // (from line 82 to 91), we can do as:

        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while(true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                // go round again. Read past the end of line in the input first.
                s.nextLine(); // to read end of line so that we can start on next line.
                System.out.println("Please enter a number using only the digits 0 to 9 ");
            }
        }
        // But this method is not a good way to catch exception as we are only catching InputMismatchException and not
        // NoSuchElementException by which it extends from.
        // If we press ctrl + D (end of line) then it will show us NoSuchElementException.
        // So we change divide method for catching NoSuchElementException.
    }
}
