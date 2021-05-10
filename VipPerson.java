public class VipPerson {

    private String name;
    private double creditLimit;
    private String emailAddress;

    // Empty constructor.
    public VipPerson() {
        this("Default name", 50000, "default@gmail.com");
    }

    // Constructor with 2 parameters.
    public VipPerson(String name, double creditLimit) {
        this(name, creditLimit, "unknown@gmail.com");
    }

    // Constructor with 3 parameters. This is only the constructor which sets all
    // the values, that's why we are calling this constructor in other 2 contructors
    // using 'this' keyword.
    public VipPerson(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
