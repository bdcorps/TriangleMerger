package com.bdcorps.triangleMadness;
import java.awt.*;
/**
 * The class Sprite models a moving game object, with its own operations
 *  and can paint itself.
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
   
   public void paint(Graphics g) {
	   Polygon mypolygon = new Polygon();
      g.setColor(Color.red);
      g.fillPolygon(srcX,srcY,3);
      g.setColor(Color.BLACK);
      g.drawPolygon(srcX,srcY, 3);
   }
}