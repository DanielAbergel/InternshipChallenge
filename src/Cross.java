/**
 * This object represents the  carpet cross 
 * @author DanielAbergel
 */
public class Cross {

	private Segment[] Segments ;
	private int length ; 
	private int middle ;

	public Cross(int length) 
	{
		this.length = length ; 
		Segments = new Segment[4];
		for (int i = 0; i < Segments.length; i++) 
		{Segments[i] = new Segment(length/2);}

		middle = 1 ; 
	}

	/**
	 * This function Initializes all MiniCarpet parameters
	 * @param length represents the the Cross length. 
	 */
	public void init(int length) 
	{
		this.length = length ;
		for (int i = 0; i < Segments.length; i++)
		{Segments[i].init(length/2);}

		middle = 1 ;

	}	

	/**
	 * adding Hunter to to one of the Segments depends on the index 
	 * @param row represents the row index
	 * @param col represents the col index
	 */
	public void addHunter(int row , int col) 
	{
		if(row == length/2 && col == length/2) {middle--;return;}
		int index = findIndex(row,col);
		Segments[index].hunterCounter++ ; 
	}
	/**
	 *  adding Box to to one of the Segments depends on the index 
	 * @param row represents the row index
	 * @param col represents the col index
	 */
	public void addBox(int row , int col) 
	{
		if(row == length/2 && col == length/2) {middle--;return;}
		int index = findIndex(row,col);
		Segments[index].boxCounter++ ; 
		Segments[index].potentialHunters--;
	}

	/**
	 * 
	 * @return The maximum hunters that can be added on the cross , if there is no option to do so returns -1(ERROR)
	 */
	public int CrossAlgorithem()
	{
		int OddSum = 0  , EvenSum = 0 ;
		int maxPotentialOdd = Math.min(Segments[1].potentialHunters, Segments[3].potentialHunters);
		int maxPotentialEven = Math.min(Segments[0].potentialHunters, Segments[2].potentialHunters);

		if(maxPotentialOdd <  Segments[1].hunterCounter || maxPotentialOdd < Segments[3].hunterCounter) return Carpet.ERROR ; 
		if(maxPotentialEven <  Segments[0].hunterCounter || maxPotentialEven < Segments[2].hunterCounter) return Carpet.ERROR ; 

		OddSum = maxPotentialOdd-Segments[1].hunterCounter + maxPotentialOdd-Segments[3].hunterCounter;
		EvenSum = maxPotentialEven-Segments[0].hunterCounter + maxPotentialEven-Segments[2].hunterCounter;

		return OddSum + EvenSum + middle; 
	}

	/*************************************************** Private methods ***************************************************/
	private int findIndex(int x , int y)
	{
		int index = 0 ; 

		if(x < length/2 && y ==  length/2) index = 1; 
		else if(x == length/2 && y > length/2) index = 2 ;
		else if(x > length/2 && y == length/2) index = 3; 

		return index ; 
	}

	/**
	 * This object represents a quarter of the carpet cross 
	 * @author DanielAbergel
	 *
	 */
	private class Segment{

		int hunterCounter ; 
		int boxCounter ;
		int potentialHunters ;
		int length ; 

		public Segment(int length) {
			hunterCounter = 0 ;
			boxCounter = 0 ;
			potentialHunters = length ; 
			this.length = length ; 
		}

		public void init(int length) {
			hunterCounter = 0 ;
			boxCounter = 0 ;
			potentialHunters = length ; 
			this.length = length ;
		}
	}




}
