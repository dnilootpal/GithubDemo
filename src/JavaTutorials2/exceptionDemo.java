package JavaTutorials2;

public class exceptionDemo {

	int a=4;
	//3 lines- might throw error- need to catch that so that code doesnt fail
	//try-catch mechanism
	

	//one try can be followed by multiple catch blocks
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int b=7;
		int c=0;
		
		try
		{
			int k=b/c;
			
//			int arr[]=new int[5];
//				System.out.println(arr[7]);
			
		}
		catch(ArithmeticException et)
		{
			System.out.println("I catched arithmetic exception");
		}
		catch(IndexOutOfBoundsException ibe)
		{
			System.out.println("Index out of bound exception");
		}
		
		catch(Exception e)
		{
			System.out.println("I catched generic exception");
		}
		
		// finally block is executed irrespective of exception is thrown or not
		finally
		{
			System.out.println("Delete cookies");
		}

	}
}

