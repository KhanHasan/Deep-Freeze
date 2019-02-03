package Grade12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
 
public class Settings extends JFrame implements ItemListener, ActionListener {

	// import home button image, resize and set as JLabel
	 ImageIcon home1 = new ImageIcon ("home.png");
	 Image img2 = home1.getImage() ;    
	 Image newimg2 = img2.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH ) ; //scaled image to fit 100x70
	 ImageIcon pic2 = new ImageIcon( newimg2 );
	 JButton home  = new JButton(pic2);
	 
	 // determines which mode was picked
	 int modeNum = 1;
	
	 // add radio buttons
	JRadioButton rad1 = new JRadioButton("Easy");
	JRadioButton rad2 = new JRadioButton("Medium");
	JRadioButton rad3 = new JRadioButton("Hard");
	
	// JLabel mode
	JLabel mode = new JLabel("MODE");

	// constructor calls init
	public Settings() {
		init();
	}
	
	// method creates and runs class
	public void init() {
		setSize(300,400);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		// font for mode and radio buttons
		Font f = new Font("Times New Roman",Font.BOLD ,40 );
		mode.setFont(f);
		mode.setForeground(Color.white);
		mode.setBounds(88, 5, 125, 50);
		add(mode);
		
		// set radio buttons to transparent, change color and font and add to jframe
		rad1.setOpaque(false);
        rad1.setContentAreaFilled(false);
        rad1.setBorderPainted(false);
 		rad1.setBounds(87,80,125,50);
		rad1.setForeground(Color.white);
		rad1.setFont(f);
		add(rad1);
		
		// set radio buttons to transparent, change color and font and add to jframe
		rad2.setOpaque(false);
        rad2.setContentAreaFilled(false);
        rad2.setBorderPainted(false);
 		rad2.setBounds(65,140,170,50);
		rad2.setForeground(Color.white);
		rad2.setFont(f);
		add(rad2);
		
		// set radio buttons to transparent, change color and font and add to jframe
		rad3.setOpaque(false);
        rad3.setContentAreaFilled(false);
        rad3.setBorderPainted(false);
 		rad3.setBounds(87,200,125,50);
		rad3.setForeground(Color.white);
		rad3.setFont(f);
		add(rad3);

		// set home buttons to transparent add to jframe
		home.setBounds(75, 280, 150, 60);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(this);
		add(home);
		
		// put buttons in group so only one can be picked
		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		group.add(rad3);

		// add item lister to buttons
		rad1.addItemListener(this);
		rad2.addItemListener(this);
		rad3.addItemListener(this);
		setLocationRelativeTo(null);  
	}

 	public void itemStateChanged(ItemEvent event) {
 		// determine which button selected, change modeNum based on button
 		if(event.getItemSelectable() == rad1) {
 			modeNum = 1;
  		}
 		if(event.getItemSelectable() == rad2) {
 			modeNum = 2;
  		}
 		if(event.getItemSelectable() == rad3) {
 			modeNum = 3;
  		}
 		
	}

 	public void actionPerformed(ActionEvent e) {
 		// if home button pressed
 		if(e.getSource() == home) {
 			// delete jframe
 			dispose();
 			// go home and send mode Num
 			new Home(modeNum);
 		}
	}
	
}
