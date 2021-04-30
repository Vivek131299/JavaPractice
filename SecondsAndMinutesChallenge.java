public class SecondsAndMinutesChallenge {

    // Declaring final/constant variable for invalid value message to avoid
    // repeating string in code.
    // As the variable is declared as final, it is constant and can't be changed
    // later.
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(3945));
    }

    public static String getDurationString(int minutes, int seconds) {
        if ((minutes >= 0 && (0 <= seconds && seconds <= 59))) {
            int hours = minutes / 60;
            minutes = minutes % 60;
            return (hours + "h " + minutes + "m " + seconds + "s");
        } else {
            return INVALID_VALUE_MESSAGE;
        }
    }

    public static String getDurationString(int seconds) {
        if (seconds >= 0) {
            int minutes = seconds / 60;
            seconds = seconds % 60;
            return getDurationString(minutes, seconds);
        } else {
            return INVALID_VALUE_MESSAGE;
        }
    }
}
