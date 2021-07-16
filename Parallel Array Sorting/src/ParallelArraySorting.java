import java.util.Arrays;

public class ParallelArraySorting {

    ////////////////////// Parallel Array Sorting //////////////////////
    // It is used to sort the elements of anArray parallely.

    public static void main(String[] args) {

        int[] array = {9, 4, 5, 3, 1, 7, 2};

        for (int i : array) {
            System.out.print(i + " ");
        }

        Arrays.parallelSort(array); // parallelSort() method will sort the 'array' Array parallely.
        System.out.println();
        for (int i : array) {
            System.out.print(i + " ");
        }

        // We can also specify the range of specific indexes to which we want to sort.
        // For e.g.- if we wan to sort elements from index 0 to 2 (first 3 elements), then we have to specify the
        // range as 0 to 3, because it will not include index 3.
        int[] array2 = {9, 4, 5, 3, 1, 7, 2};
        Arrays.parallelSort(array2, 0, 3); // So this will sort Array 'array' from index 0 to 2 and rest of the
                                                          // elements will be at same place.
        System.out.println();
        for (int i : array2) {
            System.out.print(i + " ");
        }


    }
}
