package com.bdcorps.triangleMadness;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Starter extends JFrame implements MouseListener,MouseMotionListener,ActionListener {
   public static final int CANVAS_WIDTH = 640;
   public static final int CANVAS_HEIGHT = 480;
   
   public int[] triangleX={0,100,200};
  public int[] triangleY={0,100,200};
boolean dragging0 =false,dragging1 =false,dragging2 =false;
  Circle c0,c1,c2;
 
   private DrawCanvas canvas;
   Triangle t;
   JFormattedTextField j1;
   JTextField j2;
   JTextField j3;
   JPanel mainPanel;
   public Starter() {
       mainPanel = new JPanel();
      mainPanel.setVisible(false);
	   LoadPanel loadPanel =new LoadPanel();
       // mainPanel = new JPanel();
	        mainPanel.setLayout(new GridLayout(2,6,20,5));
	        JLabel srcLabel = new JLabel("a:");
	        JLabel dstLabel = new JLabel("b:");
	        JLabel srcLabel1 = new JLabel("c:");
	        JLabel dstLabel1 = new JLabel("A:");
	        JLabel srcLabel2 = new JLabel("B:");
	        JLabel dstLabel2 = new JLabel("C:");

j1 = new JFormattedTextField(NumberFormat.getInstance());
	        
	         j2 = new JTextField("z");
	         j3 = new JTextField("z");
	        JTextField j4 = new JTextField("z");
	        JTextField j5 = new JTextField("z");
	        JTextField j6 = new JTextField("z");
	        

	        JPanel btnPanel = new JPanel();	        
	        
	        mainPanel.add(srcLabel);
	        mainPanel.add(dstLabel);
	        
	        mainPanel.add(srcLabel1);
	        mainPanel.add(dstLabel1);
	        
	        mainPanel.add(srcLabel2);
	        mainPanel.add(dstLabel2);
	        
	        mainPanel.add(j1);
	        mainPanel.add(j2);
	        
	        mainPanel.add(j3);
	        mainPanel.add(j4);
	         
	        mainPanel.add(j5);
	        mainPanel.add(j6);
	        
	        
	        /*
	        JPanel leftPanel = new JPanel();
	        JLabel srcLabel = new JLabel("Source record:");
	        leftPanel.add(srcLabel);
	        JPanel rightPanel = new JPanel();
	        JLabel dstLabel = new JLabel("Destination record:");
	        rightPanel.add(dstLabel);

	        mainPanel.add(leftPanel);
	        mainPanel.add(rightPanel);

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	       
mainPanel.add(buttonPanel);*/
	        JButton okButton = new JButton("OK");
	        btnPanel.add(okButton);
	        okButton.addActionListener(this);
	        okButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	//JOptionPane.showMessageDialog(null, "Bitch", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);

	                Point[] p = calcPoints(Integer.parseInt(j1.getText()),Integer.parseInt(j2.getText()),Integer.parseInt(j3.getText()));
	                for (int i = 0; i < p.length; i++){
	                  triangleX[i]=p[i].x+100; 
	                triangleY[i] =p[i].y+100; 
	                repaint();
	                }
	               requestFocus(); // change the focus to JFrame to receive KeyEvent
	            }
	         });
	        
	        JButton cancelButton = new JButton("Cancel");
	        btnPanel.add(cancelButton);
	        
	      canvas = new DrawCanvas();
	      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	 
	      canvas.addMouseListener(this);
	      canvas.addMouseMotionListener(this);
	      
	      Container cp = getContentPane();
	      BorderLayout bl =new BorderLayout();
	      cp.setLayout(new BorderLayout());
		     cp.add(mainPanel, BorderLayout.PAGE_START);
	      cp.add(canvas, BorderLayout.CENTER);
	      cp.add(btnPanel,BorderLayout.PAGE_END);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
	      setTitle("Move a Line");
	      pack();           // pack all the components in the JFrame
	     setVisible(true); // show it
	      requestFocus();  
   }
 
   
   public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Starter(); // Let the constructor do the job
         }
      });
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

@Override
public void mouseMoved(MouseEvent e) {
}

public Point[] calcPoints(int a, int b, int c) {

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
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}