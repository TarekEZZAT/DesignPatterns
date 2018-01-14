package maze_simple;

import java.util.HashSet;
import java.util.Set;

class Maze { 
	 Maze(){ System.out.println("creating a Maze"); } 
	 
	 void addRoom(Room r){ 
	 if (!_rooms.contains(r)){ 
	 _rooms.add(r); 
	 } 
	 } 
	 private Set _rooms = new HashSet(); 
	} 