import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TEST_Input {

	private BufferedReader br ; 

	TEST_Input(String path) throws FileNotFoundException
	{
		br= new BufferedReader(new FileReader(path));
	}

	public void runTests() throws IOException
	{
		if(br == null ) return ;
		String st;
		int CarpetLength = 0 , numOfHunters  = 0, numOfBoxs = 0 , TestsCounter = 1 ; 
		Carpet c  = new Carpet(0);
		br.readLine();
		while ((st = br.readLine()) != null) 
		{
			String[] inputs = st.split(" ");
			String[] indexs ;
			if(inputs.length  == 3) 
			{
				CarpetLength =Integer.parseInt(inputs[0]);
				numOfBoxs = Integer.parseInt(inputs[1]);
				numOfHunters = Integer.parseInt(inputs[2]);
			}
			c.init(CarpetLength);
			for(int i = 0 ; i < numOfBoxs ; i++)
			{
				indexs = br.readLine().split(" ") ;
				int y = Integer.parseInt(indexs[0]) - 1;
				int x = Integer.parseInt(indexs[1]) - 1;
				c.updateBox(x, y);
			}
			for(int i = 0 ; i < numOfHunters ; i++)
			{
				indexs = br.readLine().split(" ") ;
				int y = Integer.parseInt(indexs[0]) -1;
				int x = Integer.parseInt(indexs[1]) -1;
				c.updateHunter(x, y);
			}
			int ans = c.Algorithem() ; 
			System.out.println("Case #"+TestsCounter + ":" + ans );
			TestsCounter++;
		}
			
			
	}
	
	public static void main(String[] args) throws IOException {
		TEST_Input T = new TEST_Input("C:\\Users\\דניאל\\eclipse-workspace\\InternshipChallenge\\src\\task-1.txt") ;
		T.runTests();
	}

}
