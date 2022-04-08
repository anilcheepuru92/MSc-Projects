package finalassignment1;

import org.mariuszgromada.math.mxparser.Function;
import processing.core.PApplet;

/*
 * This class members offer the following functionality:
 * 		1. To test the visualization obtained by applying Mean-method 
 */

public class MeanVisualizationTest extends PApplet{

	private VisualizationWithCalculation vs;

	public static void main(String[] args) {
		PApplet.main(MeanVisualizationTest.class);
	}

	public void settings() {
		size(800, 500);
	}

	public void setup() {
		Function f = new Function(EnergyFunctionPlotter.functionStr);
		vs = new VisualizationWithCalculation(f, 0, 20);
		double meanMethodRes = vs.meanMethodForIntegral();
		System.out.println("Areaby Mean method:: " + meanMethodRes);
	}

	public void draw() {
		this.background(0);
		vs.plot(this);
	}
}
