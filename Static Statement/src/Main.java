public class Main {

    public static int multiplier = 7; // This has been declared as static later. See comment from line 42.

    public static void main(String[] args) {

        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstances());

        // We expect that each of this instances to be number one, because both have the copy the number of instances field.
        // So when we increment it to the constructor(in StaticTest class), it becomes one in each case because as we start
        // from numInstances = 0.

        // But a STATIC field which is also known as a class variable is associated with the class rather than any particular
        // instance of it, so it's only ever ONE COPY of the variable in memory.
        // ALl instances of the class share that one class variable.

        // So now, we change the numInstances variable in StaticTest class to static.

        // So after declaring it as static, we can see that numInstances variable is incrementing on creating new instances
        // because as it is static all instances are referring to only one copy of that variable and increment it. SO its
        // incrementing from 0 to 1 to 2 and so on.

        // Creating third instance
        StaticTest thirdInstance = new StaticTest("3rd Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + secondInstance.getNumInstances());
        // As we can see above, we have not changed the 'secondInstance.getNumInstances()' to 'thirdInstance.getNumInstances()'
        // but still the code works fine and we get output as 3 for this instance number.
        // This happened because as our numInstances variable is static, these all 3 instances are sharing same copy of that
        // variable, so it doesn't matter.
        // But we should change it to 'thirdInstance.getNumInstances()' as it is a good programming practice even though
        // 'secondInstance.getNumInstances()' is perfectly valid.

        // Now, we change the getNumInstances() method from StaticTest class to static as well.
        // By doing this, we can access this method without creating an instance of StaticTest class like below:
        System.out.println("Total number of instances are " + StaticTest.getNumInstances());

        /*
        int answer = multiply(6); // We can't access multiply() method here because this main() method is a static method, so
                                  // we can only access methods which are static in main() method.
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier); // Similarly we can't access multiplier variable because its not static.
        */

        // So now we make our multiplier variable and multiply() method as static.
        // And now, we will be able to access multiplier variable and multiply() method in main() static method:
        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier);

        /*
        So in short, static variables and static methods can be accessed by other classes without creating an instance
        BUT static methods cannot access non-static variables or non-static methods inside it.

        The reason for this is because if suppose we are accessing static method in another class(ofcourse without creating
         an instance), then if that static method has a call to non-static variable or method in it then it will give an error
         because as we know non-static variables and methods requires an instance for accessing them and here we are accessing
         static method without creating an instance.
        */

    }

    public static int multiply(int number) { // This has been declared as static later. See comment from line 42.
        return number * multiplier;
    }
}
