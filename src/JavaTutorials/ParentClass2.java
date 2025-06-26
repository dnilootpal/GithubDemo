package JavaTutorials;

public class ParentClass2 extends ParentClass3{

	int a;

	// default constructor
	public ParentClass2(int a) {
		
		super(a); //now parentclass3 constructor is invoked
		this.a = a; // this
	}

	public int increment() {
		a = a + 1;
		return a;
	}

	public int decrement() {
		a = a - 1;
		return a;
	}

}
