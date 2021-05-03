public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigits(212));
    }

    public static int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }

        int sum = 0;
        while (number != 0) {
            sum = sum + (number % 10); // Extract digit at units place and add it to sum.
            number = number / 10; // Drop digit at units place and store remaining number.
        }

        return sum;
    }
}
