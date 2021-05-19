import java.util.ArrayList;

public class AutoboxingAndUnboxing {

    public static void main(String[] args) {
        String[] atrArray = new String[10]; // String array
        int[] intArray = new int[10]; // int array

        ArrayList<String> strArrayList = new ArrayList<String>(); // String ArrayList
        strArrayList.add("Tim");

        /*** ArrayList<int> intArrayList = new ArrayList<int>(); ***/
        // We cant do like this(ArrayList of type int), because int is a primitive type
        // and ArrayList requires class reference like String is a class and not
        // primitive type so we can create ArrayList of String but not int.(same for
        // double, float, etc.).

        // One long way for creating an ArrayList of int is, we create class 'IntClass'
        // which has int variable and its getter and setter.
        // Now, using IntClass we can create ArrayList of int like following:
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54)); // This will add first element in ArrayList as an object of IntClass
                                                 // with value 54.

        // But as we see this approach is lengthy and messy, So we use Autoboxing and
        // Unboxing for that.
        // We can do like following:
        Integer integer = new Integer(54); // Here, 'Integer' is a inbuilt class.
        // We have such classes for every primitive types(int, double, etc.).
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>(); // Now, we can create an ArrayList with type
                                                                    // 'Integer' and store int value in it because
                                                                    // 'Integer' is a class.
        for (int i = 0; i <= 10; i++) {
            intArrayList.add(Integer.valueOf(i)); // Here, what 'valueOf()' is doing is taking value of 'i' as a
                                                  // primitive type(as i is int) and converting it into 'Integer' class
                                                  // so that we can use it as a class.
            //////////// This is AUTOBOXING ///////////
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " -> " + intArrayList.get(i).intValue()); // Now, here 'intValue()' converts back an
                                                                             // 'Integer' class value into the 'int'
                                                                             // primitive type.
            //////////// This is UNBOXING //////////////
        }

        // Still, above is also the long way approach.
        // The short way is:
        // Beloew is AUTOBOXING
        Integer myIntValue = 55; // Now this is working fine without using 'new' keyword because java itself
                                 // handles that.
                                 // We can also write it as:
                                 // Integer myIntValue = Integer.valueOf(55);
                                 // But even if we dont write it like this, Java will do it at compile time,
                                 // So, no need of writing '.valueOf()'. It automatically converts our '55' from
                                 // primitive type to 'Integer' class object type.
        ///// This is AUTOBOXING //////
        Double myDoubleValue = 55.66; // Same as Integer for Double.

        // Below is UNBOXING
        int myInt = myIntValue; // Now here also, opposite of above is happening. The 'myIntVlaue' which is of
                                // 'Integer' class object type, is getting converted into primitive type(int)
                                // into variable 'myInt'.
                                // Here java is doing like:
                                // int myInt = myIntValue.intValue();
                                // But we don't need to type '.intValue()' as java handles it like '.valueOf()'
                                // above.
        ///// This is UNBOXING /////////

        // Double example below:
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) { // We have just taken double instead of int because we want to
                                                          // add double values into our ArrayList which is of type
                                                          // 'Double'.
            myDoubleValues.add(dbl); // Same as: myDoubleValues.add(Double.valueOf(dbl));
            /////////// AUTOBOXING /////////
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i); // Same as: myDoubleValues.get(i).doubleValue();
            /////////// UNBOXONG //////////
            System.out.println(i + " -> " + value);
        }
    }

}

// One long way for creating an ArrayList of int is, we create class 'IntClass'
// which has int variable and its getter and setter.
// Here we are wrapping int variable. This class is called wrapper.
class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}