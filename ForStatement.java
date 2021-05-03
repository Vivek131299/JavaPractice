public class ForStatement {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Loop " + i + " hello");
        }

        for (int i = 2; i < 9; i++) {
            System.out.println("10000 at " + i + "% interest = " + calculateInterest(10000, i));
        }

        System.out.println(); // For blank line

        // Now starting above for loop from 8 to 2.
        for (int i = 8; i >= 2; i--) {
            System.out.println("10000 at " + i + "% interest = " + calculateInterest(10000, i));
        }

        // Here we formatted double number to display only 2 decimal places.
        System.out.println("Without formatting: " + calculateInterest(10000, 7));
        System.out.println("With String formatting: " + String.format("%.2f", calculateInterest(10000, 7)));

        // If number is prime number, print it out and increment a count of the number
        // of prime numbers found. If that count is 3, exit the for loop.
        int countPrimeNumbers = 0;
        for (int i = 1; i <= 100; i++) {
            if (countPrimeNumbers == 3) {
                break;
            } else {
                if (isPrime(i)) {
                    System.out.println(i);
                    countPrimeNumbers += 1;
                }
            }

        }

        /////////////// OR////////////////////////////////////////////////////

        countPrimeNumbers = 0;
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                countPrimeNumbers++;
                System.out.println(i + " is a prime number");
                if (countPrimeNumbers == 3) {
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) { // this for loop can also be written as below to check prime number for
                                           // better code optimization:
                                           // for (int i = 2; i <= (long) Math.sqrt(n); i++)
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
