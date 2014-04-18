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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.bdcorps.triangleSource.TriangleUnit;

public class Starter extends JFrame implements ActionListener {
	public static final int CANVAS_WIDTH = 640;
	public static final int CANVAS_HEIGHT = 480;

	public int[] triangleX = { 0, 100, 200 };
	public int[] triangleY = { 0, 100, 200 };
	boolean dragging0 = false, dragging1 = false, dragging2 = false;
	Circle c0, c1, c2;

	private DrawCanvas canvas;
	TriangleUnit t;
	JTextField j1;
	JTextField j2;
	JTextField j3;
	JTextField j4;
	JTextField j5;
	JTextField j6;
	JPanel mainPanel;
	JPanel solutions1Panel;
	JPanel solutions2Panel;
	JPanel solutionsPanel;
	Boolean init = true;
	double i1 = 30, i2 = 30, i3 = 30;
	double valid_i1 = 60, valid_i2 = 60, valid_i3 = 60;
	int multiplier = 10;

	int i4 = 30, i5 = 30, i6 = 30;
	int valid_i4 = 60, valid_i5 = 60, valid_i6 = 60;

	int round=100;
	
	int drawSolution=1;
	
	JTextField sol1_a,sol1_b,sol1_c,sol1_A,sol1_B,sol1_C,sol1_Peri,sol1_Area;
	JTextField sol2_a,sol2_b,sol2_c,sol2_A,sol2_B,sol2_C,sol2_Peri,sol2_Area;
	public Starter() {
		t = new TriangleUnit();

		mainPanel = new JPanel();
		solutionsPanel = new JPanel(new BorderLayout());
		
		solutions1Panel = new JPanel();
		solutions2Panel = new JPanel();
		// mainPanel.setVisible(false);
		// LoadPanel loadPanel =new LoadPanel();
		// mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 6, 20, 5));
		JLabel srcLabel = new JLabel("a:");
		JLabel dstLabel = new JLabel("b:");
		JLabel srcLabel1 = new JLabel("c:");
		JLabel dstLabel1 = new JLabel("A:");
		JLabel srcLabel2 = new JLabel("B:");
		JLabel dstLabel2 = new JLabel("C:");

		JLabel sol1_Label = new JLabel("Solution 1:");
		JLabel sol1_Label_a = new JLabel("a:");
		JLabel sol1_Label_b = new JLabel("b:");
		JLabel sol1_Label_c = new JLabel("c:");
		JLabel sol1_Label_A = new JLabel("A:");
		JLabel sol1_Label_B = new JLabel("B:");
		JLabel sol1_Label_C = new JLabel("C:");
		JLabel sol1_Label_Peri = new JLabel("Perimeter:");
		JLabel sol1_Label_Area = new JLabel("Area:");
		
		
		 sol1_a = new JTextField("	",5);
		 sol1_b = new JTextField("	",5);
		 sol1_c = new JTextField("	",5);
		 sol1_A = new JTextField("	",5);
		 sol1_B = new JTextField("	",5);
		 sol1_C = new JTextField("	",5);
		 sol1_Peri = new JTextField("	",5);
		 sol1_Area = new JTextField("	",5);

		JLabel sol2_Label = new JLabel("Solution 2:");
		JLabel sol2_Label_a = new JLabel("a:");
		JLabel sol2_Label_b = new JLabel("b:");
		JLabel sol2_Label_c = new JLabel("c:");
		JLabel sol2_Label_A = new JLabel("A:");
		JLabel sol2_Label_B = new JLabel("B:");
		JLabel sol2_Label_C = new JLabel("C:");
		JLabel sol2_Label_Peri = new JLabel("Perimeter:");
		JLabel sol2_Label_Area = new JLabel("Area:");

		 sol2_a = new JTextField("	",5);
		 sol2_b = new JTextField("	",5);
		 sol2_c = new JTextField("	",5);
		 sol2_A = new JTextField("	",5);
		 sol2_B = new JTextField("	",5);
		 sol2_C = new JTextField("	",5);
		 sol2_Peri = new JTextField("	",5);
		 sol2_Area = new JTextField("	",5);

		sol1_Label_a.setLabelFor(sol1_a);

		sol1_Label_b.setLabelFor(sol1_b);
		sol1_Label_c.setLabelFor(sol1_c);
		sol1_Label_A.setLabelFor(sol1_A);

		sol1_Label_B.setLabelFor(sol1_B);

		sol1_Label_C.setLabelFor(sol1_C);
	//solutions1Panel.setLayout(new GridLayout(2, 6, 20, 5));
	
	solutions1Panel.setLayout(new BoxLayout(solutions1Panel,
			BoxLayout.PAGE_AXIS));/*
		 * solutions1Panel.add(sol1_Label_a); solutions1Panel.add(sol1_Label_b);
		 * solutions1Panel.add(sol1_Label_c); solutions1Panel.add(sol1_Label_A);
		 * solutions1Panel.add(sol1_Label_B); solutions1Panel.add(sol1_Label_C);
		 */

		
	/*	solutions1Panel.add(sol1_a);
		solutions1Panel.add(sol1_b);
		solutions1Panel.add(sol1_c);
		solutions1Panel.add(sol1_A);
		solutions1Panel.add(sol1_B);
		solutions1Panel.add(sol1_C);*/

	solutions1Panel.add(new JSeparator(SwingConstants.HORIZONTAL));
	JPanel p1= new JPanel();
	solutions1Panel.add(sol1_Label);
		p1.add(sol1_Label_a);
		p1.add(sol1_a);
		
		solutions1Panel.add(p1);
		
		JPanel p2= new JPanel();
		p2.add(sol1_Label_b);
		p2.add(sol1_b);
		
		solutions1Panel.add(p2);
		
		JPanel p3= new JPanel();
		p3.add(sol1_Label_c);
		p3.add(sol1_c);
		
		solutions1Panel.add(p3);
		
		JPanel p4= new JPanel();
		p4.add(sol1_Label_A);
		p4.add(sol1_A);
		
		solutions1Panel.add(p4);
		
		JPanel p5= new JPanel();
		p5.add(sol1_Label_B);
		p5.add(sol1_B);
		
		solutions1Panel.add(p5);
		
		JPanel p6= new JPanel();
		p6.add(sol1_Label_C);
		p6.add(sol1_C);
		
		solutions1Panel.add(p6);
		
		
		JPanel p7= new JPanel();
		p7.add(sol1_Label_Peri);
		p7.add(sol1_Peri);
		
		solutions1Panel.add(p7);
		
		JPanel p8= new JPanel();
		p8.add(sol1_Label_Area);
		p8.add(sol1_Area);
		
		solutions1Panel.add(p8);
		
		solutionsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
	

		
		JPanel p21= new JPanel();
		solutions2Panel.add(sol2_Label);
		p21.add(sol2_Label_a);
		p21.add(sol2_a);
		
		solutions2Panel.add(p21);
		
		JPanel p22= new JPanel();
		p22.add(sol2_Label_b);
		p22.add(sol2_b);
		
		solutions2Panel.add(p22);
		
		JPanel p23= new JPanel();
		p23.add(sol2_Label_c);
		p23.add(sol2_c);
		
		solutions2Panel.add(p23);
		
		JPanel p24= new JPanel();
		p24.add(sol2_Label_A);
		p24.add(sol2_A);
		
		solutions2Panel.add(p24);
		
		JPanel p25= new JPanel();
		p25.add(sol2_Label_B);
		p25.add(sol2_B);
		
		solutions2Panel.add(p25);
		
		JPanel p26= new JPanel();
		p26.add(sol2_Label_C);
		p26.add(sol2_C);
		
		solutions2Panel.add(p26);
		
		JPanel p27= new JPanel();
		p27.add(sol2_Label_Peri);
		p27.add(sol2_Peri);
		
		solutions2Panel.add(p27);
		
		
		JPanel p28= new JPanel();
		p28.add(sol2_Label_Area);
		p28.add(sol2_Area);
		
		solutions2Panel.add(p28);
		
		solutions2Panel.setLayout(new BoxLayout(solutions2Panel,
				BoxLayout.PAGE_AXIS));
	/*	solutions2Panel.add(sol2_Label_a);
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
*/
		j1 = new JTextField("");

		j2 = new JTextField("");
		j3 = new JTextField("");
		j4 = new JTextField("");
		j5 = new JTextField("");
		j6 = new JTextField("");

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

		
		solutionsPanel.add(solutions1Panel, BorderLayout.PAGE_START);
	//	solutionsPanel.add(solutions2Panel,BorderLayout.PAGE_END);
		
		
		
		JButton calcButton = new JButton("Calculate");
		btnPanel.add(calcButton);
		calcButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "Bitch", "InfoBox: ",
				// JOptionPane.INFORMATION_MESSAGE);
t=new TriangleUnit();
				int sideCount = 0, angleCount = 0;

				if (isValidSide(j1.getText())) {
					i1 = Double.parseDouble(j1.getText());
					valid_i1 = i1;
					sideCount++;
					t.puta1(i1);
				} else {// i1=valid_i1;
					j1.setText("");
				}

				if (isValidSide(j2.getText())) {
					i2 = Double.parseDouble(j2.getText());
					valid_i2 = i2;
					sideCount++;
					t.putb1(i2);
				} else {// i2=valid_i2;
					j2.setText("");
				}

				if (isValidSide(j3.getText())) {
					i3 = Double.parseDouble(j3.getText());
					valid_i3 = i3;
					sideCount++;
					t.putc1(i3);
				} else {// i3=valid_i3;
					j3.setText("");
				}

				if (isValidAngle(j4.getText())) {
					i4 = (int)Double.parseDouble(j4.getText());
					valid_i4 = i4;
					angleCount++;
					t.putA1(i4);
				} else {// i4=valid_i4;
					j4.setText("");
				}

				if (isValidAngle(j5.getText())) {
					i5 =(int)Double.parseDouble(j5.getText());
					valid_i5 = i5;
					angleCount++;
					t.putB1(i5);
				} else {// i5=valid_i5;
					j5.setText("");
				}

				if (isValidAngle(j6.getText())) {
					i6 = (int)Double.parseDouble(j6.getText());
					valid_i6 = i6;
					angleCount++;
					t.putC1(i6);
				} else { //i6=valid_i6;
					j6.setText("");
				}

				if ((sideCount + angleCount) >= 3) {
					canvas.setFirstLaunch(false);
					if (t.getSolutions() ==1){
						 System.out.print(t.getSolutions());
			        	solutionsPanel.remove(solutions2Panel);
			        	validate();
			        }
					else if (t.getSolutions() ==2){
						 System.out.print(t.getSolutions());
			        	solutionsPanel.add(solutions2Panel);
			        	validate();
			        }
				}
/*
				j1.setText(roundIt(t.geta1(),round));
				j2.setText(roundIt(t.getb1(),round));
				j3.setText(roundIt(t.getc1(),round));

				j4.setText(roundIt(t.getA1(),round));
				j5.setText(roundIt(t.getB1(),round));
				j6.setText(roundIt(t.getC1(),round));*/

				
				sol1_a.setText(roundIt(t.geta1(),round));
				sol1_b.setText(roundIt(t.getb1(),round));
				sol1_c.setText(roundIt(t.getc1(),round));
				sol1_A.setText(roundIt(t.getA1(),round));
				sol1_B.setText(roundIt(t.getB1(),round));
				sol1_C.setText(roundIt(t.getC1(),round));
				sol1_Peri.setText(roundIt(t.getPerimeter1(),round));
				sol1_Area.setText(roundIt(t.getArea1(),round));
				
				sol2_a.setText(roundIt(t.geta2(),round));
				sol2_b.setText(roundIt(t.getb2(),round));
				sol2_c.setText(roundIt(t.getc2(),round));
				sol2_A.setText(roundIt(t.getA2(),round));
				sol2_B.setText(roundIt(t.getB2(),round));
				sol2_C.setText(roundIt(t.getC2(),round));
				sol2_Peri.setText(roundIt(t.getPerimeter2(),round));
				sol2_Area.setText(roundIt(t.getArea2(),round));
				
				if (drawSolution==2)
				{
					if (t.getSolutions()==1){
						drawSolution=1;
					}
				}
			       
				if (drawSolution==1){
				canvas.UpdateTriangle(t.geta1()*multiplier,t.getb1()*multiplier,t.getc1()*multiplier);
				}else if (drawSolution==2){
					canvas.UpdateTriangle(t.geta2()*multiplier,t.getb2()*multiplier,t.getc2()*multiplier);
					}
				requestFocus(); // change the focus to JFrame to receive
								// KeyEvent
			}
		});

	

		 //Create the menu bar.
		JMenuBar menuBar = new JMenuBar();
 
        //Build the first menu.
		JMenu menu = new JMenu("Options");
      
        menuBar.add(menu);
        
        JMenu submenu1 = new JMenu("Rounding Places");
        menu.add(submenu1);
        JMenuItem item_round10 = new JMenuItem("10");
        submenu1.add(item_round10);
        
        
        item_round10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				round =10;
				System.out.print("click");
			}});

        JMenuItem item_round100 = new JMenuItem("100");
        submenu1.add(item_round100);
        
        
        item_round100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				round =100;
				System.out.print("click100");
			}});
				
        JMenuItem item_round1000 = new JMenuItem("1000");
        submenu1.add(item_round1000);
        
        
        item_round1000.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				round =1000;
				System.out.print("click1000");
			}});

        
        JMenu submenu2 = new JMenu("Solution to draw");
        menu.add(submenu2);
        JMenuItem item_drawSolution1 = new JMenuItem("Solution 1");
        
        item_drawSolution1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			drawSolution=1;
			}});
        submenu2.add(item_drawSolution1);
        
        JMenuItem item_drawSolution2 = new JMenuItem("Solution 2");
        item_drawSolution2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			drawSolution=2;
			}});
        submenu2.add(item_drawSolution2);
        
        setJMenuBar(menuBar);
       
		
		canvas = new DrawCanvas();
		canvas.setFirstLaunch(true);
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		
		cp.add(solutionsPanel,BorderLayout.EAST);
		
		
		cp.add(mainPanel, BorderLayout.PAGE_START);
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(btnPanel, BorderLayout.PAGE_END);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE
														// button
		setTitle("Triangle Solver");
		pack(); // pack all the components in the JFrame
		setVisible(true); // show it

		
		
		
		requestFocus();
	}

	public static boolean isValidSide(String str) {
		try {
			double d = Double.parseDouble(str);
			if (d<0)return false;
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isValidAngle(String str) {
		try {
			double d = Double.parseDouble(str);
			if (d<0||d>180)return false;
		} catch (NumberFormatException nfe) {
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

		double angle = Math.acos(-(Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(
				c, 2)) / (2 * b * c));

		Point[] p = new Point[3];

		p[0] = new Point(0, 0);
		p[1] = new Point(b, 0);
		p[2] = new Point((int) (Math.cos(angle) * c),
				(int) (Math.sin(angle) * c));

		Point center = new Point((p[0].x + p[1].x + p[2].x) / 3, (p[0].y
				+ p[1].y + p[2].y) / 3);

		for (Point x : p)
			x.translate(-center.x, -center.y);

		return p;
	}
	
	public static String roundIt(double x,int round) { 
		x = Math.round(x*round)/round; //rounds number to 1 decimal place 
		return String.valueOf(x);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}