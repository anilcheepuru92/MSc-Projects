package finalassignment1;

import org.mariuszgromada.math.mxparser.Function;

/*
 * This class members offer the following functionality:
 * 		1. To calculate the integration using height-method, mean-method and linear interpolation method
 * 		2. To calculate the Absolute And Relative Error for each of the 3 methods
 */
public class NumericalIntegrationTest {
	
	private static final double ACTUAL_INTEGRATION_VALUE =620.02; 	//obtained from hand-calculation
	private static VisualizationWithCalculation vs;

	public static void main(String[] args) {
		/**
		 * Section that calculates the Integration Results using
		 * various methods
		 */
		
		vs = new VisualizationWithCalculation(new Function(EnergyFunctionPlotter.functionStr), 0, 20);
		
		//Extracting the result of Integration using first method (question 3.3.1)
		double heightMethodRes = vs.heightMethodForIntegral();
		System.out.println("Height Method Integration Result::"+ heightMethodRes);
		
		//Extracting the result of Integration using second method (question 3.3.2)
		double meanMethodRes = vs.meanMethodForIntegral();
		System.out.println("Mean Method Integration Result::"+ meanMethodRes);
		
		
		//Extracting the result of Integration using third method (question 3.3.3)
		double interpolationMethodRes = vs.linearInterpolationMethodForIntegral();
		System.out.println("Linear Interpolation Method Integration Result::" + interpolationMethodRes);
		
		/**
		 * Section that calculates the Absolute Error and 
		 * Mean Error for each of the 3 methods
		 */
		
		//Absolute And Relative Errors for Height Method
		double absErrHeightMethod = findAbsoluteError(heightMethodRes);
		double relativeErrHeightMethod = findRelativeError(heightMethodRes);
		System.out.println("Height Method ==> " + "Absolute Error:: " + absErrHeightMethod + "\t Relative Error:: "
				+ relativeErrHeightMethod);

		// Absolute And Relative Errors for Mean Method
		double absErrMeanMethod = findAbsoluteError(meanMethodRes);
		double relativeErrMeanMethod = findRelativeError(meanMethodRes);
		System.out.println("Mean Method ==> " + "Absolute Error:: " + absErrMeanMethod + "\t Relative Error:: "
				+ relativeErrMeanMethod);

		// Absolute And Relative Errors for Linear Interpolation Method
		double absErrInterpolationMethod = findAbsoluteError(interpolationMethodRes);
		double relativeErrInterpolationMethod = findRelativeError(interpolationMethodRes);
		System.out.println("Interpolation Method ==> " + "Absolute Error:: "+absErrInterpolationMethod +"\t Relative Error:: "
				+relativeErrInterpolationMethod);
	}
	//absolute error formula
	public static double findAbsoluteError(double measuredValue) {
		return measuredValue - ACTUAL_INTEGRATION_VALUE;		
	}
	
	//relative error formula
	public static double findRelativeError(double measuredValue) {
		return (measuredValue - ACTUAL_INTEGRATION_VALUE)/ACTUAL_INTEGRATION_VALUE;	
	}

}
