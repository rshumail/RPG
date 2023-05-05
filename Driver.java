/**
 * Name: Ruqaiya Shumail
 * Programming Assignment: RPG
 * 04/28/23
 * Clemson Escape Room
 * https://github.com/rshumail/RPG
 */
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Driver {
    public static String printOptions () {
        String strOptions = "";
        strOptions += "peepee";

        return strOptions;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nWelcome to Clemson Escape Room: try to escape campus as you walk through all the different areas! What is your name?\n");
        String name = scnr.nextLine();
        /*
         * 
         */
        // Create new adventureMap object called map
        ClemMap map = new ClemMap();
        Inventory inventory = new Inventory();
        
        // Create new file and outputsream
        String fileName = String.format("%s.txt", name.replace(' ','_'));
        FileOutputStream fileStream = null;
        
        // initialize the output stream to the new file
        try {
            fileStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + fileName);
        }

        // Create printWriter for new file
        PrintWriter outFS = new PrintWriter(fileStream);

        // Initialize all rooms with their name and description
        // add the assigned exits to each initialized Room object
        // add each Room to map
        Room stadium = new Room("Stadium", "A huge room filled with football paraphernalia. It smells like sweat and popcorn.");
        stadium.addExit("Core");
        map.addRoom(stadium);

        Room core = new Room("Core", "A high-ceiling room with multiple food stations, but upon further inspection the food seems to be fake.");
        core.addExit("Stadium");
        core.addExit("Student Union");
        core.addExit("Amphitheater");
        map.addRoom(core);
        Item key = new Item("Key", "A small silver key with faded letter on it. You wonder if it will be useful.");
        core.addItem(key);

        Room amphitheater = new Room("Amphitheater", "Open space, central to the whole campus.");
        amphitheater.addExit("Core");
        amphitheater.addExit("Library");
        amphitheater.addExit("Schilleter");
        map.addRoom(amphitheater);
        
        Room library = new Room("Library", "Quiet place, but there may be things hiding in the dungeons.");
        library.addExit("Amphitheater");
        library.addExit("McAdams Hall");
        map.addRoom(library);
        Item note = new Item ("Note", "A note with some scribbles on it. You wonder if this could be on any help.");
        library.addItem(note);
        
        Room studentUnion = new Room("Student Union", "A room with long forgotten DDR machines, a bowling alley and some pool tables. You wonder how the dissarray happened.");
        studentUnion.addExit("Core");
        map.addRoom(studentUnion);
        Item bowlingPin = new Item("Bowling Pin", "A stray bowling pin from the student underground union. You wonder when you will be able to bowl again.");
        studentUnion.addItem(bowlingPin);

        Room schilletter = new Room("Schilletter", "Dingy cafetaria room. You smell faint hints of ice cream and pizza. ");
        schilletter.addExit("Amphitheater");
        schilletter.addExit("Hendrix");
        schilletter.addExit("McAdams Hall");
        map.addRoom(schilletter);

        Room mcadams = new Room("McAdams Hall", "An academic place, you see lots of computers but none work.");
        mcadams.addExit("Hendrix");
        mcadams.addExit("Library");
        mcadams.addExit("Schilletter");
        map.addRoom(mcadams);

        Room hendrix = new Room("Hendrix", "A big room with many windows. You see signs for an ice cream place and a bagel place. You start to feel hungry.");
        hendrix.addExit("McAdams Hall");
        hendrix.addExit("Schilletter");
        map.addRoom(hendrix);
        Item iceCream = new Item("Ice Cream", "A melted ice cream cone from 55 Exchange. You contemplate eating it, but decide against it.");
        hendrix.addItem(iceCream);
        
        // Tell user how to work it
        System.out.println("You will be starting in the amphitheater. Type exit at any time to quit the game.");

        // Set the current room to study, create scanner, initialize boolean exit to false
        Room currRoom = amphitheater;
        boolean exit = false;

        /*
         * While the user's input is not exit, continue to traverse the map. 
         * If there is an invalid selection, then print out "Invalid exit."
         * After you are done selecting, print out "Please choose an exit" and get next exit
         */
        while (!exit) {
            outFS.printf("You entered %s.\n", currRoom.getName());
            System.out.println(currRoom.toString());
            char userChar;
            if (currRoom.hasItems()) {
                System.out.printf("It seems that this room has items. Would you like to explore %s? (Y/N)\n", currRoom.getName());
                userChar = scnr.nextLine().charAt(0);
                if (userChar == 'Y' || userChar == 'y') {
                    Item currItem = currRoom.getItem();
                    System.out.printf("%s - %s\n", currItem.getName(), currItem.getDescription());
                    System.out.println("Would you like to take the item?(Y/N)");
                    userChar = scnr.nextLine().charAt(0);
                    if (userChar == 'Y' || userChar == 'y') {
                        inventory.addItem(currItem);
                        System.out.println("Item added.");
                        outFS.printf("You have added %s to your inventory from %s.\n", currItem.getName(), currRoom.getName());
                        currRoom.removeItem();
                        if (inventory.numItems() == 4) {
                            System.out.println("While getting the item, you notice a suspicious door. You walk towards it and find a new exit.\nYou open the door to see that it leads you outside. You have successfully escaped.");
                            outFS.println("You succesfully escaped!");
                            exit = true;
                            break;
                        }
                    }
                }
                System.out.println("Okay, let's move on.");
            }
            System.out.println("Please choose an exit");
            String userInput = scnr.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                exit = true;
                outFS.println("You have left.");
                break;
            } else {
                while (map.getRoom(userInput.toLowerCase()) == null) {
                    System.out.println("Invalid exit.\nPlease choose an exit");
                    userInput = scnr.nextLine();
                }
                exit = false;
            }
            currRoom = map.getRoom(userInput.toLowerCase());
        }
        
        outFS.close();
    }

}