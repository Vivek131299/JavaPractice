import java.util.Scanner;

public class MainGearbox {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print"); // For testing 'Button' class.

    public static void main(String[] args) {

        Gearbox mcLaren = new Gearbox(6);

        //We can do like below (till line 15) if our inner 'Gear' class is public. But since we declared inner class as private,
        // we are not able to do like below, So we changed it to (from line 23) by using methods of outer 'Gearbox' class.
        /*
        Gearbox.Gear first = mcLaren.new Gear(1, 12.3); // This is how to create an object of inner class.

                                                                // We created 'first' object of Gear which is inner class of Gearbox outer class.
                                                                // Note  that we have used 'mcLaren' which is Gearbox instance fpr creating instance of Gear class.

        // We can't do like:
                    // Gearbox.Gear second = new Gearbox.Gear(2, 15.4);   OR
                    // Gearbox.Gear third = new mcLaren.Gear(3, 17.8);
        System.out.println(first.driveSpeed(1000));
        */


        // For accessing functionalities of private inner 'Gear' class we are using methods of public outer 'Gearbox' class.
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));


        ///////////////////////   LOCAL CLASS   ///////////////////////

        // Below code id for testing 'Button' class.
        // This class is called as LOCAL CLASS that we have actually defined within the method(main method of 'MainGearbox' class).
        // NOTE that this local class is applicable for this block only(i.e. within the current main method).
        class ClickListener implements Button.OnClickListener {
            public ClickListener() { // Constructor for this class.
                System.out.println("I have been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked by using Local class");
            }
        }

        ///////////////////////////////////////////////////////////////

        btnPrint.setOnClickListener(new ClickListener());
        listen();


        ////////////////////////    ANONYMOUS CLASS    ///////////////////////

        // ANONYMOUS CLASS is also a Local class but it does not have any name.
        // They have to be declared and instantiated at the same time, because they do not have a name.
        // They are USED when a Local class is required only once.
        btnPrint.setOnClickListener(new Button.OnClickListener() {      // So this is anonymous class.
            // We can use this class instead of above local class.
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked by using Anonymous class");
            }
        });
        listen();

    }

    // If we are using any graphic framework then that will automatically respond when a button was clicked and onClick()
    // method would actually be invoked for us.
    // But here we are using any graphic framework so we are gonna simulate that listen method from keyboard(below).
    private static void listen() {
        boolean quit = false;
        System.out.println("Available optios: \n" + "0 to quit\n" + "1 to click Print button");
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
