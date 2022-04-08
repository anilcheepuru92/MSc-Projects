package finalassignment1;

import java.awt.Color;

import org.mariuszgromada.math.mxparser.Function;

import grafica.GPoint;

import processing.core.PApplet;

/*
 * This class members offer the following functionality: 
 * 		1. Calculating the areas generated by applying the height-method, mean-method and linear interpolation method
 * 		2. Visualizing the areas generated by applying the height-method, mean-method and linear interpolation method
 */
public class VisualizationWithCalculation extends PApplet{
	private FunctionPlotter1D fp;
	private Function f;
	private double xFirst;
	private double xLast;
	
	public VisualizationWithCalculation(Function f, double xFirst, double xLast) {
		this.f = f;
		this.xFirst = xFirst;
		this.xLast = xLast;
		fp = new FunctionPlotter1D(this.f, this.xFirst, this.xLast);
	}
	
	public void plot(PApplet app) {
		this.fp.plot(app);
	}
	
	//implementation of Height-method
	public double heightMethodForIntegral() {
		double area = 0.0;
		double stepSize = 0.1;	//because we need to take 10 grid points per second(1/10)
		// graphics
		GPoint firstPoint = null;
		GPoint secondPoint = null;
		GPoint thirdPoint = null;
		GPoint fourthPoint = null;
		double i=xFirst;
		while (i<xLast) {
			//calculating the area
			double yCurrent = this.f.calculate(i);
			double yNext = this.f.calculate(i+stepSize);
			double height = yCurrent;
			double width = stepSize;
			area = area+(height*width);
			//code to draw lines
			if(yCurrent!=0) {
				firstPoint = new GPoint((float)i, 0);
				secondPoint = new GPoint((float)i, (float)yCurrent);
				this.fp.addLine(firstPoint, secondPoint, Color.RED);	//vertical up
				thirdPoint = new GPoint((float)(i+stepSize), (float)yCurrent);
				this.fp.addLine(secondPoint, thirdPoint, Color.BLUE);	//horizontal
				fourthPoint = new GPoint((float)(i+stepSize), (float)yNext);
				this.fp.addLine(thirdPoint, fourthPoint, Color.GREEN);	//vertical down
			}
			i=i+stepSize;
		}
		return area;
	}
	
	//implementation of Mean-method
	public double meanMethodForIntegral() {
		double area = 0.0;
		double stepSize = 0.1;	//because we need to take 10 grid points per second(1/10)
		// graphics
		GPoint firstPoint ;
		GPoint secondPoint;
		GPoint thirdPoint;
		GPoint fourthPoint;
		double i = xFirst;
		while (i<xLast) {
			//calculating the area
			double yCurrent = this.f.calculate(i);
			double yNext = this.f.calculate(i+stepSize);
			double yNextAfter = this.f.calculate(i+stepSize+stepSize);
			double yMean = (yCurrent+yNext)/2;
			double nextYMean = (yNext+yNextAfter)/2;
			double height = yMean;
			double width = stepSize;
			area = area+(height*width);
			//code to draw lines
			firstPoint = new GPoint((float)i, (float)yMean);
			secondPoint = new GPoint((float)(i+stepSize), (float)yMean);
			this.fp.addLine(firstPoint, secondPoint, Color.BLUE);	//horizontal
			thirdPoint = new GPoint((float)(i+stepSize), 0);
			this.fp.addLine(secondPoint, thirdPoint, Color.GREEN);	//vertical down
			fourthPoint = new GPoint((float)(i+stepSize), (float)nextYMean);
			this.fp.addLine(secondPoint, fourthPoint, Color.RED);	//vertical up
			i=i+stepSize;
		}
		return area;
	}
	
	//implementation of Linear Interpolation method
	public double linearInterpolationMethodForIntegral() {
		double area = 0.0;
		double stepSize = 0.1;	//because we need to take 10 grid points per second(1/10)
		// graphics
		GPoint firstPoint;
		GPoint secondPoint;
		GPoint thirdPoint;
		double i = xFirst;
		while(i<xLast) {
			//calculating the area
			double yCurrent = this.f.calculate(i);
			double yNext = this.f.calculate(i+stepSize);
			double triangleArea = 0.5*stepSize*(yNext-yCurrent);
			double rectangleArea = stepSize*yCurrent;
			area = area+(triangleArea+rectangleArea);
			//code to draw lines
			firstPoint = new GPoint((float)i, (float)yCurrent);
			secondPoint = new GPoint((float)(i+stepSize), (float)yNext);
			this.fp.addLine(firstPoint, secondPoint, Color.RED);	//point-point lineJ
			//to represent the covered area
			thirdPoint = new GPoint((float)(i+stepSize), 0);
			this.fp.addLine(secondPoint, thirdPoint, Color.BLUE);	//vertical down line
			i=i+stepSize;
		}
		return area;
	}
}