package JavaTutorials3;

import java.util.ArrayList;
import java.util.Iterator;

public class collectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {4,5,5,6,6,9,4,5,4};
		
		//Print unique number from the list
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++)
		{
			int k=0;
			
			if(!al.contains(arr[i]))
			{
				al.add(arr[i]);
				k++;
				
			
			
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i]==arr[j])
				{
					k++;
				}
				
			}
			System.out.println(arr[i] +" is printed " +k +" times");

			if(k==1)
			{
				System.out.println(arr[i] +" is my unique number");
			}

		}
		
		}	

	}

}
