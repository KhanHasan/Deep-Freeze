package Grade12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;

public class round1 extends JPanel implements ActionListener, KeyListener {

	// check if round won
	static boolean win = false;

	// mode number
	int level;

	// pre: int characternumber and int level
	// constructor
	public round1(int characterNumber, int l) throws InterruptedException {
		level = l;
		requestFocus(true);
		// call create method
		create(characterNumber);
		// start timers and threads
		thread1.start();
		tm.start();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	// count ghosts remaining
	static int numberGhosts = 0;

	// check if game running
	static boolean running = true;

	// direction character shoots
	public boolean directionRight = false;
	public boolean directionLeft = false;

	// main character lives
	static int lives = 3;

	// check if character hit
	static boolean santaHit = false;

	// make character fall
	public boolean jumping = false;

	// main character JLabel
	static JLabel char1 = new JLabel();

	// import santa image, resize and set as jlabel
	static ImageIcon c1 = new ImageIcon("santa.png");
	static Image img = c1.getImage();
	static Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic = new ImageIcon(newimg);
	static JLabel santa = new JLabel(pic);

	// import rudolf image, resize and set as jlabel
	static ImageIcon c11 = new ImageIcon("rudolf.png");
	static Image img11 = c11.getImage();
	static Image newimg11 = img11.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic11 = new ImageIcon(newimg11);
	static JLabel rudolf = new JLabel(pic11);

	// import frosty image, resize and set as jlabel
	static ImageIcon c12 = new ImageIcon("frosty.png");
	static Image img12 = c12.getImage();
	static Image newimg12 = img12.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic12 = new ImageIcon(newimg12);
	static JLabel frosty = new JLabel(pic12);

	// import elf image, resize and set as jlabel
	static ImageIcon c13 = new ImageIcon("elf.jpg");
	static Image img13 = c13.getImage();
	static Image newimg13 = img13.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic13 = new ImageIcon(newimg13);
	static JLabel elf = new JLabel(pic13);

	// import ghost image, resize and set as jlabel
	static ImageIcon c2 = new ImageIcon("ghost.png");
	static Image img8 = c2.getImage();
	static Image newimg8 = img8.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic8 = new ImageIcon(newimg8);
	static JLabel char2 = new JLabel(pic8);
	static JLabel char3 = new JLabel(pic8);

	// check if ghosts alive
	static boolean isGhost1Active = true;
	static boolean isGhost2Active = true;
	static boolean isGhost3Active = true;
	static boolean isGhost4Active = true;

	// import ghost image, resize and set as jlabel
	static ImageIcon c3 = new ImageIcon("ghost1.png");
	static Image img9 = c3.getImage();
	static Image newimg9 = img9.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic9 = new ImageIcon(newimg9);
	static JLabel char4 = new JLabel(pic9);
	static JLabel char5 = new JLabel(pic9);

	// import background image, resize and set as jlabel
	static ImageIcon bk1 = new ImageIcon("rnd1background.jpg");
	static Image img1 = bk1.getImage();
	static Image newimg1 = img1.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic1 = new ImageIcon(newimg1);
	static JLabel back1 = new JLabel(pic1);

	// import snowball image, resize and set as jlabel
	static ImageIcon snowball = new ImageIcon("snowball.png");
	static Image img4 = snowball.getImage();
	static Image newimg4 = img4.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic4 = new ImageIcon(newimg4);
	static JLabel sb = new JLabel(pic4);

	// import icicles image, resize and set as jlabel
	static ImageIcon ice = new ImageIcon("ice.png");
	static Image img2 = ice.getImage();
	static Image newimg2 = img2.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic2 = new ImageIcon(newimg2);

	// multiple icicles
	static JLabel ice1 = new JLabel(pic2);
	static JLabel ice2 = new JLabel(pic2);
	static JLabel ice3 = new JLabel(pic2);
	static JLabel ice4 = new JLabel(pic2);

	// import large icicle image, resize and set as jlabel
	static ImageIcon ice5 = new ImageIcon("ice.png");
	static Image img3 = ice5.getImage();
	static Image newimg3 = img3.getScaledInstance(400, 150, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic3 = new ImageIcon(newimg3);
	static JLabel ice6 = new JLabel(pic3);

	// import heart image, resize and set as jlabel
	static ImageIcon h1 = new ImageIcon("heart.png");
	static Image img10 = h1.getImage();
	static Image newimg10 = img10.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic10 = new ImageIcon(newimg10);

	// multiple hearts
	static JLabel heart1 = new JLabel(pic10);
	static JLabel heart2 = new JLabel(pic10);
	static JLabel heart3 = new JLabel(pic10);

	// timer jlable
	static JLabel timeOnScreen;

	// jlabel follows main character
	static JLabel checkHit;

	// timer for character movement
	Timer tm = new Timer(5, this);

	// main character x and y postion
	static int x = 350;
	static int y = 400;

	// main character x and y velocity
	int velX = 0;
	int velY = 0;

	// snowball x and y postion
	static int snowballXValue = x;
	static int snowballYValue = y + 50;

	// time to determine when character hit
	static long startTime;
	static long startTime1;
	static long startTime2;
	static long startTime3;
	static long hitTime;

	// time character can jump for
	public long jumpingTime;

	// how fast snowball moves
	static final int PLAY_TIME = 500;

	// main jframe
	static JFrame jf = new JFrame();

	// time on clock
	static int i = 30;

	// character number
	static int charNumber;

	// check how often to update screen
	private static final int UPDATE_RATE = 30;

	// arrays hold x and y vel of ghosts
	static float[] ghostVelX = { 8, 2, 4, 1 };
	static float[] ghostVelY = { 1, 3, 5, 3 };

	// thread to move ghosts
	static Thread gameThread = new Thread();

	// arrays hold ghosts x and y postion
	static int[] ghostX = { 650, 650, 50, 14 };
	static int[] ghostY = { 40, 240, 40, 160 };

	// ==============================================================================================================

	// timer thread
	Thread thread1 = new Thread() {
		public void run() {
			while (i >= 0) {
				try {
					// stop it for 1 second
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// convert i to string
				String tm1 = Integer.toString(i);
				// set time on screen as string
				timeOnScreen.setText(tm1);
				// if time is done call lost method
				if (i == 0 && running == true) {
					
					lost();
				}
				// decrease time by 1 each time
				i--;

			}
		}
	};

	// pre: character number
	// constructor creates main screen
	public void create(int characterNumber) throws InterruptedException {

		jf.addKeyListener(this);
		jf.setSize(800, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create new font, set timer to that font
		Font f = new Font("Times New Roman", Font.BOLD, 40);
		timeOnScreen = new JLabel("30", SwingConstants.CENTER);
		timeOnScreen.setFont(f);
		Border border = BorderFactory.createLineBorder(Color.RED, 3);
		timeOnScreen.setBorder(border);
		timeOnScreen.setForeground(Color.WHITE);
		timeOnScreen.setBackground(Color.black);

		// set background position
		back1.setBounds(0, 0, 800, 500);

		// set hearts position
		heart1.setBounds(10, 10, 30, 30);
		heart2.setBounds(50, 10, 30, 30);
		heart3.setBounds(90, 10, 30, 30);

		// add hearts
		jf.add(heart1);
		jf.add(heart2);
		jf.add(heart3);

		// determine which number was selected and correspond that to character
		if (characterNumber == 1) {
			char1 = santa;
			charNumber = characterNumber;
		}
		if (characterNumber == 2) {
			char1 = rudolf;
			charNumber = characterNumber;
		}
		if (characterNumber == 3) {
			char1 = frosty;
			charNumber = characterNumber;
		}
		if (characterNumber == 4) {
			char1 = elf;
			charNumber = characterNumber;
		}

		// set x and y velocities of ghosts based on level selected
		// easy level
		if (level == 1) {
			for (int i = 0; i < 4; i++) {
				int xrandom = (int) (Math.random() * (3) + 1);
				int yrandom = (int) (Math.random() * (3) + 1);
				ghostVelX[i] = xrandom;
				ghostVelY[i] = yrandom;
			}
		}

		// set x and y velocities of ghosts based on level selected
		// medium level
		if (level == 2) {
			for (int i = 0; i < 4; i++) {
				int xrandom = (int) (Math.random() * (3) + 3);
				int yrandom = (int) (Math.random() * (3) + 3);
				ghostVelX[i] = xrandom;
				ghostVelY[i] = yrandom;
			}
		}

		// set x and y velocities of ghosts based on level selected
		// hard level
		if (level == 3) {
			for (int i = 0; i < 4; i++) {
				int xrandom = (int) (Math.random() * (3) + 6);
				int yrandom = (int) (Math.random() * (3) + 6);
				ghostVelX[i] = xrandom;
				ghostVelY[i] = yrandom;
			}
		}

		// smaller jlabel for intersection
		checkHit = new JLabel();
		checkHit.setSize(20, 50);
		checkHit.setBounds(x + 40, y + 10, 20, 50);
		checkHit.setForeground(Color.RED);

		// set main character position
		char1.setBounds(x, y, 100, 100);

		// set ghost positons
		char2.setBounds(650, 40, 80, 100);
		char3.setBounds(650, 240, 80, 100);
		char4.setBounds(50, 40, 80, 100);
		char5.setBounds(140, 160, 80, 100);

		// set timer position
		timeOnScreen.setBounds(375, 5, 50, 50);

		// add timmer
		jf.add(timeOnScreen);

		// set icicles position
		// add icicles
		ice1.setBounds(0, 80, 200, 150);
		jf.add(ice1);
		ice2.setBounds(600, 80, 200, 150);
		jf.add(ice2);
		ice3.setBounds(330, 160, 200, 150);
		jf.add(ice3);
		ice4.setBounds(100, 200, 200, 150);
		jf.add(ice4);
		ice6.setBounds(400, 280, 400, 150);
		jf.add(ice6);

		sb.setVisible(false);

		// add ghosts, checkHit, snowball and background
		jf.add(checkHit);
		jf.add(char1);
		jf.add(char2);
		jf.add(char3);
		jf.add(char4);
		jf.add(char5);
		jf.add(sb);
		jf.add(back1);
		jf.setLocationRelativeTo(null);  
		jf.setVisible(true);

		// call move forward method
		moveGhostforward();
	}

	// method randomly moves ghosts on screen
	public void moveGhostforward() throws InterruptedException {
		// start thread
		gameThread = new Thread() {
			public void run() {
				while (true) {
					/// change ghosts x and y positions based on x and y velocity
					ghostX[0] += ghostVelX[0];
					ghostY[0] += ghostVelY[0];

					ghostX[1] += ghostVelX[1];
					ghostY[1] += ghostVelY[1];

					ghostX[2] += ghostVelX[2];
					ghostY[2] += ghostVelY[2];

					ghostX[3] += ghostVelX[3];
					ghostY[3] += ghostVelY[3];

					// check if ghosts are near border
					ghostVelX[0] = checkifBorder(ghostX[0], ghostY[0], ghostVelX[0]);
					ghostVelY[0] = checkifBorder1(ghostX[0], ghostY[0], ghostVelY[0]);

					ghostVelX[1] = checkifBorder(ghostX[1], ghostY[1], ghostVelX[1]);
					ghostVelY[1] = checkifBorder1(ghostX[1], ghostY[1], ghostVelY[1]);

					ghostVelX[2] = checkifBorder(ghostX[2], ghostY[2], ghostVelX[2]);
					ghostVelY[2] = checkifBorder1(ghostX[2], ghostY[2], ghostVelY[2]);

					ghostVelX[3] = checkifBorder(ghostX[3], ghostY[3], ghostVelX[3]);
					ghostVelY[3] = checkifBorder1(ghostX[3], ghostY[3], ghostVelY[3]);

					// set ghosts new postions
					char2.setBounds(ghostX[0], ghostY[0], 100, 100);
					char3.setBounds(ghostX[1], ghostY[1], 100, 100);
					char4.setBounds(ghostX[2], ghostY[2], 100, 100);
					char5.setBounds(ghostX[3], ghostY[3], 100, 100);

					// call methods to see if anything happened
					checkifShot();
					checkifSantahit();
					checkifDone();

					try {
						// delay movement by very smal numbers
						Thread.sleep(700 / UPDATE_RATE);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		// restart threads
		gameThread.start();

	}

	// pre: int ghostX, int ghostY, float gVelX
	// method makes ghosts bounce off of border
	// post: returns x velocity
	public float checkifBorder(int ghostX, int ghostY, float gVelX) {
		if (ghostX < 0) {
			gVelX = -gVelX;
			ghostX = 0;
		} else if (ghostX > 700) {
			gVelX = -gVelX;
			ghostX = 700;
		}

		return gVelX;
	}

	// pre: int ghostX, int ghostY, float gVelY
	// method makes ghosts bounce off of border
	// post: returns y velocity
	public float checkifBorder1(int ghostX, int ghostY, float gVelY) {
		if (ghostY < 0) {
			gVelY = -gVelY;
			ghostY = 0;
		} else if (ghostY > 400) {
			gVelY = -gVelY;
			ghostY = 400;
		}

		return gVelY;

	}

	// check if all ghosts are dead
	public void checkifDone() {
		if (numberGhosts == 4 && running == true) {
			// pause threads
			Thread.yield();
			// delete class
			jf.dispose();
			running = false;

			try {	
				// call new round and send character number
				new finalRound(charNumber);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	// check if snowball hits enemies
	public static void checkifShot() {
		// if snowball intersects ghosts, remove ghosts and add 1 to number ghosts
		if (isGhost1Active && sb.getBounds().intersects(char2.getBounds())) {
			isGhost1Active = false;
			jf.remove(char2);
			numberGhosts++;
		}
		// if snowball intersects ghosts, remove ghosts and add 1 to number ghosts
		if (isGhost2Active && sb.getBounds().intersects(char3.getBounds())) {
			isGhost2Active = false;
			jf.remove(char3);
			numberGhosts++;
		}
		// if snowball intersects ghosts, remove ghosts and add 1 to number ghosts
		if (isGhost3Active && sb.getBounds().intersects(char4.getBounds())) {
			isGhost3Active = false;
			jf.remove(char4);
			numberGhosts++;
		}
		// if snowball intersects ghosts, remove ghosts and add 1 to number ghosts
		if (isGhost4Active && sb.getBounds().intersects(char5.getBounds())) {
			isGhost4Active = false;
			jf.remove(char5);
			numberGhosts++;
		}
	}

	// check if santa bumps into enemies
	public static void checkifSantahit() {
		// if main character bumps into ghost, set santaHit to true
		if (isGhost1Active && checkHit.getBounds().intersects(char2.getBounds())) {
			santaHit = true;
		}
		// if main character bumps into ghost, set santaHit to true
		if (isGhost2Active && checkHit.getBounds().intersects(char3.getBounds())) {
			santaHit = true;
		}
		// if main character bumps into ghost, set santaHit to true
		if (isGhost3Active && checkHit.getBounds().intersects(char4.getBounds())) {
			santaHit = true;
		}
		// if main character bumps into ghost, set santaHit to true
		if (isGhost4Active && checkHit.getBounds().intersects(char5.getBounds())) {
			santaHit = true;
		}

		// if hit get rid of 1 life, make 1 heart not visible and prevent being touched
		// for 2 seconds
		if (santaHit == true) {
			if (lives == 3) {
				heart3.setVisible(false);
				santaHit = false;
				startTime2 = System.currentTimeMillis();
				lives--;
			}
			// if hit get rid of 1 life, make 1 heart not visible and prevent being touched
			// for 2 seconds
			if (lives == 2 && System.currentTimeMillis() > startTime2 + 2000) {
				heart2.setVisible(false);
				santaHit = false;
				startTime3 = System.currentTimeMillis();
				lives--;
			}
			// if hit get rid of 1 life, make 1 heart not visible call lost method
			if (lives == 1 && System.currentTimeMillis() > startTime3 + 2000 && running == true) {
				heart1.setVisible(false);
				// remove everything in class
				jf.removeAll();
				lost();
				running = false;
			}
			santaHit = false;

		}
	}

	public static void lost() {
		// pause thread
		Thread.yield();
		// delete class
		jf.dispose();
		// call game over
		new gameOver(win);

	}

	// shoot snowball
	public void shootSnowball() {
		// set snowball postion
		sb.setBounds(snowballXValue, snowballYValue, 40, 40);

		// start timer for snowball
		Timer timer = new Timer(40, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get x and y of snowball
				int currentSnowballX = sb.getX();
				int currentSnowballY = sb.getY();
				
				// determine how long it should move for
				long duration = System.currentTimeMillis() - startTime;

				// check how far its gotten
				float progress = (float) duration / (float) PLAY_TIME;
				if (progress > 1f) {
					progress = 1f;
					// once position reached end it
					((Timer) (e.getSource())).stop();
				}
				

				// if character shoots right add too x position
				if (directionRight == true && directionLeft == false) {
					sb.setVisible(true);
					currentSnowballX = x + (int) Math.round((760 - x) * progress);
					currentSnowballY = y + 20;
					sb.setLocation(currentSnowballX, currentSnowballY);
				}
				// if character shoots left subtract from x position
				if (directionRight == false && directionLeft == true) {
					sb.setVisible(true);
					currentSnowballX = x - (int) Math.round((0 + x) * progress);
					currentSnowballY = y + 20;
					sb.setLocation(currentSnowballX, currentSnowballY);
				}
				
				// once its too far get rid of snowball
				if (currentSnowballX > x + 150) {
					sb.setVisible(false);
					sb.setBounds(0, 0, 0, 0);
				}
				// once its too far get rid of snowball
				if (currentSnowballX < x - 150) {
					sb.setVisible(false);
					sb.setBounds(0, 0, 0, 0);
				}
				// once off screen get rid of snowball
				if (currentSnowballX > 750) {
					sb.setVisible(false);
				}
				// once off screen get rid of snowball
				if (currentSnowballX < 20) {
					sb.setVisible(false);
				}
			}
		});
		// restart timer
		startTime = System.currentTimeMillis();
		timer.start();
	}

	// key listener determine which key pressed
	public void keyPressed(KeyEvent e) {
		// set x velocity to negative
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			velX += -4;
			velY = 0;
		}

		// set x velocity to positive
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			velX += 4;
			velY = 0;
		}
 
		// call shootSnowball if space pressed
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			shootSnowball();
		}
		// get current time and set jumping to true if up is pressed
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			jumpingTime = System.currentTimeMillis();
			jumping = true;
		}
	}

	// once key is released
	public void keyReleased(KeyEvent e) {
		// character stops moving
		velX = 0;
		velY = 0;

		// character going to shoot left
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			directionRight = false;
			directionLeft = true;
		}
		// character going to shoot right
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			directionRight = true;
			directionLeft = false;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	// action listener
	public void actionPerformed(ActionEvent e) {

		// prevent character from going off of left of screen
		if (x < -1) {
			velX = 0;
			x = 0;
		}
		// prevent character from going off of right of screen
		if (x > 690) {
			velX = 0;
			x = 690;
		}

		// prevent character from going off of top of screen
		if (y < 0) {
			velY = 0;
			y = 0;
		}

		// prevent character from going off of bottom of screen
		if (y > 360) {
			velY = 0;
			y = 360;
		}

		// allow character to stand on icicles
		if (y > 240 && y < 260 && x > 350) {
			velY = 0;
			y = 240;
		}

		// allow character to stand on icicles
		if (y > 160 && y < 180 && x > 50 && x < 250) {
			velY = 0;
			y = 160;
		}

		// allow character to stand on icicles
		if (y > 120 && y < 140 && x > 280 && x < 490) {
			velY = 0;
			y = 120;
		}
		
		// allow character to stand on icicles
		if (y > 40 && y < 60 && x < 180) {
			velY = 0;
			y = 40;
	 	}
		
		// allow character to stand on icicles
		if (y > 40 && y < 60 && x > 540) {
			velY = 0;
			y = 40;
		}
		
		
		if (jumping) {
			// move character up for 0.1 seconds
			velY--;
			if ((System.currentTimeMillis() - jumpingTime) > 100) {
				jumping = false;
			}
		}
		if (!jumping) {
			// make character fall down
			velY = velY + 5;
		}

		// add x velocity to x position and y velocity to y position
		x = x +   velX;
		y = y + velY;
		// set character bounds and checkHit bounds
		char1.setBounds(x, y, 100, 100);
		checkHit.setBounds(x + 40, y + 10, 20, 50);
	}

}
