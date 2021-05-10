import java.util.Scanner;

public class MainBankAccount {

    public static void main(String[] args) {

        // Creating object of class 'BankAccount', and passing parameters to call
        // constructor of 'BankAccount' class and initialize values.
        BankAccount bankAccount = new BankAccount(1234567, 100, "Bob", "bob@gmail.com", 987654321);

        System.out.println(bankAccount.getAccountNumber());
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getCustomerName());
        bankAccount.withdrawFunds(100);
        bankAccount.depositFunds(50);
        bankAccount.withdrawFunds(100);
        bankAccount.depositFunds(51);
        bankAccount.withdrawFunds(100);

        BankAccount bankAccount2 = new BankAccount(); // Here empty constructor will be called of class 'BankAccount'

        System.out.println(bankAccount2.getAccountNumber());
        System.out.println(bankAccount2.getBalance());
        System.out.println(bankAccount2.getCustomerName());
        bankAccount2.withdrawFunds(100);
        bankAccount2.depositFunds(50);
        bankAccount2.withdrawFunds(100);
        bankAccount2.depositFunds(51);
        bankAccount2.withdrawFunds(100);

        BankAccount bankAccount3 = new BankAccount("Tim", "tim@gmail.com", 98765432); // Here we are third constructor
                                                                                      // with 3 parameters.
        System.out.println(bankAccount3.getAccountNumber());
        System.out.println(bankAccount3.getBalance());
        System.out.println(bankAccount3.getCustomerName());
        bankAccount3.withdrawFunds(100);
        bankAccount3.depositFunds(50);
        bankAccount3.withdrawFunds(100);
        bankAccount3.depositFunds(51);
        bankAccount3.withdrawFunds(100);

        /*
         * Scanner scanner = new Scanner(System.in); int choice;
         * 
         * System.out.println("**************MENU***************");
         * System.out.println("1. Check balance");
         * System.out.println("2. Deposit funds");
         * System.out.println("3. Withdraw funds");
         * System.out.println("Enter your choice: ");
         * 
         * choice = scanner.nextInt();
         * 
         * switch (choice) {
         * 
         * case 1: System.out.println("Available balance: " + getBalance()); break;
         * 
         * case 2: System.out.println("Enter amount to deposit: "); double depositFunds
         * = scanner.nextDouble(); depositFunds(depositFunds); break;
         * 
         * case 3: System.out.println("Enter amount to withdraw: "); double
         * withdrawFunds = scanner.nextDouble(); withdrawFunds(withdrawFunds); break; }
         * 
         * scanner.close();
         */
    }
}
