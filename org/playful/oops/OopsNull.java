package org.playful.oops;

public class OopsNull {
	
	
	public static void testMO(Object i) {
		System.out.println("Treated as Object");
	}

	public static void testMO(String sb) {
		System.out.println("Treated as String");
	}
	
	public static void testMO2(int i) {
		System.out.println("Treated as Integer");
	}

	public static void testMO2(Character c) {
		System.out.println("Treated as Character");
	}
	
	public static void testMO2(Object o) {
		System.out.println("Treated as Object");
	}
	
	public static void exception(Exception e) {
		System.out.println("Exception");
	}

	public static void exception(ArithmeticException e) {
		System.out.println("Arithmetic Exception");
	}	
	
	public static void main(String[] args) {
		OopsNull.testMO(null);
		OopsNull.testMO2(null);
		OopsNull.exception(null);
		
		OopsNull o1=null, o2=null; //Else wont compile
		if(o1 == o2)
			System.out.println("Both are equal");
		
		/* OUTPUT
		    Treated as String
		    Treated as Character
			Arithmetic Exception
			Both are equal
		 */
	}
	

}
