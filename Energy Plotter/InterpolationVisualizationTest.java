package finalassignment1;

import org.mariuszgromada.math.mxparser.Function;
import processing.core.PApplet;

/*
 * This class members offer the following functionality:
 * 		1. To test the visualization obtained by applying Linear Interpolation method 
 */

public class InterpolationVisualizationTest extends PApplet {

	VisualizationWithCalculation vs;

	public static void main(String[] args) {
		PApplet.main(InterpolationVisualizationTest.class);
	}

	public void settings() {
		size(800, 500);
	}

	public void setup() {
		Function f = new Function(EnergyFunctionPlotter.functionStr);
		vs = new VisualizationWithCalculation(f, 0, 20);
		double interpolationMethodRes = vs.linearInterpolationMethodForIntegral();
		System.out.println("Area by Interpolation method:: " + interpolationMethodRes);
	}

	public void draw() {
		this.background(0);
		vs.plot(this);
	}
}
