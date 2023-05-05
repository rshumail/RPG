/**
 * Name: Ruqaiya Shumail
 * Programming Assignment: RPG
 * 04/28/23
 */
import java.util.HashMap;
import java.util.ArrayList;

public class Inventory {
    HashMap<String, Item> inventory;
    ArrayList<Item> items;

    public Inventory() {
        inventory = new HashMap<String, Item>();
        items = new ArrayList<Item>();
    }

    /**
     * Adds an item to the inventory
     * @param item item to be added to the inventory
     */
    public void addItem(Item item) {
        inventory.put(item.getName().toLowerCase(), item);
        items.add(item);
    }

    /**
     * Generates a string representation of the inventory using the name of the items.
     */
    public String toString() {
        String str = "";
        str += "Inventory\n";
        str += String.format("\nItems:\n");
        for (Item item : items) {
            str += String.format("%s\n", item.getName());
        }
        return str;
    }

    public Integer numItems() {
        return items.size();
    }
}