package JavaTutorials;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 2 4 6
		 * 3 5 7
		 */		
		//a[row][column]
		
		int a[][]=new int[2][3];
		a[0][0]=2;
		a[0][1]=4;
		a[0][2]=6;
		
		a[1][0]=3;
		a[1][1]=5;
		a[1][2]=7;
		
//		System.out.println(a[0][2]);
		
		for(int i=0; i<2; i++)   //row
		{
			for(int j=0; j<3; j++)     //column
			{
				System.out.println(a[i][j]);
			}
		}
		//in simple way
		int b[][]= {{2,4,6},{3,5,7}};
		System.out.println("Hello " +b[1][1]);

	}
}
