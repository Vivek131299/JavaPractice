import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int x = 98;
        int y = 0;
        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));
        //System.out.println(divide(x, y));

        //x = getInt();
        x = getIntLBYL();
        System.out.println("x is " + x);

        x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int divideLBYL(int x, int y) { // We are using here LBYL (Look Before You Leap) means we are checking
                                                 // value of y before performing operation on it.
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) { // We are using EAFP (Easy to Ask for Forgiveness than Permission) means
                                                  // we are trying for operation and if it gives error then we are catching it.
        try { // So if everything is executed without error in this try block then catch block will not execute. and if any
              // error/exception is found then it will execute catch block for specified exception(ArithmeticException in this case).
            return x / y;
        } catch(ArithmeticException e) { // Catching Arithmetic Exception. We can also write it as only 'Exception e' instead
                                         // of 'ArithmeticException e' because these type of Exceptions are sub classes of
                                         // one Exception class. But it is good to be more specific/generic like we did here.
            return 0;
        }
    }
    // We can use any of the above approaches from LBYL or EAFP to solve Exception problem.

    private static int divide(int x, int y) { // This method will crash program due to ArithmeticException because we are not checking for it here.
        return x / y;
    }


    private static int getInt() { // In this method if we characters other than numbers(int), it will crash the program
                                  // by InputMismatchException.
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntLBYL() { // In this method, we are checking that if user has entered any character other than integers.
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String inout = s.next();
        for (int i = 0; i <inout.length(); i++) { // Looping through user accepted String.
            if (!Character.isDigit(inout.charAt(i))) { // checking if current character is other than digit (integer).
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(inout);
        }
        return 0;
    }

    private static int getIntEAFP() { // In this method, we are checking user input as digit by using exception (try catch block).
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        try {
            return s.nextInt();
        } catch(InputMismatchException e) { // Catching InputMismatchException, if user enters characters other than integer.
            return 0;
        }
        // As we can see there is less code here as compared to LBYL.
    }
}
