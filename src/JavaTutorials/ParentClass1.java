package JavaTutorials;

import org.testng.annotations.Test;

public class ParentClass1 extends ParentClass {

	@Test
	public void testRun() {
		doThis();// present in parent class(PS) so can call directly using extends(INHERITANCE)
		int a = 3;

		// to call method from parent class2 we have to create object and call
		ParentClass2 PS2 = new ParentClass2(5); // parameterized constructor
		System.out.println(PS2.increment());
		System.out.println(PS2.decrement());
		
//		ParentClass3 PS3 = new ParentClass3(6);
		
		//we made parentclass2 extend parentclass3
		//now ps2 can inherit properties of ps3
		//so, object created for ps2 can call method present in ps3
		//new ps3 obj is not reqd
		System.out.println(PS2.multiplyWith3());


	}

}
