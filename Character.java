package Grade12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Character extends JFrame implements ActionListener {

	// imports santa clause image, resizes it and makes it a JButton
	ImageIcon c1 = new ImageIcon("santa.png");
	Image img = c1.getImage();
	Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic = new ImageIcon(newimg);
	JButton char1 = new JButton(pic);

	// imports rudolf image, resizes it and makes it a JButton
	ImageIcon c2 = new ImageIcon("rudolf.png");
	Image img2 = c2.getImage();
	Image newimg2 = img2.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic2 = new ImageIcon(newimg2);
	JButton char2 = new JButton(pic2);

	// imports frosty image, resizes it and makes it a JButton
	ImageIcon c3 = new ImageIcon("frosty.png");
	Image img3 = c3.getImage();
	Image newimg3 = img3.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic3 = new ImageIcon(newimg3);
	JButton char3 = new JButton(pic3);

	// imports elf image, resizes it and makes it a JButton
	ImageIcon c4 = new ImageIcon("elf.jpg");
	Image img4 = c4.getImage();
	Image newimg4 = img4.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic4 = new ImageIcon(newimg4);
	JButton char4 = new JButton(pic4);

	// imports next button image, resizes it and makes it a JButton
	ImageIcon n = new ImageIcon("next.png");
	Image img5 = n.getImage();
	Image newimg5 = img5.getScaledInstance(170, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon pic5 = new ImageIcon(newimg5);
	JButton nxt = new JButton(pic5);

	// represents number user selects
	int characterNumber;

	// checks if character picked
	boolean picked = false;

	// multiple jpanels in grid layout
	JPanel p1, p2, p3, pmain;
	JLabel l1, l2, l3;
	
	// mode character picks
	int level;

	public Character(int l) {
		level = l;
		init();
	}

	//method creates everything and outputs character options
	public void init() {
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);  
		getContentPane().setBackground(Color.BLUE);

		// main jpanel, every other jpanel within it
		pmain = new JPanel();
		pmain.setLayout(new GridLayout(1, 3));

		p1 = new JPanel();
		p2 = new JPanel();

		// edit buttons to get rid of background
		editButton(char1);
		editButton(char2);
		editButton(char3);
		editButton(char4);
		editButton(nxt);

		// add action listeners
		char1.addActionListener(this);
		char2.addActionListener(this);
		char3.addActionListener(this);
		char4.addActionListener(this);
		nxt.addActionListener(this);

		// add gridlayout within gridlayout
		p1.setLayout(new GridLayout(2, 1, 5, 5));
		p1.add(char1);
		p1.add(char2);

		// add gridlayout within gridlayout
		p2.setLayout(new GridLayout(2, 1, 5, 5));
		p2.add(char3);
		p2.add(char4);

		p3 = new JPanel();
		p3.setLayout(new GridLayout(4, 1, 3, 3));

		// set font for title
		Font f = new Font("Times New Roman", Font.BOLD, 40);

		// edit jlabel for title
		l1 = new JLabel("SELECT");
		l1.setSize(100, 50);
		l1.setFont(f);
		l1.setHorizontalAlignment(l1.CENTER);
		l1.setVerticalAlignment(l1.BOTTOM);
		l1.setForeground(Color.white);

		// edit jlabel for title
		l2 = new JLabel("CHARACTER");
		l2.setSize(100, 50);
		l2.setFont(f);
		l2.setHorizontalAlignment(l1.CENTER);
		l2.setVerticalAlignment(l1.TOP);
		l2.setForeground(Color.white);

		// jlabel shows name of character picked
		l3 = new JLabel(" ");
		l3.setSize(100, 50);
		l3.setFont(f);
		l3.setHorizontalAlignment(l3.CENTER);
		l3.setVerticalAlignment(l3.CENTER);
		l3.setForeground(Color.white);

		// add everything to panel
		p3.add(l1);
		p3.add(l2);
		p3.add(l3);
		p3.add(nxt);

		// make panels transparent
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		pmain.setOpaque(false);

		// add all panels to main panel
		pmain.add(p1);
		pmain.add(p3);
		pmain.add(p2);

		// add main panel to jframe
		add(pmain);

	}

	//pre: JButton
	// method takes the button and gets rid of background and border
	public void editButton(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}

	// method checks if an action was performed
	public void actionPerformed(ActionEvent e) {
		// if santa picked set character number to 1 
		if (e.getSource() == char1) {
			l3.setText("Santa Clause");
			characterNumber = 1;
			picked = true;
		}

		// if rudolf picked set character number to 2
		if (e.getSource() == char2) {
			l3.setText("Rudolf");
			characterNumber = 2;
			picked = true;
		}

		// if frosty picked set character number to 3
		if (e.getSource() == char3) {
			l3.setText("Frosty");
			characterNumber = 3;
			picked = true;
		}

		// if elf picked set character number to 4
		if (e.getSource() == char4) {
			l3.setText("Elf");
			characterNumber = 4;
			picked = true;
		}

		// if next button picked and picked variable is true call round1 class
		if (e.getSource() == nxt && picked) {
			// end this class
			dispose();
			try {
				// call round 1 and send character number and mode
				new round1(characterNumber, level);
			} catch (InterruptedException e1) {
 				e1.printStackTrace();
			}
		}

		// if next button pressed and character not selected display error
		if (e.getSource() == nxt && !picked) {
			l3.setText("ERROR");
		}

	}

}
