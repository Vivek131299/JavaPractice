import java.util.Optional;

public class Main {

    //////////////////////// OPTIONAL CLASS ////////////////////////
    // We have come across NullPointerException many times during programming, and there is no way that it automatically
    // handles it. We have to check for null each time manually.
    // So, Java 8, OPTIONAL CLASS was introduced.
    // So, Optional Class tries to avoid NullPointerException but we cannot guarantee that in each case it will handle this
    // Exception. But in most of the cases it handles this Exception.
    // It is a Generic type of class. We have to specify generic type (<>).
    // So, optional Class is like a box or container in which we can keep any value or we can leave it empty.
    // So it will represent that value if we have put that value in it.
    // it has get() method by which we can get the value we have in that box or container (Optional Class).
    // And if we don't have any value in it ot if it is null then also it represents that state.
    // So we can check that it has value or not by isPresent() method.
    // So in short, it can represent both the states i.e. if it has a value and if it doesn't has any value. And is basically
    // a way to handle Null Checks so that we can avoid NullPointerException.
    // It has methods like: empty() - to empty Optional class (container), equals(), filter(), flatMap(),
    // get() - it returns the value if it has or if it doesn't has then it will throw NoSuchElementException,
    // hashCode(), ifPresent(), isPresent(), map(), of(), ofNullable(), orElse(), orElseGet(), orElseThrow(),
    // toString(), etc..

    public static void main(String[] args) {

        //String str = null; // Commenting this to avoid exception thrown by optional.get() because this is null.
        String str = "Learning Optional Class";

        // If we want to check null, what we normally do is:
        if (str == null) {
            System.out.println("This is null object");
        } else {
            System.out.println(str.length());
        }

        // So instead of doing above, we can do this by Optional class:
        Optional<String> optional = Optional.ofNullable(str); // This will store value id str has any or null if it doesn't.

        // So we can check that if optional has value or not by:
        System.out.println(optional.isPresent()); // This will return true if it has a value or false if it is null.

        // We can get a value by using gwt() if it has any or it will throw NoSuchElementException if it is null:
        System.out.println(optional.get());

        // orElse() method will get the value if it has or if it doesn't have (if it is null) then it will print the message which we give.
        System.out.println(optional.orElse("No value in this object"));


        // Below code is for testing getName() method:
        Optional<String> nameOptional = getName();
        System.out.println(nameOptional.orElse("Null return")); // So we can use Optional methods with this nameOptional.
    }

    // We can use it with methods, so that we can perform on it only if it has value to avoid exception.
    // This will be helpful if any other developer is going to use our code and we don't want him to get NullPointerException
    // due to our code/method, so we can set return type of our method as Optional.
    // So other developer can check for null using Optional methods before doing any processing on it.
    public static Optional<String> getName() { // getName() method of type Optional.
        String name = "Vivek";
        return Optional.ofNullable(name);
    }

    // So it is a good practice to make return type Optional of a method if it can return null and other developer is going to use it.
    // It is recommended that instead of defining variables Optional, we should make its getters or method returning it Optional
    // like we did with the above method. Because if we make a variable Optional then it will cause problem in future when wwe want
    // to make that serializable. So we prefer to make getter's/method's return type Optional.
}
