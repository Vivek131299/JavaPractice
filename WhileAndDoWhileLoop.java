public class WhileAndDoWhileLoop {

    public static void main(String[] args) {

        /////////////////////////////// While Loop/////////////////////////////////
        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }
        ////////////////////// OR/////////////////////
        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }

        /////////////////////////////// Do While Loop/////////////////////////////////
        // Do While loop executes at least once (first time) and then checks condition.
        count = 1;
        do {
            System.out.println("Count value was " + count);
            count++;
        } while (count != 6);

        ////////////////////////////////////////////////////////////////////////
        int number = 4;
        int finishNumber = 20;
        int countEven = 0;

        while (number <= finishNumber) {
            if (countEven == 5) { // We have to print only first 5 even numbers. So we break if count reaches 5.
                break;
            }
            number++; // We are incrementing number as soon as we enter while loop, So the value in
                      // its first iteration will be 5 instead of 4.
            if (!isEvenNumber(number)) {
                continue; // 'continue' statement bypass (will not execute) all the statements after it in
                          // the loop and goes back to the start of the loop with the next number. So
                          // here, the below print statement will not execute if number is not even.
            }
            countEven++;
            System.out.println("Even number " + number);
        }
    }

    public static boolean isEvenNumber(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }
}
