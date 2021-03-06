package com.bdcorps.triangleMadness;

/**
 *Circle GUI object
 * 
 * Part Of: GUI Based Triangle Solving Program
 * @author Sukhpal S. Saini and Vasu Kamra
 * Last Modified: 05-04-2014 at 2:20 PM
 */

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Sukhpal S. Saini and Vasu Kamra
 * 
 */

public class Circle {
	private int x, y;
	private int width = 15, height = 15;
	private String label;

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