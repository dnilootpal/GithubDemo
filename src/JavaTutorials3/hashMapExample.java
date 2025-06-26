package JavaTutorials3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class hashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		hm.put(0, "hello");
		hm.put(1, "bye");
		hm.put(2, "morning");
		hm.put(3, "evening");
		System.out.println(hm.get(2));
		hm.remove(3);
		System.out.println(hm);
		
		Set es= hm.entrySet();
		Iterator it = es.iterator();
		
		while(it.hasNext())
		{
			Map.Entry me=(Map.Entry)it.next();
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}
	}

}
