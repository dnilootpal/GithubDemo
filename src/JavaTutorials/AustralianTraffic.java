package JavaTutorials;

public class AustralianTraffic implements centralTraffic{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		centralTraffic a= new AustralianTraffic();
		//above line says that I have created object for class 'AustralianTraffic' to
		//implement methods in 'centralTraffic'
		
		a.greenGo();
		a.redStop();
		a.yellowWait();
		
		AustralianTraffic at= new AustralianTraffic();
		at.walkOnSymbol();
	}
	
	public void walkOnSymbol()
	{
		System.out.println("Walking");

	}

	@Override
	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println("Green implementation");
	}

	@Override
	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println("Red implementation");

	}

	@Override
	public void yellowWait() {
		// TODO Auto-generated method stub
		System.out.println("Yellow implementation");

	}

}
