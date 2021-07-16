import java.time.*;

public class Main {

    // We have 'java.time' package for Date Time API.
    public static void main(String[] args) {

        /////////////////// LocalDate ///////////////////
        LocalDate d = LocalDate.now(); // .now() will give current (today's) date in YYYY-MM-DD format.
        System.out.println(d);

        // We can also specify any date if we want by using .of() method.
        d = LocalDate.of(1999, 12, 13);
        System.out.println(d);

        // We can also specify month in words like:
        d = LocalDate.of(1999, Month.DECEMBER, 13);
        System.out.println(d);

        // It will give DateTimeException if we try to put the date which does not exist. For e.g.- 32 January or
        // 29 February if its not a leap year.


        /////////////////// LocalTime ///////////////////
        LocalTime tCurrent = LocalTime.now(); // .now() will give current time in HH:MM:SS.milliseconds.
        System.out.println(tCurrent);

        // We can also specify any time we want by using .of() method.
        LocalTime t = LocalTime.of(12, 35, 41, 999);
        System.out.println(t);

        // We can also specify the specific Time Zone of any Country we want by using Zone Id's.
        // If we don't know Zone Id of any Country then we can get all the available zone id's by using getAvailableZoneIds()
        // method of ZoneId class like:
        for (String s : ZoneId.getAvailableZoneIds()) {
            System.out.println(s);
        }

        // So we can use those Zone Ids to get time of that Zone/Country by using ZoneId.of() method inside LocalTime.now() method:
        t = LocalTime.now(ZoneId.of("Asia/Tokyo")); // This will give us current time in Asia/Tokyo Zone or of Tokyo Country.
        System.out.println("Current time in Asia/Tokyo is: " + t);

        // We can get GMT (Greenwich Mean Time Zone), which is the mean solar time at the Royal Observatory in Greenwich,
        // London, counted from midnight.
        t = LocalTime.now(ZoneId.of("GMT"));
        System.out.println("Current GMT is: " + t);

        // We can also get GMT by using 'Instant' class. But Instant class also gives current date along with time unlike above.
        Instant i = Instant.now(); // .now() will give us current GMT time.
        System.out.println("Current GMT date and time is: " + i);

        // We can use the LocalDateTime class for getting both date and time like the Instant class.
        LocalDateTime t2 = LocalDateTime.now(); // .now() will give us current date and time.
        System.out.println("Current date and time is: " + t2);
        t2 = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current date and time in Tokyo is: " + t2);

        // We can also compare dates and time by using isBefore() and isAfter() methods.
        System.out.println(t.isBefore(tCurrent));
        System.out.println(t.isAfter(tCurrent));

    }
}
