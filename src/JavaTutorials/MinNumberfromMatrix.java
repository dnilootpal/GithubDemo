package JavaTutorials;

public class MinNumberfromMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 2 4 6
		 * 3 5 7
		 * 1 4 8
		 */	
		//print minimum number from above matrix
		
		int abc[][]= {{10,4,6},{3,5,7},{1,-4,8}};
		
		int min=abc[0][0];
		int minColumn;
		
		for(int i=0; i<3; i++)   //row
		{
			for(int j=0; j<3; j++)     //column
			{
				if(abc[i][j]<min)
				{
					min=abc[i][j];
					minColumn=j;
				}
			}
		}
		System.out.println("Min is "+min);
		
		//for maximum number from array
		
		int max=abc[0][0];
		
		for(int i=0; i<3; i++)   //row
		{
			for(int j=0; j<3; j++)     //column
			{
				if(abc[i][j]>max)
				{
					max=abc[i][j];
				}
			}
		}
		System.out.println("Max is "+max);
		
	//interview question- find min number from matrix and then from that column get the max number
		
		

	}

}
