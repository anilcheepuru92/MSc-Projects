package finalassignment1;

import org.mariuszgromada.math.mxparser.*;
import processing.core.PApplet;

/*
 * This class members offer the following functionality:
 * 		1. Plotting the graph of the given energy equation
 */
public class EnergyFunctionPlotter extends PApplet{
	
	private Function myFunction;
	private FunctionPlotter1D plotter;
	//System constants:
	private static final double a1 = (double)124004/40000;
	private static final int x = 20;
	private static final int f1 = 2;
	public static final String functionStr = "f(x) = " + a1 +"*x" + "+sin(" + 2*Math.PI*f1+ "*x)";

	public static void main(String[] args) {
		PApplet.main(EnergyFunctionPlotter.class);
	}
		
	public void settings()	{
	  size(500,500,P3D);
	}

	public void setup() 	{ 
		System.out.println("Equation variables:: "+ a1+ ", "+x+", "+ f1);
		System.out.println("Final Function: "+ functionStr);
		myFunction = new Function(functionStr);
	    //initialize the plotter
	    plotter = new FunctionPlotter1D(myFunction, 0, 20);
	}

	public void draw() {
	  background(0);	  
	  //draw the plot
	  plotter.plot(this);
	}

}
