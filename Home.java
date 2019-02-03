	package Grade12;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {

	 // import grinch image, resize and set as JLabel
	 ImageIcon wall = new ImageIcon ("grinch.jpg");
	 Image img =wall.getImage() ;    
	 Image newimg = img.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic = new ImageIcon( newimg );
	 JLabel lb1 = new JLabel(pic);
	 
	 // import start image, resize and set as JButton
	 ImageIcon start = new ImageIcon ("start.png");
	 Image img1 =start.getImage() ;    
	 Image newimg1 = img1.getScaledInstance(150, 70, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic1 = new ImageIcon( newimg1 );
	 JButton b1  = new JButton(pic1);

	 // import instructions image, resize and set as JButton
 	 ImageIcon inst = new ImageIcon ("instructions.png");
	 Image img2 = inst.getImage() ;    
	 Image newimg2 = img2.getScaledInstance(230, 70, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic2 = new ImageIcon( newimg2 );
	 JButton b2  = new JButton(pic2);

	 // import keys image, resize and set as JButton
	 ImageIcon key = new ImageIcon ("keys.png");
	 Image img5 = key.getImage() ;    
	 Image newimg5 = img5.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic5 = new ImageIcon( newimg5 );
	 JButton b3  = new JButton(pic5);
	 
	 // import settings image, resize and set as JButton
	 ImageIcon set = new ImageIcon ("settings.png");
	 Image img6 = set.getImage() ;    
	 Image newimg6 = img6.getScaledInstance(240, 60, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic6 = new ImageIcon( newimg6 );
	 JButton b4  = new JButton(pic6);
	 
	 // import title1 image, resize and set as JLabel
	 ImageIcon deep = new ImageIcon ("ttl.png");
	 Image img3 = deep.getImage() ;    
	 Image newimg3 = img3.getScaledInstance(300, 90, java.awt.Image.SCALE_SMOOTH ) ; 
	 ImageIcon pic3 = new ImageIcon( newimg3 );
	 JLabel lb2  = new JLabel(pic3);

	 // import title2 image, resize and set as JLabel
	 ImageIcon freeze = new ImageIcon ("ttl2.png");
	 Image img4 = freeze.getImage() ;    
	 Image newimg4 = img4.getScaledInstance(300, 90, java.awt.Image.SCALE_SMOOTH ) ;
	 ImageIcon pic4 = new ImageIcon( newimg4 );
	 JLabel lb3  = new JLabel(pic4);
	 
	 // mode number
 	 int level;
	 
 	 // call home constructor
	public static void main(String[] args) throws IOException {
		new Home(1);
	}

	// constructor sets level to l and calls init
	public Home(int l) {
		level = l;
		init();
	}
	
	// runs whole class
	public void init() {
		lb1.setSize(800,500);

		// set buttons to transparent and adjust size
		b1.setBounds(35, 230, 250, 150);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		// set buttons to transparent and adjust size
		b2.setBounds(520, 230, 300, 150);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
	
		// set buttons to transparent and adjust size
		b3.setBounds(520, 330, 300, 150);
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		
		// set buttons to transparent and adjust size
		b4.setBounds(20, 330, 300, 150);
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		
		// set jlabel to transparent and adjust size
		lb2.setBounds(40, 50, 300, 150);
		lb2.setOpaque(false);

		// set jlabel to transparent and adjust size
		lb3.setBounds(490, 50, 300, 150);
		lb3.setOpaque(false);

		// add action listener on buttons
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this  );
		
		// add everything to jframe
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(lb2);
		add(lb3);	
 		add(lb1);
	 

		setSize(800,500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);  
		pack();
	}

	 // action performed
	public void actionPerformed(ActionEvent e) {
		
		// if button 1 call character class
		if(e.getSource() == b1) {
			dispose();
			new Character(level);	 
		}
		// if button 2 call instructions class
		if(e.getSource() == b2) {
			dispose();
			new Instructions();	
		}
		// if button 3 call Keys class
		if(e.getSource() == b3) {
 			dispose();
 			new Keys();
		}
		// if button 4 call Settings class
		if(e.getSource() == b4) {
 			dispose();
 			new Settings();
		}
		
	}
	
	
}
