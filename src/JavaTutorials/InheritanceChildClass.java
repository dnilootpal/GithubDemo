package JavaTutorials;

public class InheritanceChildClass extends InheritanceParentClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InheritanceChildClass icc = new InheritanceChildClass();
		icc.Color();
		icc.Engine();
		icc.AudioSystem();  //Function overriding: Both have same method name, same signature, same arguments


		icc.Brakes();
		icc.Gear();
		
		//for function overloading
		icc.getData(3);
		icc.getData("Nilu");
		icc.getData(5,6);
	}
	
	public void Engine()
	{
		System.out.println("New Engine");
	}
	
	public void Color()
	{
		System.out.println(color);
	}
	
	public void AudioSystem()
	{
		System.out.println("New audio child code");
	}
	
	//function overloading
	//Same method names in same class but argument count or data type should be different

//Eg: public void getData(int a)

 //     public void getData(int a, int b) or public void getData(String s)

	public void getData(int a)
	{
		System.out.println(a);
	}
	
	public void getData(String s)
	{
		System.out.println(s);
	}
	
	public void getData(int a, int b)
	{
		System.out.println(a+b);
	}
}
