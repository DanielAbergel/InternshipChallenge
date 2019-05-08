import java.math.BigInteger;


/**
 * This object represents carpet(matrix 2D) 
 * @author DanielAbergel
 */
public class Carpet {

	private MiniCarpet[] Carpets  = new MiniCarpet[4]; 
	private Cross carpetCross;
	private int length ; 
	private boolean  isEven = true ; 
	public final static long BiggerLongCast= 1L ;
	public final static int ERROR = -1 ; 


	
	public Carpet(int length )
	{
		if(length % 2  == 1 ) isEven = false ;
		this.length = length ; 
		for(int i = 0  ; i < 4 ; i++)
			Carpets[i] = new MiniCarpet(length/2); 
		carpetCross = new Cross(length);
	}

	/**
	 * This function Initializes all carpet parameters
	 * @param length represents the carpet length. 
	 */
	public void init(int length) 
	{
		if(length % 2  == 1 )
		{
			isEven = false ;
			carpetCross.init(length);
		}
		else isEven = true ; 
		this.length = length ; 
		for(int i = 0  ; i < 4 ; i++)
			Carpets[i].init(length/2); 

	}
	/**
	 * adding Box to MiniCarpet or Cross depends on the index 
	 * @param row represents the row index
	 * @param col represents the col index
	 */
	public void updateBox(int row , int col) {
		int index = findIndex(row, col);
		if( index < 4 ) Carpets[index].addBox(); 
		else carpetCross.addBox(row, col);

	}
	/**
	 * adding Hunter to MiniCarpet or Cross depends on the index 
	 * @param row represents the row index
	 * @param col represents the col index
	 */
	public void updateHunter(int row , int col ) {
		int index = findIndex(row, col);
		if( index < 4)Carpets[index].addHunter();
		else carpetCross.addHunter(row, col);
	}
	/**
	 * 
	 * @return The maximum hunters that can be added
	 */
	public long Algorithem() {
		long Check0_3 = Carpets[0].ReverseMirroring(Carpets[3]) ;
		long Check1_2 = Carpets[1].ReverseMirroring(Carpets[2]);
		long CrossCheck = 0; 
		if(!isEven) CrossCheck =carpetCross.CrossAlgorithem();
		if(Check0_3 == ERROR || 
		   Check0_3 == ERROR || 
		   CrossCheck == ERROR ) return ERROR ; 
		return BiggerLongCast * (Check0_3 + Check1_2 + CrossCheck) ;
	}


	/*************************************************** Private methods ***************************************************/
	/**
	 * Finding the index (0-3 >> MiniCarpets | 4 >> Cross)
	 * @param row represents the row index
	 * @param col represents the col index
	 */
	private int findIndex(int row , int col) {
		int arrayIndex  = 0 ; 

		if(!isEven && (row == length/2  || col == length/2)) arrayIndex = 4 ; 
		else if(row  < length/2 && col >= length/2 ) arrayIndex = 1 ; 
		else if(row  >= length/2 && col < length/2 ) arrayIndex = 2 ; 
		else if(row  >= length/2 && col >= length/2 ) arrayIndex = 3 ; 

		return arrayIndex ;
	}

}
