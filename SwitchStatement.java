public class SwitchStatement {
    public static void main(String[] args) {
        int switchValue = 4;
        switch (switchValue) {
        case 1:
            System.out.println("Value was 1");
            break;

        case 2:
            System.out.println("Value was 2");
            break;

        // We can check if the value is 3 or 4 or 5 in one line case by 'case 3: case 4:
        // case 5:'.
        case 3:
        case 4:
        case 5:
            System.out.println("Value was 3 or 4 or 5");
            System.out.println("Actually, the value was " + switchValue);
            break;

        default:
            System.out.println("Value was not 1, 2, 3, 4 or 5");
            break;
        }

        char charValue = 'D';
        switch (charValue) {
        case 'A':
            System.out.println("A was found");
            break;

        case 'B':
            System.out.println("B was found");
            break;

        // Check if the value is C or D or E by 'case C: case D: case E:'.
        case 'C':
        case 'D':
        case 'E':
            System.out.println("The value was " + charValue);
            break;

        default:
            System.out.println("Value was not A, B, C, D or E");
            break;
        }

        String month = "JaNuary";
        switch (month.toLowerCase()) { // We convert string to lowercase here for avoiding cases for different
                                       // combinations like 'January', 'january', 'JANUARY', 'jAnuary', etc.
        case "january":
            System.out.println("Jan");
            break;

        case "june":
            System.out.println("Jun");
            break;

        default:
            System.out.println("Not sure");
        }
    }
}