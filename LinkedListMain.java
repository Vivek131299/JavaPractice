import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListMain {

    public static void main(String[] args) {

        LinkedListCustomer customer = new LinkedListCustomer("Tim", 55.56);
        LinkedListCustomer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(15.22);

        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());
        // Above even if we are changing balance of anotherCustomer, the balance of
        // customer is also getting changed because we are referring another customer
        // and customer to the same address. We are not creating new instance while
        // declaring anotherCustomer.

        ArrayList<Integer> intList = new ArrayList<Integer>();

        // Adding values to ArrayList.
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1, 2); // This will insert the number 2 in the index position 1.
                           // So now, the ArrayList will look like: 1,2,3,4.

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
        // Due to this, other elements has to move down so that to enter new element in
        // between and same for removing the item, other elements has to move upward to
        // fill the gap.
        // But this may take time if we have larger ArrayList.

        // Here, Linked Lists comes into existence.
        // They are alternative to arrays.
        // It stores the actual link (address) to the next item in the list as well as
        // the actual data.

        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Darwin");
        placesToVisit.add("Adelaide");

        printList(placesToVisit);

        placesToVisit.add(1, "Alice Springs"); // Adding 'Alice Springs' at index position 1.
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);

        System.out.println("-------------------------------------------");
        // Below code to check addInOrder() method.

        LinkedList<String> places = new LinkedList<String>();
        addInOrder(places, "Sydney");
        addInOrder(places, "Melbourne");
        addInOrder(places, "Brisbane");
        addInOrder(places, "Perth");
        addInOrder(places, "Canberra");
        addInOrder(places, "Adelaide");
        addInOrder(places, "Darwin");

        printList(places);

        addInOrder(places, "Alice Springs"); // This should add.
        addInOrder(places, "Darwin"); // This shouldn.t add as 'Darwin' is already in the list.
        printList(places);

        System.out.println("-------------------------------------------");
        // Below code to check visit() method.

        /*
         * ListIterator doesn't has current item as such. So the iterator actually
         * hovers between its items that would be returned when you go to previous or
         * you go to next. For e.g.- if we go one step forward, two backward, and then
         * go forward one , you never leave the element you are actually in.
         * 
         * So this is actually a problem. But if this was working as we wish then, that
         * may lead to infinte loop while traversing the linkedlist if we delete any
         * element.
         * 
         * So this is done purposely by Java.
         * 
         * So, in order to work this as wanted, we need to keep track of direction in
         * which we are going and allow for the in between nature of the iterator.
         */

        visit(places);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator(); // Iterator is a Java class that is used to iterate through Arrays,
                                                    // ArrayLists and LinkedLists.
        while (i.hasNext()) { // This i.hasNext() checks if there is next element or not.
            System.out.println("Now visiting " + i.next()); // This i.next() is returning the current value of ith
                                                            // element in LinkedList before moving onto next
                                                            // entry(equivalent to i++). But it first returns the
                                                            // current value and then moves to the next value.
        }
        System.out.println("================================");
    }

    // Method for adding new city into linkedlist in alphabetical order.
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator(); // ListIterator is like Iterator but it
                                                                             // gives more flexibility than Iterator.
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity); // This compareTo() will give us a number.
            // If the number is 0, then the both values that we are comparing(i.e. current
            // element of linkedlist and newCity) are equal.
            // Note: We have to use .next() to point to the first entry. Only declaration of
            // iterator will not point to first entry.

            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination.");
                return false;
            } else if (comparison > 0) { // if its > 0 , means new item should appear before current one.
                                         // newCity should appear before this one
                                         // e.g.- Brisbane -> Adelaide, it will return >0 because Adelaide should be put
                                         // before Brisbane.
                stringListIterator.previous(); // Here, we are going one element previous because above(inside while),
                                               // we are doing stringListIterator.next() which returns current element
                                               // and moves to the next. So we were pointing to the next element.
                                               // So here we have to move back again to that element from the next
                                               // element. 'ListIterator' can go back unlike 'Iterator'.
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) { // It means current element is already less than newCIty(already in
                                         // alphabetical order).
                // move on next city.
                // We need not to write anything here to move onto next city because
                // above(inside while), stringListIterator.next() has already moved on to the
                // next element.
            }
        }

        // If we come so far and didn't find any place to add newCity, then definitely
        // that must be added to the end of the LinkedList.
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true; // REASON for this is in comment from line 87.

        // If we didn't implement goingForward logic in switch cases below then while
        // running the code, if we select to go previous city, then we actually at the
        // same city and not going backward.

        ListIterator<String> listIterator = cities.listIterator();

        // Condition for checking that list is empty
        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holidays over");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) { // If user has previously selected going back. And now user is going forward
                                         // then if we are currently not going forward, then we check that we can go
                                         // forward(by .hasNext()) and then we move forward(by .next()).
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) { // Check if there is next element in list.
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) { // If user has previously selected going forward
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) { // Check if there is previous element in list.
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\nPress ");
        System.out.println("0 - to quit\n" + "1 - to go to next city\n" + "2 - to go to previous city\n"
                + "3 - print menu options");
    }
}
