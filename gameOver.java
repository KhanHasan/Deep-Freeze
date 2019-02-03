package Grade12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class gameOver extends JPanel implements ActionListener {

	// import background image, resize it and set as JLabel
	ImageIcon backGround = new ImageIcon("gameOver.jpg");
	Image img1 = backGround.getImage();
	Image newimg1 = img1.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic1 = new ImageIcon(newimg1);
	JLabel backGroundScreen = new JLabel(pic1);

	// import game over image, resize it and set as JLabel
	ImageIcon prompt = new ImageIcon("gameOvertxt.png");
	Image img2 = prompt.getImage();
	Image newimg2 = img2.getScaledInstance(558, 73, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic2 = new ImageIcon(newimg2);
	JLabel GameOver = new JLabel(pic2);
	
	// import you win image, resize it and set as JLabel
	ImageIcon Win1 = new ImageIcon("WIN.png");
	Image img3 = Win1.getImage();
	Image newimg3 = img3.getScaledInstance(360, 100, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic3 = new ImageIcon(newimg3);
	JLabel winner = new JLabel(pic3);
	
	// import nice try image, resize it and set as JLabel
	ImageIcon Try = new ImageIcon("niceTry.png");
	Image img4 = Try.getImage();
	Image newimg4 = img4.getScaledInstance(360, 100, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic4 = new ImageIcon(newimg4);
	JLabel niceTry = new JLabel(pic4);
	
	
// 	JButton playAgain;
	
	// add button to leave
 	JButton leave;
	
 	JFrame jf = new JFrame();
 	
 	//pre: boolean win, determines if won or not
	// constructor calls init
 	public gameOver(boolean win) {
		init(win);
	}

	//pre: boolean win, determines if won or not
 	// runs whole class
	public void init(boolean win) {
		jf.setSize(800, 500);
		jf.setLocationRelativeTo(null);  
		jf.setVisible(true);	
	 
 //		playAgain = new JButton("Play Again");
		leave = new JButton("Exit");
		
//		playAgain.addActionListener(this);
		leave.addActionListener(this);
		
		// set font for exit button
		Font f = new Font("Times New Roman",Font.BOLD ,60 );
//		playAgain.setFont(f);
		leave.setFont(f);
//		playAgain.setForeground(Color.white);
		leave.setForeground(Color.white);
		leave.setOpaque(false);
		leave.setContentAreaFilled(false);
		leave.setBorderPainted(false);
		
//		playAgain.setBounds(500, 300, 100, 50);
		
		
		// set positions for exit button, background and game over
		leave.setBounds(650, 370, 150, 100);
		backGroundScreen.setBounds(0, 0, 800, 500);
		GameOver.setBounds(190, 50, 600, 200);
		
		// set position for winner and nice try
		winner.setBounds(300, 230, 360, 100);
		winner.setVisible(false);
		niceTry.setBounds(300, 230, 360, 100);
		
		// if won then display winner and not nice try
		if(win) {
	 		winner.setVisible(true);
	 		niceTry.setVisible(false);
		}
		
		// add components to jframe
 		jf.add(winner);
		jf.add(niceTry);
 		
//		add(playAgain);
		jf.add(leave);
		jf.add(GameOver);
		jf.add(backGroundScreen);
 
	}

 	public void actionPerformed(ActionEvent e) {
// 		if(e.getSource() == playAgain) {
// 			dispose();
// 			new Home();
// 		}
 		// once exit button pressed exit the game
 		if(e.getSource() == leave) {
 			new dialogueBox();
  		}
 		
 		
	}

}
