import java.util.Arrays;

public class ReverseArrayChallenge {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println("Array: " + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) { // We are iterating till halfway through array because we need to
                                                     // reverse an array withou tusing any other array or without
                                                     // modifying any element of an array. So, we just swap 1st and last
                                                     // elements, 2nd and 2ndLast, etc. and when we reach halfway, our
                                                     // array is fully reversed. If we go throught the loop till the end
                                                     // (i.e.: i < array.length), then the second half of the elements
                                                     // will again get swapped with first half and we will get same
                                                     // array as original one.
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;

        }
    }
}
