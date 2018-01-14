package maze_factory;

public class EnchantedMazeFactory extends MazeFactory { 
	 
	 public Room makeRoom(String  kindOf){ 
	 return new EnchantedRoom(kindOf); 
	 } 
	 
	 public Door makeDoor(Room r1, Room r2){ 
	 return new DoorNeedingSpell(r1,r2); 
	 } 
	 
	
	} 