public class OOP {
    public static void main(String[] args) {
        CarOOP porshe = new CarOOP(); // creating and initializing the object 'porshe' of class type 'CarOOP'
        CarOOP ford = new CarOOP();
        porshe.colour = "Red"; // We can access only 'colour" field of CarOOP class here as it is the only
                               // 'public' field in 'CarOOp' class, else all are declared as 'private'.
                               // But this is not the preferred way of accessing variables out of the class
                               // because it don't follows the rules of encapsulation. Instead, we should
                               // retrict this functionality and place it in 'CarOOP' class.

        porshe.setModel("Carrera"); // We are setting value to variable using the 'setModel' method of 'CarOOP'
                                    // class, unlike directly setting value of 'colour'.
        System.out.println("Model is " + porshe.getModel());

        porshe.setModel("xyz"); // This 'xyz' model will not be accepted as we have validation in 'setModel'
                                // method in 'CarOOP' class.

        System.out.println("Model is " + porshe.getModel()); // This will print "Unknown" as we have assigned it in else
                                                             // statement if validation fails in 'setModel' method in
                                                             // 'CarOOP' class.
    }
}
