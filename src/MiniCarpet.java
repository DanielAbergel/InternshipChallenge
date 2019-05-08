/**
 * This object represents quarter carpet (matrix 2D) 
 * @author DanielAbergel
 */
public class MiniCarpet {

	private long boxCounter ;
	private long hunterCounter ;
	private long potentialHunters ; 
	private long length ; 
	
	public MiniCarpet(int length)
	{
		boxCounter = 0 ; 
		hunterCounter = 0 ; 
		potentialHunters = Carpet.BiggerLongCast*length*length ; 
		this.length = Carpet.BiggerLongCast*length*length; 
		
	}
	
	/**
	 * This function Initializes all MiniCarpet parameters
	 * @param length represents the carpet length. 
	 */
	public void init(int length)
	{
		boxCounter = 0 ; 
		hunterCounter = 0 ; 
		potentialHunters = Carpet.BiggerLongCast*length*length ; 
		this.length = Carpet.BiggerLongCast*length*length ; 
	}
	/**
	 * this function checks whether the MiniCarpet opposite from  this MiniCarpet,
	 *  and checks whether in potential can be added more hunters otherwise this function returns -1 (ERROR)
	 * @param other represents a MiniCarpet 
	 * @return -1 if there is ERROR and the carpet unstable , otherwise returns the hunters that can be added
	 */
	public long ReverseMirroring(MiniCarpet other) 	
	{
		long maxPotential = Math.min(this.potentialHunters, other.potentialHunters);
		if(maxPotential <  hunterCounter || maxPotential < other.hunterCounter) return Carpet.ERROR; 
		return Carpet.BiggerLongCast *(maxPotential-hunterCounter + maxPotential-other.hunterCounter); 
	}
	 
	
	public void addHunter() {hunterCounter++;}
	public void addBox() {boxCounter++;  potentialHunters--;}


	
	
}
