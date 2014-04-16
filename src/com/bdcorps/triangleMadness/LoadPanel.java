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

@SuppressWarnings("serial")
public class LoadPanel extends JPanel implements ActionListener {
   public static final int CANVAS_WIDTH = 640;
   public static final int CANVAS_HEIGHT = 480;
   
   public int[] triangleX={0,100,200};
  public int[] triangleY={0,100,200};
boolean dragging0 =false,dragging1 =false,dragging2 =false;
  Circle c0,c1,c2;
 
   Triangle t;
   JFormattedTextField j1;
   JTextField j2;
   JTextField j3; 
   public LoadPanel() {

       JPanel mainPanel = new JPanel();
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
	            	JOptionPane.showMessageDialog(null, "Bitch", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);

	                
	               requestFocus(); // change the focus to JFrame to receive KeyEvent
	            }
	         });
	        
	        JButton cancelButton = new JButton("Cancel");
	        btnPanel.add(cancelButton);
	        
	      
	       
   }
 
   public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new LoadPanel(); // Let the constructor do the job
         }
      });
   }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}