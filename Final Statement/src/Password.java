public class Password {

    private static final int key = 74857632;
    private final int enncryptedPassword;

    public Password(int password) {
        this.enncryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        return password ^ key; // This is to XOR the values.
        // This XOR operation gives us encrypted password if we input decrypted password and also gives us decrypted password
        // if we input encrypted password.
    }

    public final void storePassword() { // We have done this method as final later. (See comments in Main class).
        System.out.println("Saving password as " + this.enncryptedPassword);
    }

    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == this.enncryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Nope, you cannot come in");
            return false;
        }
    }
}
