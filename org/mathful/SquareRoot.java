package org.mathful;

public class SquareRoot {
	//Implement http://www.cse.wustl.edu/~kjg/cse131/Notes/SquareRoot/sqrt.html  (but NOT Newton-Raphson)
	
	
	public SquareRoot(double x) {
		//For x>0, find some y so that y^2 = x, i.e. x/y = y
		double y = 2;
		
		double g = x / y; //init (guess)
		
		do {			
			y = g;
			g = ( y + (x/y)) /2; // better guess
			System.out.println("x="+x+" y="+y+" g="+g);
		} while(closeEnough(y,g)); //Used closeEnough instead of condition: (y-g)!=0

		System.out.println("Computer Root = " + g);
	}
	
	private boolean closeEnough(double a, double b) {
		   return ( Math.abs(a-b) > 0.0001);
	}
	
	public static void main(String[] args) {
		new SquareRoot(2101);
	}

}
