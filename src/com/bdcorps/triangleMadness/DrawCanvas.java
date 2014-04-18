package com.bdcorps.triangleMadness;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * DrawCanvas (inner class) is a JPanel used for custom drawing
 */
public class DrawCanvas extends JPanel implements MouseListener,MouseMotionListener {  public int[] triangleX={0,100,200};
public int[] triangleY={0,100,200};Triangle t;
boolean dragging0 =false,dragging1 =false,dragging2 =false;
Circle c0,c1,c2;
private boolean firstLaunch;
private boolean update;
private int x=10, y=0;

   public void UpdateTriangle(double i1,double i2,double i3) {
	   Point[] p = calcPoints(i1,i2,i3);
       for (int i = 0; i < p.length; i++){
         triangleX[i]=p[i].x+this.getWidth()/2; 
       triangleY[i] =p[i].y+this.getHeight()/2; 
       repaint();}
}

public void setFirstLaunch(boolean firstLaunch) {
	this.firstLaunch = firstLaunch;
}

	// Override paintComponent to perform your own painting
	   public DrawCanvas(){
		   t = new Triangle(triangleX,triangleY,Color.BLUE);
		     c0= new Circle(0,0,Color.YELLOW);
		     c1= new Circle(200,200,Color.RED);
		     c2= new Circle(100,100,Color.GREEN);
		     

		      addMouseListener(this);
		     addMouseMotionListener(this);
	   }
	   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);     // paint parent's background
     setBackground(Color.BLACK);  


	
		
		if (firstLaunch){
			y+=10;
			g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 12));
      g.drawString("Enter valid values into the above textboxes",10 , 15);
     g.drawString("Then press 'Calculate'",10 , 30);
     
     g.drawString("Options available in the menu:",10 , 60);

     g.drawString("Rounding places",10 , 75);
     g.drawString("The solution to draw",10 , 90);
     
     g.drawString("Project Head: Vasu Kamra",10 , 135);
     g.drawString("Lead Programmer: Sukhpal S. Saini",10 , 150);
     
		}else {	c0.setX(triangleX[0]);		c0.setY(triangleY[0]);
		

		c1.setX(triangleX[1]);
		c1.setY(triangleY[1]);

		c2.setX(triangleX[2]);
		c2.setY(triangleY[2]);

		  t.paint(g);
		      
		      c0.paint(g);
		      c1.paint(g);
		      c2.paint(g);}
		
	
     
 
   }


@Override
public void mouseClicked(MouseEvent e) {
	
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		if (c0.contains(e.getX(), e.getY()))
		{dragging0=true;
		   }
		if (c1.contains(e.getX(), e.getY()))
		{dragging1=true;
		   }
		if (c2.contains(e.getX(), e.getY()))
		{dragging2=true;
		   }
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	dragging0 = false;
	dragging1 =false;
	dragging2 =false;

	
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		if (dragging0){
			triangleX[0]=e.getX();
			triangleY[0]=e.getY();
			}
		if (dragging1){
			triangleX[1]=e.getX();
			triangleY[1]=e.getY();
			}
		if (dragging2){
			triangleX[2]=e.getX();
			triangleY[2]=e.getY();
			}
		repaint();
}


public Point[] calcPoints(double a, double b, double c) {

	    double angle =Math.acos(-(Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2)) / (2 * b * c));

	    Point[] p = new Point[3];

	    p[0] = new Point(0, 0);
	    p[1] = new Point((int) b, 0);
	    p[2] = new Point((int) (Math.cos(angle) * c), (int) (Math.sin(angle) * c));

	    Point center = new Point((p[0].x + p[1].x + p[2].x) / 3, 
	                             (p[0].y + p[1].y + p[2].y) / 3);

	    for (Point x : p)
	        x.translate(-center.x, -center.y);

	    return p;
	}

@Override
public void mouseMoved(MouseEvent e) {
}



}
