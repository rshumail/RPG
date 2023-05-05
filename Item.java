/**
 * Name: Ruqaiya Shumail
 * Programming Assignment: RPG
 * 04/28/23
 */
import java.util.ArrayList;

public class Item {
    String name;
    String description;
    
    /**
     * Initialize an item
     * @param name the name of item
     * @param description the description of item
     */
    public Item (String name, String description) {
        this.name = name;
        this.description = description;
    }
    /*
     * Getter  method that returns the defined name string
     * void method
     * @return name of Item object
     */
    public String getName () {
        return name;
    }
    /*
     * Getter  method that returns the defined description string
     * void method
     * @return description of Item object
     */
    public String getDescription () {
        return description;
    }
}
