import java.util.ArrayList;

public class Gearbox {

    private ArrayList<Gear> gears;
    private int maxGears;
    private int gearNumber;
    private int currentGear = 0; // We created this instead of gearNumber above because we have same field(gearNumber) in inner class below
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        //For adding gears
        for (int i = 0; i <maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }


    // In below four methods we are also adding functionality from a inner Gear class because that's a private class and
    // other classes can't access their methods. So we are creating methods in this outer class and we will access them.
    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio) {
        if ((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if ((newGear >= 0) && (newGear < this.gears.size()) && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected");
        } else {
            System.out.println("Grind");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (clutchIsIn) {
            System.out.println("Scream!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }


    private class Gear { // This is an inner class 'Gear' which is inside the outer class 'Gearbox'.
        // We use inner classes if the class doesn't make any sense without any outer class for context.
        // For e.g.- Gear is not useful in its own, its coupled with Gearbox so it makes it useful.
        // If we write Gears without Gearbox then it will not make any sense, That's why we use it as inner class.

        // Instances of Inner(Gear) class has access too all the methods and fields of Outer(Gearbox) class,
        // even those mark as private.

        // We are making here Gear class as private because the intention of inner class is that we want to access it only
        // through its outer class and we don't want any other class to access it.
        // But as we make it as private we are unable to create its instance in 'MainGearbox' class(on line 6 in MainGearbox class).
        // So we write another method to use instead of creating instance of this class.

        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber; // 'this' keyword here is referring to the gearNumber variable of current(Gear)
                                          // class and not Outer(Gearbox) class.
                        // So if we want to access the gearNumber variable of Outer(Gearbox) class then we need to use:
                            // Gearbox.this.gearNumber;
            // When the field name of inner class is as same as outer class then it said to shadow the declaration of outer class.
            // So, here we can say that, gearNumber of Gear class is shadowing the gearNumber of Gearbox class.
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs) {
            return revs * (this.ratio);
        }
    }
}
