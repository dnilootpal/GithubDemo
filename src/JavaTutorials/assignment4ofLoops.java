package JavaTutorials;

public class assignment4ofLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//assigntment: print below pattern
	
//		3 
//		6 9
//		12 15 18
//		21 24 27 30
		
		int k=3;
		
		for(int i=1; i<5; i++)
		{
			//System.out.println("Outer loop started");

			for(int j=1; j<=i; j++)
			{
				System.out.print(k);
				System.out.print("\t");
				k=k+3;
			}
			System.out.println("");
			


		}

	}

}
