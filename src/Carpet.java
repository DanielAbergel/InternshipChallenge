import java.math.BigInteger;

public class Carpet {

	private MiniCarpet[] Carpets  = new MiniCarpet[4]; 
	private Cross CrossEvenSoultion;
	private int length ; 
	boolean  EverOrOdd = true ; 
	
	

	public Carpet(int length  ) {
		if(length % 2  == 1 ) EverOrOdd = false ;
		this.length = length ; 
		for(int i = 0  ; i < 4 ; i++)
			Carpets[i] = new MiniCarpet(length/2); 
		CrossEvenSoultion = new Cross(length);
	}
	public void init(int length) 
	{
		this.length = length ; 
		for(int i = 0  ; i < 4 ; i++)
			Carpets[i].init(length/2); 
	}

	public void updateBox(int x , int y) {
		int index = findIndex(x, y);
		Carpets[index].addBox();

	}
	public void updateHunter(int x , int y ) {
		int index = findIndex(x, y);
		Carpets[index].addHunter();
	}
	private int findIndex(int x , int y) {
		int arrayIndex  = 0 ; 

		if(x  < length/2 && y >= length/2 ) arrayIndex = 1 ; 
		else if(x  >= length/2 && y < length/2 ) arrayIndex = 2 ; 
		else if(x  >= length/2 && y >= length/2 ) arrayIndex = 3 ; 

		return arrayIndex ;
	}
	public int Algorithem() {
		int ERROR = -1 ;  
		int max = Carpets[0].Mirror(Carpets[3]) ;
		if(max == ERROR ) return ERROR ; 
		int max1 = Carpets[1].Mirror(Carpets[2]);
		if(max1 == ERROR ) return ERROR ; 
		return max1 + max;
	}



	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE+5);

	}
}
