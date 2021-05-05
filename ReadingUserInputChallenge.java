import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {

        int sum = 0;
        int counter = 1;
        Scanner scanner = new Scanner(System.in);
        while (counter < 11) {
            System.out.println("Enter number #" + counter + ": ");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int number = scanner.nextInt();
                sum += number;
                counter++;
            } else {
                System.out.println("Invalid Number");
            }

            scanner.nextLine(); // handle end of line (enter key)
        }

        scanner.close();

        System.out.println("Sum = " + sum);
    }
}
