package JavaTutorials3;

import java.util.Hashtable;

public class hashTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<Integer, String> ht=new Hashtable<Integer, String>();
		ht.put(0, "hello");
		ht.put(1, "bye");
		ht.put(2, "morning");
		ht.put(3, "evening");
		System.out.println(ht.get(2));
		ht.remove(3);
		System.out.println(ht);

	}

}
