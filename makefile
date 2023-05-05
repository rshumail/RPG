default: ClemMap.java Driver.java Inventory.java Item.java Room.java
	javac ClemMap.java Driver.java Inventory.java Item.java Room.java

run: ClemMap.class Driver.class Inventory.class Item.class Room.class
	java Driver

clean:
	rm -f *.class