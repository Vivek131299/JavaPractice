import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);

        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        // As we see, we are implementing COMPARABLE interface in Seat class and implementing compareTo() method is also  working fne.
        // But there is also another way to use the sort method. And that's the COMPARATOR.
        // The COMPARATOR interface defines a single method called compare().
        // Unlike Comparable the objects don't have to implement comparator. Instead am object of type comparator can be created
        // with a compare() method that can sort the objects.
        // More than one comparator can be created and that allows objects to be sorted in different ways.
        // So we can either create a comparator object within an existing class OR we could create a new class that implements that
        // comparator interface. (See Theatre class from line 8)

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00)); // Adding seat by instantiating inner class.
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER); // Sorting priceSeats List by PRICE_ORDER, means by price in ascending order.
                                                            // Because in compare() method in PRICE_ORDER Comparator in Theatre class,
                                                            // we are comparing on the basis of price only and not by seatNumber.
        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("=================================================================================================");
    }

}
