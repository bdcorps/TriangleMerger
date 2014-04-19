package com.bdcorps.triangleMadness;

import java.awt.*;

/**
 * "Circle" GUI object
 */

public class Circle {
	int x, y;
	int width = 15, height = 15;
	String label;

	/** Constructor to setup the GUI */
	public Circle(int x, int y, String label) {
		this.x = x;
		this.y = y;
		this.label = label;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/** Paint itself (given the Graphics context) */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString(label, x, y - 10);
		g.fillOval(x - width / 2, y - height / 2, width, height);
	}

	/**
	 * Hit test method for this object
	 * 
	 * @param x
	 * @param y
	 * @return Returns if the point is in the circle or not
	 */
	public boolean contains(int x, int y) {
		boolean hit = false;
		if ((x > this.x - width) && (x < this.x + width)) {
			if ((y > this.y - height) && (y < this.y + height)) {
				hit = true;
			}
			System.out.print("\nhit");
		}
		return hit;
	}
}