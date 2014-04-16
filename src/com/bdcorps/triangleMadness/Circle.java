package com.bdcorps.triangleMadness;

import java.awt.*;
/**
 * The class Sprite models a moving game object, with its own operations
 *  and can paint itself.
 */

public class Circle {
   // Variables (package access)
   int x, y;
   int width=15, height =15; // rectangle (for illustration)
   Color color = Color.YELLOW; // color of the object
 
   /** Constructor to setup the GUI */
   public Circle(int x, int y, Color color) {
      this.x = x;
      this.y = y;
      this.color = color;
   }
 
   public void setX(int x) {
	this.x = x;
}

public void setY(int y) {
	this.y = y;
}

/** Paint itself (given the Graphics context) */
   public void paint(Graphics g) {
      g.setColor(color);
      g.fillOval(x-width/2, y-height/2, width, height); 
   }
   public boolean contains(int x, int y) 
   {boolean hit=false;
	   if ((x>this.x-width)&&(x<this.x+width*2)){
		   if ((y>this.y-height)&&(y<this.y+height*2)){
			   hit = true;}
	   }
       return hit;
   }
}