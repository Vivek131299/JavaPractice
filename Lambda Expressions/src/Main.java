
/////////////////////////// LAMBDA EXPRESSIONS ///////////////////////////
// Lambda expressions provide us easier way to work with Interfaces that have ONLY got ONE method. Such Interfaces are
// also called as Functional Interfaces.
// They are often used in place where we use Anonymous classes.
// It was introduced in Java 8.

import java.util.*;

public class Main {

    public static void main(String[] args) {

        new Thread(new CodeToRun()).start();

        // Instead of above,we can also start new Thread by using anonymous class like below:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable from Anonymous class.");
            }
        }).start();

        // As we can see above anonymous class, only println line is what we care about, else everything was a sort of
        // filler code to get it to be executed. In other words, other code is to instantiate an object and implement
        // the single method in the Runnable Interface.
        // Now, it will be easier if we need to only pass println line statement to the Thread constructor and not have
        // to write all the extra code that isn't really doing anything.
        // So, using LAMBDA Expression we can do that.

        new Thread(()-> System.out.println("Printing from the Runnable from Lambda expression.")).start();

        // Now every Lambda expression has 3 parts, First one is argument list, Second one is an arrow token and
        // Third one is the body.
        // So in our above lambda expression, we have empty argument list, an arrow token(->) is just the dash(-) and
        // greater than sign(>), and the body is the code that we want to run which in our case is println statement.

        // If we want to contain multiple lines in Lambda instead of just one line like above, we can do that by surrounding
        // the lambda's body with curly braces({}) just like we do for any code block and separate lines by a semicolon(;).

        new Thread(()-> {
            System.out.println("Printing from the Runnable from multiline Lambda expression");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();


        // Below code is for testing 'Employee' class.
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        // To sort employees List by name in ascending order:
        /**Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });**/

        // Now we can do above sort by using lambda also even though there are 2 methods(compareTo() and equals()) we
        // can implement, because the equals() method will always have a default implementation.
        // NOTE: All classes descend from Object and Object contains an equal() method and that means that every instance
        //       that implements Comparator will already have an implementation of the equals() method.
        // Therefore, the Comparator interface only has a single method that always has to be implemented by classes that
        // implement it.

        Collections.sort(employees, (Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));

        // So, as we can see above, we are passing Lambda as the second parameter instead of anonymous Comparator to sort() method.
        // So the first part of above lambda expression which is argument list is employee1 and employee2, second part is
        // an arrow token and the third part is body which is code for comparison.
        // We can also simplify above lambda expression further. The compiler can infer parameter types and we don't need to
        // include types in our lambda.
        // So in our case, teh compiler can infer from the first parameter 'employees' that the objects to be compared were
        // both be type of type 'Employee'.
        // So we can write it without specifying the type as:

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));


        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }


        // Below code is to test doStringStuff() method and UpperConcat Interface.
        // First, we will write anonymous class to override the only method in UpperConcat Interface.
        String sillyString = doStringStuff(new UpperConcat() { // Calling doStringStuff() method with first parameter which is anonymous class.
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        },
        employees.get(0).getName(), employees.get(1).getName()); // second and third parameters.

        System.out.println(sillyString);

        // So, instead of above anonymous class, we can define Lambda:
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        // So as we can see we have not included 'return' keyword because when a lambda body consists of a single statement
        // that evaluates to a single value, the 'return' keyword is assumed and the return value is in third to be the type
        // of the evaluated value which is String  in this case.
        // Also, as we know we don't have to pass type of parameters 'String' as it i same for both.
        // So lets test our lambda:
        sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);


        // Below code is to test the 'AnotherClass' class.
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }


    // We have seen methods in lambda which does not return anything (above compareTo() method also returns but that is
    // handled by sort() method). But what if method returns something. Like:
    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
    // So this method accepts an object that implements UpperConcat and two Strings. And then it calls upperAndConcat()
    // method from UpperConcat Interface.
}


class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}


class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2); // upperAndConcat() method to convert two String passed, into uppercase
                                                        // and concatenating them and then returning it.
}

class AnotherClass {

    public String doSomething() {
        /**System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is: " + getClass().getSimpleName()); // Doesn't prints name of a class because its anonymous class and doesn't have a name.
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");**/

        // Now, writing above code using Lambda instead of Anonymous class like above.
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");

        // As we see in the output, unlike above commented code, this time we can see the lambda's class name as AnotherClass
        // while in above anonymous class it was showing none for an anonymous class.
        // So lambda expression isn't a class, when a code runs, an  anonymous instance isn't created. Instead the lambda is
        // treated like a nest block of code and has the same scope as a nested block.
    }
}
