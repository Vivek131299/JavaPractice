import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    // Map is not a part of a Collection exactly.
    // Map interface replaces the now absolute dictionaries abstract class and like the class that replaces it maps keys
    // to values.
    // Java Map cannot contain duplicate keys and each key can only map to a single value.
    // Maps like all the core collection interfaces are generic, they take two types , one for key and one for value.
    // It is possible to use raw Maps where the types aren't specified, but that's not good idea in generics.
    // Maps are HashMaps, LinkedHashMap. There is also TreeMap which implements sortedMap interface and not Map interface.

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>(); // Before, the class name was Map, so we were using the Java keyword
                                                         // for class name so it was giving error while declaring Map, So we refactored
                                                         // the class name to Maps. Other way was to use java.util.Map while declaring.
        // Storing keys and values in hashMap.
        languages.put("Java", "a compiled high level, object oriented, platform independent language");
        languages.put("Python", "an interpreted, object oriented, high level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");

        // Retrieving from hashMap.
        System.out.println(languages.get("Java"));

        // Keys are unique in Maps.
        // So if we try to use the value again to store in key already available then new value gets overwritten and we don't
        // get any error. Just old value gets overwritten by new value.
        languages.put("Java", "this course is about Java"); // Overwriting value of key 'Java'.
        System.out.println(languages.get("Java"));

        // put() method itself can be used to tel if a value is being added for the first time.
        // It RETURNS the previous value if there was one before.
        System.out.println(languages.put("Lisp", "Therein lies madness"));
        // Above, the output we got here is null, because this was a new key value pair or new reference.
        System.out.println(languages.put("Lisp", "No one uses this"));
        // Above, we got the output as previous value of 'Lisp' key (i.e. "Therein lies madness"), because the value for this
        // key was already available in hashMap.
        // But the value has been updated to new one :
        System.out.println(languages.get("Lisp")); // So, this confirms that value has been updated.

        // We can use .containsKey() method to find whether the key is present in Map or not. So we can ensure that no key
        // is overwritten.
        if (languages.containsKey("Python")) {
            System.out.println("Python is already in the Map");
        } else {
            languages.put("Python", "good for data science");
            System.out.println("Python added successfully");
        }

        // for removing the entry from Map.
        languages.remove("Lisp");
        // We can also do like below for removing entry with specific key value pair:
        if (languages.remove("Algol", "a family of algorithmic languages")) { // This will not remove because value we defined earlier for Algol is different.
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key value pair not found");
        }
        // .remove() method returns true or false.

        // for replacing.
        // .replace() is used to replace the entry for a specified key if its already mapped to a value.
        System.out.println(languages.replace("BASIC", "one of the old languages")); // this will replace the BASIC value and will return previous value.
        System.out.println(languages.replace("Scala", "this will not be added")); // this will not be replaced because there is no entry for Scala in our Map to replace.
                                                                                  // this will return null.
        // UNLIKE .put() method, this .replace() method will not add the entry if its not there. It will only replace if it already exists.

        // Just like remove, we can replace the entry if the key was mapped to the old value which we originally specified.
        // To do this we specify the expected old value before the new one:
        if (languages.replace("BASIC", "this will not work", "old language")) { // this will not work because old value we specified does not match with existing value of BASIC.
            System.out.println("BASIC replaced");
        } else {
            System.out.println("BASIC not replaced");
        }

        if (languages.replace("BASIC", "one of the old languages", "old language")) { // this will work because old value we specified matches with existing value of BASIC.
            System.out.println("BASIC replaced");
        } else {
            System.out.println("BASIC not replaced");
        }

        System.out.println("=====================================================");

        // for printing Map contents.
        for (String key : languages.keySet()) { // .keySet() method returns a set of keys. So we are looping through all keys in languages Map.
            System.out.println(key + " : " + languages.get(key));
        }
        // NOTE: the keys and values are not printed in order as we entered them.
        //       Not also in alphabetical order.
        //       There is no guarantee in ordering in hashMap.
    }

}
