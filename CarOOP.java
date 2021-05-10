public class CarOOP {

    private int doors;
    private int wheels;
    private String model;
    private String engine; // We declared all variables/fields as 'private', So they cannot be accessed
                           // outside this (CarOOP) class.
    public String colour; // If we want to access these variables outside this class then we need to
                          // declare them as 'public'.
                          // But this is not the preferred way of accessing variables out of the class
                          // because it don't follows the rules of encapsulation. Instead, we will create
                          // method for this functionality.

    // Method for updating the 'model'.
    // Such methods are called as 'SETTERS'
    // One of the advantage of using Setters is we can do validation (like on line
    // 19 and 20).
    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("suv")) { // for testing that we will only accept values
                                                                        // that are of type carrera and
                                                                        // suv.

            this.model = model; // 'this' keyword is used to tell java that we want the variable 'model' which
                                // we have declared in this class (i.e. on line 5) and not the variable 'model'
                                // that we passed as parameter to current method. So here, we are updating the
                                // variable declared earlier (on line 5) with the value of variable 'model'
                                // which is passed as parameter to the method.
        } else {
            this.model = "Unknown";
        }

    }

    // Method for getting the 'model'.
    // Such methods are called as 'GETTERS'
    public String getModel() {
        return this.model;
    }
}
