package JavaTutorials;

public class ChildEmirates extends ParentAircraft{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChildEmirates c=new ChildEmirates();
		c.bodyColor(); 
		c.engine();    //able to call parent class method coz child inherits parent
		c.safetyGuidelines();  ////able to call parent class method coz child inherits parent
		
//Note: Cannot create object for ParentAircraft coz its abstract class
	}

	@Override
	public void bodyColor() {
		// TODO Auto-generated method stub
		
		System.out.println("Red color");
		
	}

}
