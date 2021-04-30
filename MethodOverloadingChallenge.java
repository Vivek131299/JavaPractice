public class MethodOverloadingChallenge {

    public static void main(String[] args) {
        double centimeters = calcFeetAndInchesToCentimeters(100);
        if (centimeters >= 0) {
            System.out.println(centimeters + " centimeters");
        } else {
            System.out.println("Invalid parameters");
        }

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet >= 0) && (0 <= inches && inches <= 12)) {
            double centimeters = ((feet * 12) + inches) * 2.54;
            return centimeters;
        } else {
            System.out.println("Invalid feet or inches");
            return -1;
        }
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches >= 0) {
            double feet = (int) inches / 12;
            inches = (int) inches % 12;
            return calcFeetAndInchesToCentimeters(feet, inches);
        } else {
            System.out.println("Invalid inches");
            return -1;
        }
    }
}
