package maze_factory;


class MazeGame {
	public Maze createMaze(MazeFactory factory) {
		// Use factory
		Maze aMaze = factory.makeMaze();
		Room r1 = factory.makeRoom();
		Room r2 = factory.makeRoom();
		Door theDoor = factory.makeDoor(r1, r2);
		aMaze.addRoom(r1);
		aMaze.addRoom(r2);
		
		r1.setSide(Direction.North, factory.makeWall());
		r1.setSide(Direction.East, theDoor);
		r1.setSide(Direction.South, factory.makeWall());
		r1.setSide(Direction.West, factory.makeWall());
		r2.setSide(Direction.North, factory.makeWall());
		r2.setSide(Direction.East, factory.makeWall());
		r2.setSide(Direction.South, factory.makeWall());
		r2.setSide(Direction.West, theDoor);
		return aMaze;
	}
}

class MazeGameOld {
	public Maze createMaze() {
		Maze aMaze = new Maze();
		Room r1 = new Room();
		Room r2 = new Room();
		Door theDoor = new Door(r1, r2);
		aMaze.addRoom(r1);
		aMaze.addRoom(r2);
		r1.setSide(Direction.North, new Wall());
		r1.setSide(Direction.East, theDoor);
		r1.setSide(Direction.South, new Wall());
		r1.setSide(Direction.West, new Wall());
		r2.setSide(Direction.North, new Wall());
		r2.setSide(Direction.East, new Wall());
		r2.setSide(Direction.South, new Wall());
		r2.setSide(Direction.West, theDoor);
		return aMaze;
	}
}