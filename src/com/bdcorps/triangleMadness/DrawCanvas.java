package com.bdcorps.triangleMadness;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * DrawCanvas (inner class) is a JPanel used for custom drawing
 */
public class DrawCanvas extends JPanel {  public int[] triangleX={0,100,200};
public int[] triangleY={0,100,200};Triangle t;
boolean dragging0 =false,dragging1 =false,dragging2 =false;
Circle c0,c1,c2;
   // Override paintComponent to perform your own painting
	   public DrawCanvas(){
		   t = new Triangle(triangleX,triangleY,Color.BLUE);
		     c0= new Circle(0,0,Color.YELLOW);
		     c1= new Circle(200,200,Color.RED);
		     c2= new Circle(100,100,Color.GREEN);
	   }
	   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);     // paint parent's background
     setBackground(Color.GRAY);  


		c0.setX(triangleX[0]);
		c0.setY(triangleY[0]);
		

		c1.setX(triangleX[1]);
		c1.setY(triangleY[1]);

		c2.setX(triangleX[2]);
		c2.setY(triangleY[2]);
		
    /*  JPanel c = new JPanel();
     c.setBorder(BorderFactory.createEmptyBorder(200,100,100,100));
      c.setLayout(new BorderLayout());
      JTextField field = new JTextField("Hello World", 10); 
      c.add(field, BorderLayout.WEST); 
      field.setVisible(true); 
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      g.drawString("Testing custom drawing ...", 10, 200);
canvas.add(c);*/
     
     
 
  t.paint(g);
      
      c0.paint(g);
      c1.paint(g);
      c2.paint(g);
   }
}
