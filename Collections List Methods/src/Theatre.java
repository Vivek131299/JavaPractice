import java.util.ArrayList;
import java.util.List;


public class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>(); // This has been changed later from ArrayList<> to LinkedList<> , and from List to Collection.
    // When we declare seats to be of type Collection, we can implement the list if seats in a theatre using any concrete class
    // that implements one of the interfaces that extend Collection. (So we can use List, ArrayList, LinkedList, Set, HashSet, LinkedHashSet).
    // But in collection we can't use by drop down a level. Like collection framework also includes TreeSet which implements SortedSet
    // and that is one level down. So we can't use that here.

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum)); // %02d formats the number into string as starting with 0 and 2 digits.
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        /*
        Seat requestedSeat = null;
        for(Seat seat : seats) {
            System.out.print("."); // We are printing dot to see how many times do we check before finding the required seat.
                                    // In the output, we see that many dots are printed. So we need to implement binary search instead of this brute force search.
                                    // For that, collection class provides the binary search method. But for this, we need to implement
                                    // the Comparable interface in our Seat class.
            if(seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if(requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
        */
        // Above code is commented because we used Comparable interface in Seat class and compareTO() method for binary search.


        /*
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null); // This is gonna run use to the comparable interface and
                                                                                    // its gonna use the method we implemented to check using
                                                                                    // the string compare to operator.
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        */
        // Above code is commented because we were using binarySearch() from Collections directly so we were not able to see
        // that how many iterations were happening before getting our required seat.
        // So now, below we paste the code from Java Collections file to add some dots in between to see the number of iterations
        // we require to find out required seat from seats List.
        // So, below is the code for binary search.


        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            System.out.print("."); // To see how many iterations we need to find required seat.
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    // for testing
    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat> { // We are implementing Comparable for binary search.(See comment on line 31).
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // Overriding Comparable interface's compareTo() method to compare seats.
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber()); // This returns 0 if both are equal.
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }



















}
