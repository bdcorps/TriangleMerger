package com.bdcorps.triangleMadness;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.bdcorps.triangleSource.TriangleUnit;

public class Starter extends JFrame implements ActionListener {
   public static final int CANVAS_WIDTH = 640;
   public static final int CANVAS_HEIGHT = 480;
   
   public int[] triangleX={0,100,200};
  public int[] triangleY={0,100,200};
boolean dragging0 =false,dragging1 =false,dragging2 =false;
  Circle c0,c1,c2;
 
   private DrawCanvas canvas;
   TriangleUnit t;
   JTextField j1;
   JTextField j2;
   JTextField j3; JTextField j4;
   JTextField j5; JTextField j6;
   JPanel mainPanel;
   JPanel solutions1Panel;
   JPanel solutions2Panel;
   Boolean init=true;	
   double i1=30, i2=30, i3=30;
	double valid_i1=60,valid_i2=60,valid_i3=60;
	
	int i4=30, i5=30, i6=30;
	int valid_i4=60,valid_i5=60,valid_i6=60;
	
   public Starter() {
	   t= new TriangleUnit();
	   
       mainPanel = new JPanel();
       solutions1Panel= new JPanel();
       solutions2Panel= new JPanel();
      //mainPanel.setVisible(false);
	 //  LoadPanel loadPanel =new LoadPanel();
       // mainPanel = new JPanel();
	        mainPanel.setLayout(new GridLayout(2,6,20,5));
	        JLabel srcLabel = new JLabel("a:");
	        JLabel dstLabel = new JLabel("b:");
	        JLabel srcLabel1 = new JLabel("c:");
	        JLabel dstLabel1 = new JLabel("A:");
	        JLabel srcLabel2 = new JLabel("B:");
	        JLabel dstLabel2 = new JLabel("C:");
	        
	        JLabel sol1_Label_a = new JLabel("a:");
	        JLabel sol1_Label_b = new JLabel("b:");
	        JLabel sol1_Label_c = new JLabel("c:");
	        JLabel sol1_Label_A = new JLabel("A:");
	        JLabel sol1_Label_B = new JLabel("B:");
	        JLabel sol1_Label_C = new JLabel("C:");
	        
	        JTextField sol1_a = new JTextField("");
	        JTextField sol1_b = new JTextField("");
	        JTextField sol1_c = new JTextField("");
	        JTextField sol1_A = new JTextField("");
	        JTextField sol1_B = new JTextField("");
	        JTextField sol1_C = new JTextField("");
	        
	        JLabel sol2_Label_a = new JLabel("a:");
	        JLabel sol2_Label_b = new JLabel("b:");
	        JLabel sol2_Label_c = new JLabel("c:");
	        JLabel sol2_Label_A = new JLabel("A:");
	        JLabel sol2_Label_B = new JLabel("B:");
	        JLabel sol2_Label_C = new JLabel("C:");
	        
	        JTextField sol2_a = new JTextField("");
	        JTextField sol2_b = new JTextField("");
	        JTextField sol2_c = new JTextField("");
	        JTextField sol2_A = new JTextField("");
	        JTextField sol2_B = new JTextField("");
	        JTextField sol2_C = new JTextField("");

	        sol1_Label_a.setLabelFor(sol1_a);

	        sol1_Label_b.setLabelFor(sol1_b);
	        sol1_Label_c.setLabelFor(sol1_c);
	        sol1_Label_A.setLabelFor(sol1_A);

	        sol1_Label_B.setLabelFor(sol1_B);

	        sol1_Label_C.setLabelFor(sol1_C);	        
	       solutions1Panel.setLayout(new GridLayout(2,6,20,5));	        
	       /*   solutions1Panel.add(sol1_Label_a);
	        solutions1Panel.add(sol1_Label_b);
	        solutions1Panel.add(sol1_Label_c);
	        solutions1Panel.add(sol1_Label_A);
	        solutions1Panel.add(sol1_Label_B);
	        solutions1Panel.add(sol1_Label_C);
	        */
	        
	        solutions1Panel.add(sol1_a);
	        solutions1Panel.add(sol1_b);
	        solutions1Panel.add(sol1_c);
	        solutions1Panel.add(sol1_A);
	        solutions1Panel.add(sol1_B);
	        solutions1Panel.add(sol1_C);

	        solutions2Panel.setLayout(new BoxLayout(solutions2Panel, BoxLayout.PAGE_AXIS));        
	        solutions2Panel.add(sol2_Label_a);
	        solutions2Panel.add(sol2_Label_b);
	        solutions2Panel.add(sol2_Label_c);
	        solutions2Panel.add(sol2_Label_A);
	        solutions2Panel.add(sol2_Label_B);
	        solutions2Panel.add(sol2_Label_C);
	        
	        
	        solutions2Panel.add(sol2_a);
	        solutions2Panel.add(sol2_b);
	        solutions2Panel.add(sol2_c);
	        solutions2Panel.add(sol2_A);
	        solutions2Panel.add(sol2_B);
	        solutions2Panel.add(sol2_C);
	        
j1 = new JTextField("30");
	        
	         j2 = new JTextField("30");
	         j3 = new JTextField("30");
	         j4 = new JTextField("60");
	         j5 = new JTextField("60");
	        j6 = new JTextField("60");
	        

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
	            
	            	  int sideCount=0,angleCount=0;
	            	
	            	if (isNumeric(j1.getText())){
	            	i1 =Double.parseDouble(j1.getText());
	            	valid_i1=i1;
	            	sideCount++;t.puta1(i1);}else {//i1=valid_i1;
	            	j1.setText("");
	            	}
	            	
	             	if (isNumeric(j2.getText())){
		            	i2 =Double.parseDouble(j2.getText());
		            	valid_i2=i2; 	sideCount++;t.putb1(i2);}else {//i2=valid_i2;
j2.setText("");
		            	}
	             	
	             	if (isNumeric(j3.getText())){
		            	i3 =Double.parseDouble(j3.getText());
		            	valid_i3=i3; 	sideCount++;t.putc1(i3);}else {//i3=valid_i3;	
		            	j3.setText("");
		            	}
	             	
	              	if (isNumeric(j4.getText())){
		            	i4 =Integer.parseInt(j4.getText());
		            	valid_i4=i4; 	angleCount++;t.putA1(i4);}else {//i4=valid_i4;
		            	j4.setText("");
		            	}
		            	
		             	if (isNumeric(j5.getText())){
			            	i5 =Integer.parseInt(j5.getText());
			            	valid_i5=i5;angleCount++;t.putB1(i5);}else {//i5=valid_i5;
			            	j5.setText("");
			            	}
		             	
		             	if (isNumeric(j6.getText())){
			            	i6 =Integer.parseInt(j6.getText());
			            	valid_i6=i6;angleCount++;t.putC1(i6);}else {//i6=valid_i6;
			            	j6.setText("");
			            	}

		             	if ((sideCount+angleCount)==3){
		             		canvas.setFirstLaunch(false);
		             	}
		             	System.out.print(t.getC2());

	             	j1.setText(String.valueOf(t.geta1()));
	             	j2.setText(String.valueOf(t.getb1()));
	             	j3.setText(String.valueOf(t.getc1()));
	             	
	             	j4.setText(String.valueOf(t.getA1()));
	             	j5.setText(String.valueOf(t.getB1()));
	             	j6.setText(String.valueOf(t.getC1()));
	             	
		             	canvas.UpdateTriangle(i1,i2,i3);
	           
	               requestFocus(); // change the focus to JFrame to receive KeyEvent
	            }
	         });
	        
	        JButton cancelButton = new JButton("Cancel");
	        btnPanel.add(cancelButton);
	        
	      canvas = new DrawCanvas();
		     canvas.setFirstLaunch(true);
	      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	 
	      
	      Container cp = getContentPane();
	      BorderLayout bl =new BorderLayout();
	      cp.setLayout(new BorderLayout());
	      
	    cp.add(solutions1Panel,BorderLayout.WEST);

	    cp.add(solutions2Panel,BorderLayout.EAST);
		     cp.add(mainPanel, BorderLayout.PAGE_START);
	      cp.add(canvas, BorderLayout.CENTER);
	      cp.add(btnPanel,BorderLayout.PAGE_END);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
	      setTitle("Move a Line");
	      pack();           // pack all the components in the JFrame
	     setVisible(true); // show it
	     
	     
	     
	     
	     
	     
	     
	     /////////////////////////////////////////////////////////////////////////////////
	     
	     
	     
	     
	     
	      requestFocus();  
   }
 
   public static boolean isNumeric(String str)  
   {  
     try  
     {  
       double d = Double.parseDouble(str);  
     }  
     catch(NumberFormatException nfe)  
     {  
       return false;  
     }  
     return true;  
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