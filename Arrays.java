import java.util.Scanner;

public class Arrays {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntArray; // Decaring variable 'myIntArray' of type integer array.
        myIntArray = new int[10]; // Initializing myIntArray to a new int array with the size 10.

        // We can also write above two lines in one line as:
        // int[] myIntArray = new int[10];
        // Above, we are not directly referring to an object by 'myIntArray', we are
        // referring to an address of an array through that variable.
        // Arrays are reference types so they refers to an address like classes.

        // So, if we create a new array without using 'new' keyword,
        // for e.g.- int[] array2 = array1;
        // So, now both the arrays(array1 and array2) are referring to same address.
        // So, if we change any element of array1, it will affect to array2 also, and
        // vice versa.

        // Wherever we see the 'new' keyword, we are creating a reference to an object.

        myIntArray[0] = 10; // Storing 10 as first element of array.
        myIntArray[1] = 20;
        myIntArray[5] = 60;
        System.out.println(myIntArray[0]);

        double[] myDoubleArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // We can also assign elements like this instead of
                                                                    // assigning one-by-one. But we can do this only at
                                                                    // the time of array initialization.
        System.out.println(myDoubleArray[0]);
        System.out.println(myDoubleArray[4]);
        System.out.println(myDoubleArray[9]);

        // OR we can use for loop to initialize array like below.
        int[] myIntArray2 = new int[10];
        for (int i = 0; i <= 9; i++) { // We can also write this as: for(int i=0; i < myIntArray2.length; i++).
                                       // myIntArray2.length gives the length of an array i.e. 10 in this case.
            myIntArray2[i] = i * 10;
        }
        for (int i = 0; i < myIntArray2.length; i++) {
            System.out.println("Element " + i + ", Value is " + myIntArray2[i]);
        }

        printArray(myIntArray2);

        int[] integers = getIntegers(5);
        printArray(integers);

        double avg = getAverage(integers);
        System.out.println("Average of an array is " + avg);

    }

    // We can also pass an array as a parameter to a method just like any other
    // variable.
    public static void printArray(int[] array) {
        System.out.println("Printing array using printArray() method:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", Value is " + array[i]);
        }
    }

    // Method for getting values of an array from user.
    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values: \r"); // \r is for going to next line.
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    // Method for calculating average of all elements of an array.
    public static double getAverage(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
}
