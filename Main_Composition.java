public class Main_Composition {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case thecase = new Case("220B", "Dell", "240", dimensions);

        // Here, in last parameter we are directly creating a class variable on the fly
        // unlike on line 4.
        Monitor monitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));

        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(thecase, monitor, motherboard);

        /*
         * BELOW COMMENTED CODE WILL WORK IF WE HAVE GETTERS IN 'PC' CLASS.
         * 
         * // For accessing the method of Monitor class through PC, We use getMonitor()
         * // getter function defined in PC class.
         * 
         * 
         * thePC.getMonitor().drawPixelAt(1500, 1200, "red");
         * 
         * thePC.getMotherboard().loadProgram("Windows 1.0");
         * 
         * thePC.getTheCase().pressPowerButton();
         */

        thePC.powerUp();

        // In short, Composition is used when we have to access/ use more than one
        // classes in a class. We cant do that by extending(extends keyword) as in Java
        // we can only inherit from one class at a time.
    }
}
