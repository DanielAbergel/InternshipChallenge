
public class Algorithem <T> {

	T a;
	
	public String toString(){
		return "" + a ;
	}
	
	public static void main(String[] args) {
		Algorithem<Integer> a = new Algorithem<Integer>(); 
		a.a = 3 ;
		System.out.println(a);
	}
}
