import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); // We used here List constructor(i.e. we passed list as parameter) to copy our list.
                                                                    // But this is SHALLOW COPY of List. i.e. only List is different but they are referencing to same objects.
        printList(seatCopy);
        // seatCopy list contains all of the elements that were in the original. The method that we use to create seat copy and
        // populate it in all the elements on theatre seats is called a SHALLOW COPY.
        // Note that these aren't copied. So if we modify any one of the seats, say by reserving it, then that seat will be reserved,
        // whichever list we check for it.
        // So we may have the new list but the contents are a same objects as exists in the theatre seats. So they are effectively
        // the same shared objects.
        // For e.g.- we reserve a seat below.
        seatCopy.get(1).reserve(); // Reserving the 2nd element(seat) from seatCopy List.
        if (theatre.reserveSeat("A02")) { // And here we are going back, reserving the seat from the other ArrayList.
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }
        // Above we are reserving the same seat(i.e. A02) from both the Lists (i.e. seatCopy and original ArrayList from Theatre),
        // we are getting output as seat is already reserved.
        // This is because we are reserving the seat from seatCopy List and then reserving from original List.
        // So, its very clear that even if we are creating a copy of List, we are sharing the same data(seatCopy and original List
        // are pointing to same data). So if we change any one list, other will also change.
        // So, the objects are different but reference is same.

        Collections.reverse(seatCopy); // Reversing the seatCopy List. We can also shuffle the List instead of reversing.
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seats");
        printList(theatre.seats);
        // As we can see the output of above code, seatCopy is printed in reverse order and theatre.seats is printed in original order.
        // So, we can clearly say that they are separate ArrayLists but the only thing is that they refer to the same objects that were
        // initially created on line 8.

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
        // Above, it returns min or max by using the compareTo method to determine that sort order, and not the first element
        // as min and last element as max.
        // So this will work even if the List is not sorted.
        // So, even if we printed out the min and max of the seatCopy List (which is reversed), still we will get same min and max.


        // Below code is for testing our own sortList() method.
        sortList(seatCopy); // Sorting seatCopy List because it was reversed above.
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);


        // DEEP COPY
        // Deep copy of the List is unlike the Shallow copy, means it does not references to the elements of the original list
        // but copies the elements.

        // But Collections.copy() is going to fail unless the destination is big enough to hold all the elements to be copied into it.
        // So if we try to like this:
        /*
        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);
        */
        // If we try like above, we get an error because the code on line 64, only sets the capacity of the ArrayList, giving it the
        // potential to hold that many elements BUT initially containing none. So it still doesn't actually create a number of elements.
        // So, for this to work we need to have same no. of objects(96 in this case) in that newList before we attempt to create the copy.

    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=================================================================================================");
    }


    // Own sort method. (Bubble Sort).
    public static void sortList(List<? extends Theatre.Seat> list) { // We have made the method generic here. So that it can sort any
                                                                        // kind of list of theatre seats (unlike above printList() that
                                                                        // will work on only seat lists) so as long as they implement
                                                                        // the comparable interface.
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) { // if element is greater than its next element.
                    Collections.swap(list, i, j); // Swapping the ith and jth element of list.
                }
            }
        }
    }
}
