package maze_factory;

public class Main2 { 
	 public static void main(String[] args){ 
		 System.out.println("EnchantedMazeFactory");
	 MazeFactory factory = new EnchantedMazeFactory(); 
	 MazeGame game = new MazeGame(); 
	 game.createMaze(factory); 
	 } 
	} 