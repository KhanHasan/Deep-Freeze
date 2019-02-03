  package Grade12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Keys extends JFrame implements ActionListener {

	 // import instruction image resize and set as jlabel
	 ImageIcon wall = new ImageIcon ("inst.png");
	 Image img =wall.getImage() ;    
	 Image newimg = img.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic = new ImageIcon( newimg );
	 JLabel lbin = new JLabel(pic);
	
	 // import instruction image resize and set as jbutton
	 ImageIcon home = new ImageIcon ("home.png");
	 Image img1 =home.getImage() ;    
	 Image newimg1 = img1.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic1 = new ImageIcon( newimg1 );
	 JButton bhome  = new JButton(pic1);

	// constructor calls  init method
	public Keys() {
		init();
	}
	
	// constructor method calls and runs whole
	public void init() {
		lbin.setSize(800,500);
		setSize(800,500);
		
		// set home button transparent and add action listener
		bhome.setOpaque(false);
		bhome.setContentAreaFilled(false);
		bhome.setBorderPainted(false);
		
		bhome.addActionListener(this);
		
		// add screen and button to jframe
		add(bhome);
		add(lbin);
		// set bounds for home button
		bhome.setBounds(480, 330, 150, 60);
		setLocationRelativeTo(null);  
		setVisible(true);
	}
	
	

 	public void actionPerformed(ActionEvent e) {
		// if home button pressed
 		if(e.getSource() == bhome) {
			// remove everything
			getContentPane().removeAll();
			getContentPane().repaint();
			// deleter jframe
 			dispose();
 			// call home
 			new Home(1);
		  		}
	}
}