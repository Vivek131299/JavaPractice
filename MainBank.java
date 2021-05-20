public class MainBank {
    public static void main(String[] args) {

        Bank bank = new Bank("National Bank");

        if (bank.addBranch("Mumbai")) {
            System.out.println("Mumbai branch created");
        }

        bank.addCustomer("Mumbai", "Tim", 50.50);
        bank.addCustomer("Mumbai", "Bob", 135.25);
        bank.addCustomer("Mumbai", "Mike", 215.30);

        bank.addBranch("Delhi");

        bank.addCustomer("Delhi", "Percy", 185.58);

        bank.addCustomerTransaction("Mumbai", "Tim", 40.50);
        bank.addCustomerTransaction("Mumbai", "Tim", 45.50);
        bank.addCustomerTransaction("Mumbai", "Bob", 50.50);

        bank.listCustomers("Mumbai", true);

        bank.listCustomers("Delhi", true);

        bank.addBranch("Pune");
        if (!(bank.addCustomer("Pune", "Tom", 50.00))) {
            System.out.println("Error, Pune branch does not exists");
        }

        if (!(bank.addBranch("Mumbai"))) {
            System.out.println("Error, Mumbai branch already exists");
        }

        if (!(bank.addCustomerTransaction("Mumbai", "Alex", 100.50))) {
            System.out.println("Customer does not exists at branch");
        }

        if (!(bank.addCustomer("Mumbai", "Tim", 5.50))) {
            System.out.println("Customer Tim already exists");
        }
    }
}
