/**
 * Name: Ruqaiya Shumail
 * Programming Assignment: RPG
 * 04/28/23
 */
import java.util.ArrayList;

public class Room {
    String name;
    String description;
    ArrayList<String> exits;
    ArrayList<Item> items;
    Item roomItem;
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new ArrayList<String>();
        roomItem = null;
    }
    /*
     * Getter  method that returns the defined name string
     * void method
     * @return name of Room object
     */
    public String getName () {
        return name;
    }
    /*
     * Getter  method that returns the defined description string
     * void method
     * @return description of Room object
     */
    public String getDescription () {
        return description;
    }

    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit) {
        exits.add(exit);
    }

    public void addItem(Item item) {
        roomItem = item;
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    public String listExits() {
        String list = "";
        for (String exit : exits) {
            list += String.format("%s\n", exit);
        }
        return list;
    }

    public Item getItem() {
        return roomItem;
    }
    /**
     * Says whether the room has items
     */
    public boolean hasItems() {
        if (roomItem != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Removes the Item from the room
     */
    public void removeItem() {
        roomItem = null;
    }

    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    public String toString() {
        String str = "";
        str += String.format("%s: %s\n", name, description);
        str += String.format("\nExits:\n");
        str += listExits();
        return str;
    }
}
