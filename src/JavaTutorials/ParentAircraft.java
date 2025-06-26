package JavaTutorials;

public abstract class ParentAircraft {

	public void engine()       //non abstract method coz it has a body
	{
		System.out.println("Follow engine guidelines");
	}
	
	public void safetyGuidelines()
	{
		System.out.println("Follow safety guidelines");
	}
	
	public abstract void bodyColor();
}
