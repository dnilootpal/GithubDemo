package JavaTutorials;

public class nestedLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<=4; i++)	  //(outer for loop) this block loops 4 times
		{
			System.out.println("Outer loop started");
			
			for(int j=1; j<=4; j++)  //inner loop
			{
				System.out.println("Inner loop");

			}
			
			System.out.println("Outer loop finished");

		}

	}

}
