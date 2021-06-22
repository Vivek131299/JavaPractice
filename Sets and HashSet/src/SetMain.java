import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");

        // for union
        Set<Integer> union = new HashSet<>(squares); // Copying squares Set into new union Set.
        union.addAll(cubes); // Making union of 'union' Set(which contains squares) and 'cubes' Set by using addAll() method.
        System.out.println("Union contains " + union.size() + " elements");

        // for intersection
        Set<Integer> intersection = new HashSet<>(squares); // Copying squares Set into new intersection Set.
        intersection.retainAll(cubes); // Making intersection of 'intersection' Set(which contains squares) and 'cubes' Set by using retainAll() method.
        System.out.println("Intersection contains " + intersection.size() + " elements");

        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }


        //////////////////////////////// SYMMETRIC Difference and ASYMMETRIC Difference //////////////////////////////////

        // In Set two differences are defined:
        // Symmetric difference and Asymmetric difference.
        // A Java Set interface defines a way to obtain a ASYMMETRIC difference of two sets using the removeAll bulk operation
        // and that remove all elements in one set from another.
        // We call it Asymmetric difference because set1 takes set2 is not the same as set2 takes set1.
        // So set1 takes set2 (set1 - set2) will contain all the elements from set1 except the elements which are common in set1 and set2.
        // And set2 takes set1 (set2 - set1) will contain all the elements from set2 except the elements which are common in set1 and set2.

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine :");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine); // performing nature - divine.
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String>  diff2 = new HashSet<>(divine);
        diff2.removeAll(nature); // performing divine - nature.
        printSet(diff2);

        // Above was for calculating Asymmetric difference.
        // But for Symmetric difference Java does not have any method because that's is used less often
        // SYMMETRIC difference is the opposite of asymmetric difference.
        // Symmetric difference is the elements that appear in one set or the other but not both.
        // So it can be defined as the UNION - INTERSECTION.

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine); // performing union.
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine); // performing intersection.

        System.out.println("Symmetric difference: ");
        unionTest.removeAll(intersectionTest); // performing union - intersection (unionTest - intersectionTest) for Symmetric difference.
        printSet(unionTest);

        // All these methods like addAll(), retainAll(), removeAll() that we have seen above are DESTRUCTIVE METHODS because
        // they modifies the Set on which we are performing operations.
        // For e.g.- unionTest.removeAll(intersectionTest); will modify the unionTest Set for storing the result.


        // containsAll operation. This is also the BULK operation like above (addAll(), retainAll(), removeAll()).
        // But containsAll is used to test it if one set a super set of another.
        // And this is NON_DESTRUCTIVE. Means unlike above methods, it will not modify the Set.
        // It is just testing and returns true or false.

        if (nature.containsAll(divine)) { // checking if divine is a sub set of nature or not.
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) { // checking if intersectionTest is a sub set of nature or not.
            System.out.println("intersectionTest is a sub set of nature");
        }

        if (divine.containsAll(intersectionTest)) { // checking if intersectionTest is a sub set of divine or not.
            System.out.println("intersectionTest is a sub set of divine");
        }



        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords)); // Arrays.asList() method returns a list view of the elements in the Array and is
                                                 // used to store elements of array into the Set.

        for (String s : words) {
            System.out.println(s);
        }
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
