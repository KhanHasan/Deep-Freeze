package Grade12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dialogueBox extends JFrame implements ActionListener {

	JButton btn;
	
	public dialogueBox() {
		// call main method
		init();
	}
	
	public void init() {
		setSize(400,140);
		setVisible(true);
		// set screen so it opens in the center of page
		setLocationRelativeTo(null);  
		getContentPane().setLayout(null);
		// set text of jlabel
		JLabel exit = new JLabel("Thank you for playing, we hope you come back soon to play again");
		// add jlabel
		add(exit);
		
		// add exit button
		btn = new JButton("Confirm Exit");
		
		// set location of jlabel and jbutton on screen
		exit.setBounds(0, 0, 400, 50);
		btn.setBounds(100, 50, 200, 40);

		// add jbutton to screen
		btn.addActionListener(this);
		add(btn);
 	}

 	public void actionPerformed(ActionEvent e) {
 		// exit game if button pressed
		 if(e.getSource() == btn) {
			 System.exit(0);
		 }
	}

}
