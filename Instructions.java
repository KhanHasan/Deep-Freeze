package Grade12;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
   
public class Instructions extends JFrame implements ActionListener{

	// import instruction image, resize and set as jlabel
	 ImageIcon screen = new ImageIcon ("instructionMenu.png");
	 Image img1 =screen.getImage() ;    
	 Image newimg1 = img1.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic1 = new ImageIcon( newimg1 );
	 JLabel Screen  = new JLabel(pic1);
	 
	// import home button image, resize and set as jbutton
	 ImageIcon home1 = new ImageIcon ("home.png");
	 Image img2 = home1.getImage() ;    
	 Image newimg2 = img2.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic2 = new ImageIcon( newimg2 );
	 JButton home  = new JButton(pic2);
	
	 // constructor calls init
	public Instructions() {
		init();
	}
	
	
	public void init() {
		setSize(800,500);
 		getContentPane().setLayout(null);
 		
 		// set position of background and size
		Screen.setBounds(0,0,800,500);
		
		// set home button to transparent and implement action listener
		home.addActionListener(this); 
		home.setBounds(10, 10, 150, 60);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		
		// add home button and screen to jframe
		add(home);
		add(Screen);
		setVisible(true);
		setLocationRelativeTo(null);  
	}

	 
	public void actionPerformed(ActionEvent e) {
 		// if home button pressed call home class
		if(e.getSource() == home) {
 			dispose();
 			new Home(1);
 		}
		
	}

}
