package finalassignment2;

import processing.core.*;
import java.awt.*;

public class Rectangle {

	private double x = 0.0;
	private double y = 0.0;
	private double w = 0.0;
	private double h = 0.0;

	public Rectangle(double x, double y, double w, double h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void draw(Color col, PApplet app) {
		app.fill(col.getRGB());
//		System.out.println(col);
		app.rect((float) this.x, (float) -this.y, 
				(float) this.w, (float) -this.h);
	}
}