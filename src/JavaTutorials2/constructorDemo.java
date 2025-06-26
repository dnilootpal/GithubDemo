package JavaTutorials2;

public class constructorDemo {

	//Constructor executes a block of code whenever an object is created for the class.
    //Constructor will not return any values,
    //Name of constructor should always be class name.
	
	
	//default constructor
	public constructorDemo()
	{
		System.out.println("I am in the constructor");
	}
	
	//parameterized constructor
	public constructorDemo(int a, int b)
	{
		System.out.println("I m in parameterized constructor " +(a+b));
	}
	
	public constructorDemo(String s)
	{
		System.out.println("I am in para constructor string " +s);
	}
	
	public void getData()
	{
		System.out.println("I am method");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		constructorDemo cd = new constructorDemo();
		constructorDemo cd1 = new constructorDemo(4,5);
		constructorDemo cd2 = new constructorDemo("ABCD");


		
		//since we created object, so constructor will be called now
	}

}
