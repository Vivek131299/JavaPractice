public class TernaryOpAndPrecedence {
    public static void main(String[] args) {
        boolean isCar = false;
        boolean wasCar = isCar ? true : false; // condition ? ifConditionIsTrue : ifConditionIsFalse
        if (wasCar) {
            System.out.println("wasCar is true");
        }

        boolean isCar2 = true;
        boolean wasCar2 = isCar2 ? true : false; // condition ? ifConditionIsTrue : ifConditionIsFalse
        if (wasCar2) {
            System.out.println("wasCar2 is true");
        }

        int age = 20;
        boolean isEighteenOrOver = age >= 18 ? true : false;
        if (isEighteenOrOver) {
            System.out.println("Age is above eighteen");
        }

        double a = 20.00;
        double b = 80.00;
        double c = (a + b) * 100.00;
        // If we do [a + b * 100.00], value of c will be 8020.0 beacuse * operator has
        // higher precendence than + operator.
        double d = c % 40.00;
        boolean isZero;
        if (d == 0) {
            isZero = true;
        } else {
            isZero = false;
            System.out.println("Got some remainder");
        }
        System.out.println(isZero);
    }
}
