import java.math.BigInteger;

public class Carpet {

	private MiniCarpet[] Carpets  = new MiniCarpet[4]; 
	private Cross CrossEvenSoultion;
	private int length ; 
	boolean  isEven = true ; 
	
	

	public Carpet(int length ) {
		if(length % 2  == 1 ) isEven = false ;
		this.length = length ; 
		for(int i = 0  ; i < 4 ; i++)
			Carpets[i] = new MiniCarpet(length/2); 
		CrossEvenSoultion = new Cross(length);
	}
	public void init(int length) 
	{
		if(length % 2  == 1 ) isEven = false ;
		else isEven = true ; 
		this.length = length ; 
		for(int i = 0  ; i < 4 ; i++)
			Carpets[i].init(length/2); 
		CrossEvenSoultion.init(length);
	}

	public void updateBox(int x , int y) {
		int index = findIndex(x, y);
		if( index < 4 ) Carpets[index].addBox(); 
		else CrossEvenSoultion.updateBox(x, y);

	}
	public void updateHunter(int x , int y ) {
		int index = findIndex(x, y);
		if( index < 4)Carpets[index].addHunter();
		else CrossEvenSoultion.updateHunter(x, y);
	}
	
	private int findIndex(int x , int y) {
		int arrayIndex  = 0 ; 
		
		if(!isEven && (x == length/2  || y == length/2)) arrayIndex = 4 ; 
		else if(x  < length/2 && y >= length/2 ) arrayIndex = 1 ; 
		else if(x  >= length/2 && y < length/2 ) arrayIndex = 2 ; 
		else if(x  >= length/2 && y >= length/2 ) arrayIndex = 3 ; 

		return arrayIndex ;
	}
	public int Algorithem() {
		int ERROR = -1 ;  
		int maxAns = Carpets[0].Mirror(Carpets[3]) ;
		int maxAns1 = Carpets[1].Mirror(Carpets[2]);
		int crossAns = 0; 
		if(!isEven) crossAns =CrossEvenSoultion.CrossAlgorithem();
		if(maxAns == ERROR || maxAns == ERROR  || crossAns == ERROR ) return ERROR ; 
		return maxAns + maxAns1 + crossAns ;
	}



	public static void main(String[] args) {
		Carpet c = new Carpet(3);
		c.updateBox(0, 0);
		System.out.println(c.Algorithem());

	}
}
