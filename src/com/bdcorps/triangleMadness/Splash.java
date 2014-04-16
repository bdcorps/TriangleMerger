package com.bdcorps.triangleMadness;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
public class Splash extends JWindow implements MouseListener{  
    JLabel splashImgHolder;  
    Image image;  
    ImageIcon splashIcon;  
    JPanel contentPane;  
    static Splash splash;
      
    public Splash(){  

        addMouseListener(this);
        image = new ImageIcon((getClass().getResource("bdcorps-logo2.png")))  
        .getImage();  
        splashIcon = new ImageIcon(image);  
          
       /** 
        * Enables the events defined by the specified event mask parameter to  
        * be delivered to this component. Event types are automatically enabled 
        * when a listener for that event type is added to the component. 
        */         
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);  
          
        try{  
            showSplash();  
        }catch(Exception ex){  
            System.out.println("Error! " + ex.getMessage());  
            System.exit(1);  
        }  
          
        this.setVisible(true);  
          
        try{  
            Thread.sleep(5000);  
        }catch(InterruptedException e){  
            //do nothing here!  
        }  
        
    }  
  
  
    @Override  
    public void setVisible(boolean b) {  
        super.setVisible(b);  
    }  
    private void showSplash() throws Exception{  
        splashImgHolder = new JLabel();  
        splashImgHolder.setIcon(splashIcon);  
          
        contentPane = ((JPanel)this.getContentPane());  
        contentPane.setLayout(new BorderLayout());  
        contentPane.add(splashImgHolder, BorderLayout.NORTH);  
          
        setSplashLocation();  
          
        pack();  
          
    }  
  
    private void setSplashLocation() {  
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();  
        Dimension frame = this.getSize();       
          
        int x = (int)(screen.getWidth() - frame.getWidth())/2;  
        int y = (int)(screen.getHeight() - frame.getHeight())/2 - 50;  
          
        this.setLocation(x, y);  
    }  
    public static void main(String[] arg){  
    splash = new Splash();  
    
        //get rid of window as it finished showing  
        splash.dispose();  
    }  



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("dff");
	 	 //System.exit(0);
		Starter t= new Starter(); 
	this.dispose();
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}  