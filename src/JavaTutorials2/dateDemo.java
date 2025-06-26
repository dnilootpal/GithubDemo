package JavaTutorials2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Date d = new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(sdf.format(d));
		
		SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		System.out.println(df.format(d));

		System.out.println(d.toString());

	}

}
