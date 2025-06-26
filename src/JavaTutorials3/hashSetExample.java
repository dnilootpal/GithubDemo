package JavaTutorials3;

import static org.testng.Assert.assertEqualsNoOrder;

import java.util.HashSet;
import java.util.Iterator;

public class hashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//HashSet, LinkedHashSet, TreeSet implements Set interface
		//Set interface does not accept duplicate values
		//There is no guarantee that elements are stored in sequential order
		
		HashSet<String> hs=new HashSet<String>();
		hs.add("India");
		hs.add("USA");
		hs.add("UK");
		hs.add("India");
		hs.add("he");
		hs.add("she");
		System.out.println(hs);
//		System.out.println(hs.remove("USA"));
		System.out.println(hs.isEmpty());
		System.out.println(hs.size());
		
		//Iterator-used to iterate through every object present in HashSet
	    Iterator<String> i= hs.iterator();

	    while(i.hasNext())
	    {
		    System.out.println(i.next());

	    }
	}

}
