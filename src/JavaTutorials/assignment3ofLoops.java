package JavaTutorials;

public class assignment3ofLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//assigntment: print below pattern
	
//		1 
//		1 2
//		1 2 3
//		1 2 3 4
		
//		int k=0;
		
		for(int i=1; i<5; i++)
		{
			//System.out.println("Outer loop started");

			for(int j=1; j<=i; j++)
			{
				System.out.print(j);
				System.out.print("\t");
//				k++;
			}
			System.out.println("");
			


		}

	}

}
