public class ExtendedPassword extends Password {

    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    /*@Override
    public void storePassword() {
        System.out.println("Saving password as " + this.decryptedPassword);
        // Here by overriding this method we are just storing the original password without encrypting it.
    }*/
    // This is commented later, because as we see we have got an error that we cannot override this method as it is declared
    // as Final in Password class.
}
