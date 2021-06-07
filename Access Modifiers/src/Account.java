import java.util.ArrayList;

public class Account {

    private String accountName; // If these fields are public then anyone can outside this class can access it and update so we are changing it to private.
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums");
        }
    }

    public void withdraw(int amount) {
        int withdrawal = -amount; // converting amount to minus because a negative number we are gonna assume is a withdrawal in transactions ArrayList.
        if (withdrawal < 0) {
            this.transactions.add(withdrawal);
            this.balance += withdrawal; // Subtracting withdrawal from balance. As its already negative so we are adding it.
            System.out.println(amount + " withdrawn. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot withdraw negative sums");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for (int i : this.transactions) { // looping through transactions ArrayList. With i being the each element of ArrayList.
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
