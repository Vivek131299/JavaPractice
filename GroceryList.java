import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.Position;

public class GroceryList {

    // ArrayLists is list of items but it can change its size automatically after
    // adding or removing any element from it unlike the arrays.
    private static ArrayList<String> groceryList = new ArrayList<String>(); // creating new ArrayList of type String.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            case 0:
                printInstructions();
                break;
            case 1:
                printGroceryList();
                break;
            case 2:
                addItem();
                break;
            case 3:
                modifyItem();
                break;
            case 4:
                removeItem();
                break;
            case 5:
                searchForItem();
                break;
            case 6:
                processArrayList();
            case 7:
                quit = true;
                break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter current item name: ");
        String itemNumber = scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        modifyGroceryItem(itemNumber, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNumber = scanner.nextLine();
        removeGroceryItem(itemNumber);
    }

    public static void searchForItem() {
        System.out.println("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if (onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }

    public static void processArrayList() {
        // For copying one ArrayList to new ArrayList
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(getGroceryList()); // This will copy all the contents of groceryList into newArray.

        /////////// OR (for copying one ArrayList to another)/////////////
        ArrayList<String> nextArray = new ArrayList<String>(getGroceryList()); // This will also copy all the contents o
                                                                               // fgroceryList into nextArray.
        // Below code, if we want to convert the contents of the ArrayList and convert
        // it into regular Array.
        String[] myArray = new String[getGroceryList().size()];
        myArray = getGroceryList().toArray(myArray); // toArray() method will convert out 'groceryList' ArrayList into
                                                     // regular Array and store it into myArray.
    }

    ///////////////////////////////////////////////////

    public static ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public static void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public static void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public static void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private static void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    public static void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }

    private static void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    private static int findItem(String searchItem) {
        // boolean exists = groceryList.contains(searchItem); // This will return if any
        // item (searchItem) is available in
        // our arrayList(groceryList).
        return groceryList.indexOf(searchItem); // This will return the position (index) of our item in
                                                // arrayList. It returns -1 if item is not in the arrayList.

    }

    public static boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position >= 0) {
            return true;
        }
        return false;
    }
}
