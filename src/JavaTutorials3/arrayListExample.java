package JavaTutorials3;

import java.util.ArrayList;

public class arrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> al=new ArrayList<String>();
		
		al.add("Nilu");
		al.add("Peen");		
		al.add("Peen");
		System.out.println(al);		
		al.add(0, "First");
		System.out.println(al);	
//		al.remove(1);
//		System.out.println(al);	
		System.out.println(al.get(2));	
		System.out.println(al.contains("Nilua"));
		System.out.println(al.indexOf("Peen"));
		System.out.println(al.isEmpty());
		System.out.println(al.size());
	}

}
