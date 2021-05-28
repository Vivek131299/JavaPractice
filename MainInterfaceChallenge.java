import java.util.ArrayList;
import java.util.Scanner;

public class MainInterfaceChallenge {

    public static void main(String[] args) {

        Playerr tim = new Playerr("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim); // We have only put here 'tim' instead of 'tim.toString()', but that's fine because it will be assumed automatically.

        tim.setWeapon("Stormbringer");
        saveObject(tim);
      //  loadObject(tim);
        System.out.println(tim);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        saveObject(werewolf);

        //System.out.println(werewolf.getStrength()); //We can't access getStrength() of Monster class here because we are creating
                                // 'werewolf' of type 'ISaveable' and not of type 'Monster' and getSTrength() is not part of Isaveable interface.
                                // So we need to cast that to Monster class like below.
        System.out.println("Strength = " + ((Monster) werewolf).getStrength()); // Here we are casting werewolf to Monster class type and then
                                                                // we are able to access .getStrength() method of Monster class.

                //OR we can do like below////
        //Monster werewolf1 = new Monster("Werewolf", 20, 40);
        //System.out.println("Strength = " + werewolf1.getStrength());
    }

    // Below method is for simulating inputs from files. In this we are taking input from user.
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) { //As we are creating variable of type ISaveable, by doing this we can access any method
                                                            //from any class which implements this interface.
        for(int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
            // objectToSave.write() will execute the write() method from Playerr class which returns the List<String>,
            // and then we are looping through each object of that list in this loop. Also, .size() will return the size
            // of that List which write() method will return.

        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values); // Calling read() method from Playerr class and it will extract the data.
    }
}
