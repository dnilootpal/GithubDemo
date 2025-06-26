package JavaTutorials2;

public class StaticVar {
	
	//below are instance variables
	String name;
	String address;
	static String city="Pune"; //class variable
	static int i=0;
	
	//static block-for code optimization
	static {
		 city="Pune";
		 i=0;
	}
	
	//Whenever we declare any variable as static, then that var is part of the class and not object
	//Remaining variables in class are instance variables
	//Variables in constructor are local variables
	//For static variables, sharing will happen, 
	//means if method runs multiple times, it will remember the last value stored in the variable


	
	public StaticVar(String name, String address)
	{
		this.name=name;
		this.address=address;
		i++;
		System.out.println(i);
	}
	
	public void getAddress()
	{
		System.out.println(address +" " +city);
	}
	
	//class method-it doesnt rely on object to call them
	public static void getCity()
	{
		System.out.println(city);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticVar obj=new StaticVar("Nilu", "Marunji");
		StaticVar obj1=new StaticVar("Pilu", "Kharadi");
		StaticVar obj2=new StaticVar("Pilu", "Kharadi");

		obj.getAddress();
		obj1.getAddress();
		
		StaticVar.getCity();
		StaticVar.i=4;
		
		obj.address="Lohegao";
	}

}
