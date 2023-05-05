/**
 * Name: Ruqaiya Shumail
 * Programming Assignment: RPG
 * 04/28/23
 */
import java.util.HashMap;

public class ClemMap {
    HashMap<String, Room> map;

    public ClemMap() {
        map = new HashMap<String, Room>();
    }

    /**
     * Adds a room to the ClemMap
     * The name associated in the room must be lowercase
     * @param room Room to be added to the ClemMap
     */
    public void addRoom(Room room) {
        map.put(room.getName().toLowerCase(), room);
    }

    /**
     * Returns the Room assocaited with the string name given
     * @param roomName the name of the room to be returned, room name must be valid
     * @return the Room object assocaited with the name, the name will be in lowercase
     */
    public Room getRoom(String roomName) {
        return map.get(roomName);
    }
}