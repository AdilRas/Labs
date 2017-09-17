// Lab24ast.java
// This is the student version of the lab 24a assignment.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Lab24ast {
	public static void main(String args[]) {
		GfxApp gfx = new GfxApp();
		gfx.setSize(900,700);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}

class GfxApp extends Frame {
	public void paint(Graphics g) {
		ArrayList<RegPoly> polygons = new ArrayList<>();
		for(int i = 0; i <= 5; i++) {
			polygons.add(new RegPoly(75*i + 75, 75*i + 75, 60, i+3));
		}
		for(RegPoly r : polygons) {
			r.drawPoly(g);
		}
	}
}


class RegPoly {

	private int centerX, centerY;
	private int radius = 60;
	private int numPoints;

	public RegPoly(int centerX, int centerY, int radius, int numPoints) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.numPoints = numPoints;
	}

	public void drawPoly(Graphics g) {
		if(numPoints == 3) {
			int[] xPts = {centerX-radius, centerX-radius, centerX+radius};
			int[] yPts = {centerY + radius, centerY + radius, centerY};
			g.fillPolygon(xPts, yPts, xPts.length);
		} else if(numPoints == 4) {
			int[] xPts = {centerX - radius, centerX, centerX, centerX + radius};
			int[] yPts = {centerY, centerY + radius, centerY - radius, centerY};
			g.fillPolygon(xPts, yPts, xPts.length);
		} else {
			int[] xPts = new int[numPoints];
			int[] yPts = new int[numPoints];
			if(numPoints%2 == 0) {
				for(int i = 0; i < xPts.length; i++) {
					if(i == 0 || i == (numPoints/2)) {
						yPts[i] = centerY;
						xPts[i] = centerX + (i==0? -radius : radius);
					} else {
						xPts[i] = centerY;
					}
				}
			} else {
				for(int i = 0; i < xPts.length; i++) {
					if(i==0) {
						xPts[i] = centerX - radius;
						yPts[i] = centerY;
					} else {
						xPts[i] = centerX;
					}
				}
			}
		}
	}

	private int getAngle(int numPoints) {
		return 180 * (numPoints-2);
	}


}
