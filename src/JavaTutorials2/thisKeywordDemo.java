package JavaTutorials2;

public class thisKeywordDemo {

	int a=2;
	
	public void getData()
	{
		int a=3;
		
		System.out.println(a);
		
		System.out.println(this.a);
		// 'this' refers to current object- and this object's scope lies in class level
		
		System.out.println("Sum is :" +(a+this.a));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		thisKeywordDemo tkd=new thisKeywordDemo();
		tkd.getData();
		
	}

}
