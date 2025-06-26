package JavaTutorials;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Array- A container which stores multiple values of same datatype
		
		int a[]=new int[5]; //Declares an array and allocates memory for the values
		a[0]=5;
		a[1]=7;
		a[2]=9;
		a[3]=11;
		a[4]=13;
		
		for(int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}

		//2nd way to declare array
		
		int b[] = {1,3,5,6,7};
	
		for(int i=0; i<b.length; i++)
		{
			System.out.println(b[i]);
		}
	}

}
