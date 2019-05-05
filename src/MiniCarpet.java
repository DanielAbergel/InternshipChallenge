
public class MiniCarpet {

	private int boxCounter ;
	private int hunterCounter ;
	private int potentialHunters ; 
	private int length ; 
	
	public MiniCarpet(int length) {
		boxCounter = 0 ; 
		hunterCounter = 0 ; 
		potentialHunters = length*length ; 
		this.length = length*length ; 
	}
	
	
	public int Mirror(MiniCarpet other) 	
	{
		int maxPotential = Math.min(this.potentialHunters, other.potentialHunters);
		if(maxPotential <  hunterCounter || maxPotential < other.hunterCounter) return -1 ; 
		return maxPotential-hunterCounter + maxPotential-other.hunterCounter; 
	}
	 
	
	public void addHunter() {hunterCounter++;}
	public void addBox() {boxCounter++;  potentialHunters--;}


	public void init(int length) {
		boxCounter = 0 ; 
		hunterCounter = 0 ; 
		potentialHunters = length*length ; 
		this.length = length*length ; 
	}
	
}
