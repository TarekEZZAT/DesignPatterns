package maze_factory;

 class EnchantedRoom extends Room { 
	Spell s;
	
	 EnchantedRoom(String kindOf){ 
		 super();
		 Spell s = new Spell(kindOf);
 } 
	 public String toString(){ 
	 return "enchanted room " + super.toString() + " " + s.getKindOf(); 
	 } 
	} 
 
	class DoorNeedingSpell extends Door { 
		String spellNeeded; ;
	 DoorNeedingSpell(Room r1, Room r2){ 
		 super(r1,r2);
		 spellNeeded = "needing spell";
		 
	 } 
	 public String toString(){ 
	 return super.toString() + " " + spellNeeded; 
	 } 
	} 