package JavaTutorials2;

public class childDemo_SuperKeyword extends parentDemo_SuperKeyword {

	String name= "QAClick";
	
	public childDemo_SuperKeyword()
	{
		super();  //this should be the first line in child constructor
		System.out.println("I am the child class constructor");
	}
	
	//super keyword in case of same methods names in parent and child class
	public void getData()
	{
		System.out.println("I am in child class");
		super.getData();
	}
	
	//super keyword in case of same variable names in parent and child class
	public void getStringData()
	{
		System.out.println(name);
		System.out.println(super.name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		childDemo_SuperKeyword cd = new childDemo_SuperKeyword();
		
		cd.getStringData();
		cd.getData();
	}

}
