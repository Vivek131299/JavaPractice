import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Navin", "Manoj", "Priya", "Anto");

        names.forEach(s -> System.out.println(s));
        // Above, forEach will give us one by one value from names List and then that value will be passes to a lambda
        // expression which we have written in it.
        // So lambda will just take that value into parameter 's' and just print it.

        ////////////////////// METHOD REFERENCE //////////////////////
        // As we can see in above code, we are just fetching the value and just printing it.
        // So, instead of above lambda expression what we can do is, we can use METHOD REFERENCE like below:
        names.forEach(System.out :: println);
        // So, in Java we know that we can pass the normal variables or reference variables to a method as a parameter.
        // But in this we are calling method by passing another method as a parameter.
        // So, we are passing 'println' method (which will print the value to console) as a parameter to a forEach method.
        // But if we only pass 'println', it will give an error because by default it expects a variable to be passes.
        // So we need to inform that we need to pass a method and not a variable.
        // So for that we use two colons (::).
        // So we also need to tell that to which class or object this method belongs. And we write it before two colons(::).
        // So, in our case, 'println' method belongs to 'out' object of System class. So we specify System.out before :: .
        // So we can use class name or if it is a object then we can use object name as well.
        // We also need not to pass the parameter to a method.
    }
}
