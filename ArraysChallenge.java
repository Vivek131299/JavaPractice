import java.util.Scanner;

public class ArraysChallenge {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] unsortedArray = getIntegers();
        System.out.println("Entered unsorted array: ");
        printarray(unsortedArray);
        int[] sortedArray = sortIntegers(unsortedArray);
        System.out.println("Sorted array: ");
        printarray(sortedArray);
    }

    public static int[] getIntegers() {
        int[] array = new int[5];
        System.out.println("Enter the elements of an array: \r");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printarray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = array;
        for (int i = 0; i < (sortedArray.length - 1); i++) {
            for (int j = 0; j < (sortedArray.length - 1); j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}
