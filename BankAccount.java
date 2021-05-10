import java.util.Scanner;

public class BankAccount {
    private long accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private long phoneNumber;

    // Constructor (Empty)
    public BankAccount() {
        this(7654321, 0, "DefaultName", "DefaultEmail", 123456789); // this is special use of 'this' keyword for calling
                                                                    // another parameterized constructor and setting
                                                                    // default values to them in case anyone calls empty
                                                                    // constructor. And this should be on the very first
                                                                    // line of empty constructor always.
        System.out.println("Empty constructor called");
    }

    // Constructor with parameters (To initialize values)
    public BankAccount(long accountNumber, double balance, String customerName, String email, long phoneNumber) {
        System.out.println("BankAccount constructor with parameters called.");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Constructor with only 3 parameters.
    public BankAccount(String customerName, String email, long phoneNumber) {
        this(5462317, 150, customerName, email, phoneNumber); // Here we are setting values of accountNumber and balance
                                                              // and else 3 values are set by calling another
                                                              // constructor using 'this'.
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double funds) {
        this.balance += funds;
        System.out.println("Updated balance after deposit: " + getBalance());
    }

    public void withdrawFunds(double funds) {
        if (this.balance - funds < 0) {
            System.out.println("Insufficient balance!");
        } else {
            this.balance -= funds;
            System.out.println("Updated balance after withdraw: " + getBalance());
        }
    }
}