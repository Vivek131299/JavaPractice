import java.util.Scanner;

public class ArrayResizeDemo {

    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[10];

    public static void main(String[] args) {
        System.out.println("Enter 10 integers:");
        getInput();
        printArray(baseData);
        resizeArray();
        System.out.println("Enter 12 integers:");
        getInput();
        // baseData[10] = 67;
        // baseData[11] = 34;
        printArray(baseData);

    }

    private static void getInput() {
        for (int i = 0; i < baseData.length; i++)
            baseData[i] = s.nextInt();
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Method for resizing array from size 10 to 12.
    private static void resizeArray() {
        int[] original = baseData; // copying baseData array to new original array.

        baseData = new int[12]; // creating new array of size 12 with baseData name.
        for (int i = 0; i < original.length; i++) // Copying previous 10 elements from original array to newly created
                                                  // baseData array of size 12.
            baseData[i] = original[i];
    }

}
