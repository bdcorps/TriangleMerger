package com.bdcorps.triangleMadness;
/**
 * Triangle Object GUI 
 * Part Of: GUI Based Triangle Solving Program
 * @author Sukhpal S. Saini and Vasu Kamra
 * Last Modified: 05-04-2014 at 2:20 PM
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * @author Sukhpal S. Saini and Vasu Kamra
 * 
 */
public class Triangle {
   // Variables (package access)
	
   int x, y; // rectangle (for illustration)
   Color color = Color.RED; // color of the object
  private int [] srcX;
  private int[] srcY;
   public void setSrcX(int[] srcX) {
	this.srcX = srcX;
}


public void setSrcY(int[] srcY) {
	this.srcY = srcY;
}

/** Constructor to setup the GUI */
   public Triangle(int[]srcX, int[]srcY, Color color) {
      this.srcX=srcX;
      this.srcY = srcY;
      this.color = color;
      
   }
   
   /**Paints the triangle
 * @param g
 */
public void paint(Graphics g) {
	   Polygon mypolygon = new Polygon();
      g.setColor(Color.red);
      g.fillPolygon(srcX,srcY,3);
      g.setColor(Color.BLACK);
      g.drawPolygon(srcX,srcY, 3);
   }
}