package JavaTutorials;

public class MatrixInterviewQues {

	//interview question- find min number from matrix and then from that column get the max number

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 10 4 6
		 * 3  5 7
		 * 1 -4 8
		 */	
		//print minimum number from above matrix
		
		int abc[][]= {{10,4,6},{3,5,7},{1,-4,8}};
		
		int min=abc[0][0];
		int minColumn = 0;
		
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
		
		int max=abc[0][minColumn];
		int k=0;
		
		while(k<3)
		{
			if(abc[k][minColumn]>max)
			{
				max=abc[k][minColumn];
			}
			k++;
		}
		
		System.out.println("Max number from min number column is "+max);		

	}

}
