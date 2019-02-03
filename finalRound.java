package Grade12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class finalRound extends JPanel implements ActionListener, KeyListener {

	// creates timer for character movement, constantly checks actionlistener
	Timer tm = new Timer(5, this);
	
	// main frame
	static JFrame jf = new JFrame();
	
	// determine if character pressed up
	public boolean jumping = false;
	
	// check if character wom
	public static boolean win = true;
	
	// how long character can jump for
	public long jumpingTime; 
	
	// pre: character number
	// constructor method calls every other method
	public finalRound(int charNum) throws InterruptedException {
		// requests focus of key board as key listener won't always work
		requestFocus(true);
		tm.start();
		
		// create method creates whole screen
		create(charNum);
		
		setFocusable(true);
		//disable all extra keys
		setFocusTraversalKeysEnabled(false);
	}

	// character 1 jlabel
	JLabel char1 = new JLabel();

	// imports and resizes santa image, sets it as jlabel
	static ImageIcon c1 = new ImageIcon("santa.png");
	static Image img = c1.getImage();
	static Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic = new ImageIcon(newimg);
	static JLabel santa = new JLabel(pic);

	// imports and resizes coal image, sets it as jlabel
	static ImageIcon Coal = new ImageIcon("coal.png");
	static Image img14 = Coal.getImage();
	static Image newimg14 = img14.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic14 = new ImageIcon(newimg14);
	// multiple pieces of coal
	static JLabel coal1 = new JLabel(pic14);
	static JLabel coal2 = new JLabel(pic14);
	static JLabel coal3 = new JLabel(pic14);
	static JLabel coal4 = new JLabel(pic14);
	
	// imports and resizes rudolf image, sets it as jlabel
	static ImageIcon c11 = new ImageIcon("rudolf.png");
	static Image img11 = c11.getImage();
	static Image newimg11 = img11.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic11 = new ImageIcon(newimg11);
	static JLabel rudolf = new JLabel(pic11);

	// imports and resizes santa frosty, sets it as jlabel
	static ImageIcon c12 = new ImageIcon("frosty.png");
	static Image img12 = c12.getImage();
	static Image newimg12 = img12.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic12 = new ImageIcon(newimg12);
	static JLabel frosty = new JLabel(pic12);

	// imports and resizes elf image, sets it as jlabel
	static ImageIcon c13 = new ImageIcon("elf.jpg");
	static Image img13 = c13.getImage();
	static Image newimg13 = img13.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic13 = new ImageIcon(newimg13);
	static JLabel elf = new JLabel(pic13);

	// imports and resizes background image, sets it as jlabel
	static ImageIcon bk1 = new ImageIcon("rnd2background.jpg");
	static Image img1 = bk1.getImage();
	static Image newimg1 = img1.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic1 = new ImageIcon(newimg1);
	static JLabel backGround = new JLabel(pic1);

	// imports and resizes icicles image, sets it as jlabel
	static ImageIcon ice = new ImageIcon("ice.png");
	static Image img2 = ice.getImage();
	static Image newimg2 = img2.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic2 = new ImageIcon(newimg2);
	// multiple icicles
	static JLabel ice1 = new JLabel(pic2);
	static JLabel ice2 = new JLabel(pic2);

	// imports and resizes larger icicles image, sets it as jlabel
	static ImageIcon ic = new ImageIcon("ice.png");
	static Image img3 = ic.getImage();
	static Image newimg3 = img3.getScaledInstance(400, 150, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic3 = new ImageIcon(newimg3);
	static JLabel ice3 = new JLabel(pic3);

	// imports and resizes lights image, sets it as jlabel
	static ImageIcon lights = new ImageIcon("lights.png");
	static Image img4 = lights.getImage();
	static Image newimg4 = img4.getScaledInstance(200, 42, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic4 = new ImageIcon(newimg4);
	// multiple lights
	static JLabel light1 = new JLabel(pic4);
	static JLabel light2 = new JLabel(pic4);

	// imports and resizes larger lights image, sets it as jlabel
	static ImageIcon lights2 = new ImageIcon("lights.png");
	static Image img5 = lights2.getImage();
	static Image newimg5 = img5.getScaledInstance(400, 84, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic5 = new ImageIcon(newimg5);
	static JLabel light3 = new JLabel(pic5);

	// imports and resizes snowball image, sets it as jlabel
	static ImageIcon snowball = new ImageIcon("snowball.png");
	static Image img6 = snowball.getImage();
	static Image newimg6 = img6.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic6 = new ImageIcon(newimg6);
	static JLabel sb = new JLabel(pic6);

	// imports and resizes grinch image, sets it as jlabel
	static ImageIcon c2 = new ImageIcon("grinchFinalrnd.png");
	static Image img7 = c2.getImage();
	static Image newimg7 = img7.getScaledInstance(78, 205, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic7 = new ImageIcon(newimg7);
	static JLabel grinch = new JLabel(pic7);

	// main character x and y coordinates
	static int x = 350;
	static int y = 365;
	
	// grinch x,y coordinates
	static int grinchX = 100;
	static int grinchY = 260;
	
	// grinch x,y velocities
	static int grinchVelX = 6;
	static int grinchVelY = 0;
	
	// how often to update grinch pic
	private static final int UPDATE_RATE = 30;

	// snowball x,y values
	static int snowballXValue = x;
	static int snowballYValue = y + 50;
	
	// time once game is started
	static long startTime;
	
	// time for snowball speed
	static final int PLAY_TIME = 500;
	
	// determine direction of snowball shot
	public boolean directionRight = false;
	public boolean directionLeft = false;

	// imports and resizes heart image, sets it as jlabel
	static ImageIcon heart = new ImageIcon("heart.png");
	static Image img8 = heart.getImage();
	static Image newimg8 = img8.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon pic8 = new ImageIcon(newimg8);
	// multiple lives
	static JLabel heart1 = new JLabel(pic8);
	static JLabel heart2 = new JLabel(pic8);
	static JLabel heart3 = new JLabel(pic8);

	// imports and resizes grinch heart image, sets it as jlabel
	static ImageIcon heartg = new ImageIcon("grinchlive.png");
	static Image img9 = heartg.getImage();
	static Image newimg9 = img9.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);     
	static ImageIcon pic9 = new ImageIcon(newimg9);
	//multiple lives
	static JLabel heart4 = new JLabel(pic9);
	static JLabel heart5 = new JLabel(pic9);
	static JLabel heart6 = new JLabel(pic9);

	// check if character hit
	static boolean santaHit = false;
	
	// check if grinch is alive
	static boolean isGrinchActive = true;
	
	// count characters lives
	static int lives = 3;
	
	// count grinc's lives
	static int grinchLives = 3;
	
	// thread used for moving the grinch simultaneously
	static Thread gameThread = new Thread();

	// start times needed to determine when character is hit
	static long startTime2;
	static long startTime3;
	static long startTime4;
	static long startTime5;
	
	// boolean checks if game is still going
	static boolean running = true;
	
	// coal initial y positions
	static int coalY = -40;

	// x postions for coal in array
	int [] coalX = {0,0,0,0};
	
	// check if grinch hit
	static boolean grinchHit = false;
	
	// jlabel under main character to check if the collide
	static JLabel checkHit;
	
	// x and y velocity of main character
	static int velX = 0, velY = 0;

	

	
	// pre: character number
	// method sets up main screen and runs game
	public void create(int charNum) throws InterruptedException {
		jf.setLayout(null);
		jf.addKeyListener(this);
		jf.setSize(800, 500);
 		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.setBounds(0, 0, 800, 500);

		// set jlabel char1 which is main character to santa if character number is 1
		if (charNum == 1) {
			char1 = santa;
		}
		
		// set jlabel char1 which is main character to rudolf if character number is 1
		if (charNum == 2) {
			char1 = rudolf;
		}
		
		// set jlabel char1 which is main character to frosty if character number is 1
		if (charNum == 3) {
			char1 = frosty;
		}
		
		// set jlabel char1 which is main character to elf if character number is 1
		if (charNum == 4) {
			char1 = elf;
		}
		
		//set main character in center
		char1.setBounds(x, y, 100, 100);
		
		// set grinch postion
		grinch.setBounds(grinchX, grinchY, 78, 205);

		// run for loop to set random x postions for coal
		for(int i =0; i<4; i++) {
			int coalXVal = (int)(Math.random()*(721)+0); 
			coalX[i] = coalXVal;
		}
		
 		//set coal postions
		coal1.setBounds(coalX[0],coalY,40,40);
		coal2.setBounds(coalX[1],coalY,40,40);
		coal3.setBounds(coalX[2],coalY,40,40);
		coal4.setBounds(coalX[3],coalY,40,40);

		// set heart postion
		heart1.setBounds(10, 10, 30, 30);
		heart2.setBounds(50, 10, 30, 30);
		heart3.setBounds(90, 10, 30, 30);

		// add hearts
		jf.add(heart1);
		jf.add(heart2);
		jf.add(heart3);

		// set heart postion
		heart4.setBounds(660, 10, 30, 30);
		heart5.setBounds(700, 10, 30, 30);
		heart6.setBounds(740, 10, 30, 30);
		
		// add checkHit JLabel under santa, make it smaller
		checkHit = new JLabel();
 		checkHit.setSize(20,50);
		checkHit.setBounds(x+25,y,20,50);
 		
		// add hearts
		jf.add(heart4);
		jf.add(heart5);
		jf.add(heart6);

		// add coal
		jf.add(coal1);
		jf.add(coal2);
		jf.add(coal3);
		jf.add(coal4);

		// add main character
		jf.add(char1);
		// add grinch
		jf.add(grinch);
		sb.setVisible(false);
		// add snowball
		jf.add(sb);

		// set icicles postion
		ice1.setBounds(0, 260, 200, 150);
		ice2.setBounds(200, 200, 200, 150);
		ice3.setBounds(400, 280, 400, 150);

		// add icicles
		jf.add(ice1);
		jf.add(ice2);
		jf.add(ice3);
		
		//add checkHit JLabel
		jf.add(checkHit);
		
		// set light postion
		light1.setBounds(0, 245, 200, 150);
		light2.setBounds(200, 185, 200, 150);
		light3.setBounds(415, 265, 400, 150);

		// add light
		jf.add(light1);
		jf.add(light2);
		jf.add(light3);

		// add background
		jf.add(backGround);
		jf.setLocationRelativeTo(null);  
		jf.setVisible(true);
		
		// call movegrinch method
 		moveGrinch();
	}

	// method moves grinch simultaneusly as game runs
	public void moveGrinch() throws InterruptedException {
		// start new thread
		gameThread = new Thread() {
			public void run() {
				while (true) {
					// add x and y vel to x and y coordinates
					grinchX += grinchVelX;
					grinchY += grinchVelY;
					// move coal 5 down each time
					coalY += 5;
					
					// call checkifborder to check if grinch needs to turn
					grinchVelX = checkifBorder(grinchX, grinchY, grinchVelX);
					
					
					// set grinches new position
					grinch.setBounds(grinchX, grinchY, 78, 205);

					// set coal new postion
					coal1.setBounds(coalX[0],coalY,40,40);
					coal2.setBounds(coalX[1],coalY,40,40);
					coal3.setBounds(coalX[2],coalY,40,40);
					coal4.setBounds(coalX[3],coalY,40,40);

					// call check if santa hit method
					checkifSantahit();
					
					// call check if grinch shot method
					checkifShot();

					try {
						// stop thread for milliseconds
						Thread.sleep(700 / UPDATE_RATE);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		// start thread all over again
		gameThread.start();
	}

	// pre: int grinch X and Y coordinates and X velocity
	// method determines if grinch is within coordinates if not it flips certain velocities
	// post: int velX
	public int checkifBorder(int grinchX1, int grinchY1, int gVelX) {
		// if grinch on left move it opposite direction
		if (grinchX1 < 0) {
			gVelX = -gVelX;
			grinchX1 = 0;
		} 
		// if grinch on right of screen move it opposite direction
		else if (grinchX1 > 700) {
			gVelX = -gVelX;
			grinchX1 = 700;
		}
		// return new x velocity
		return gVelX;
	}

	// check if key pressed
	public void keyPressed(KeyEvent e) {

		// if left key pressed
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			velX += -4;
			velY = 0;
		}

		// if right key pressed
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			velX += 4;
			velY = 0;
		}

		// if space key pressed
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// call method
			shootSnowball();
		}

		// if up key pressed
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// takes current time
			jumpingTime = System.currentTimeMillis();
			// sets jumping boolean to true
			jumping = true;
		}

	}

	// once key is released
	public void keyReleased(KeyEvent e) {
		// player stops moving
		velX = 0;
		velY = 0;
		
		// snowball will shoot left
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			directionRight = false;
			directionLeft = true;
		}
		
		// snowball will shoot right
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
		
		// make player stand on icicles
		if (y > 240 && y < 260 && x > 350) {
			velY = 0;
			y = 240;
		}
		
		// make player stand on icicles
		if (y > 160 && y < 180 && x > 150 && x < 350) {
			velY = 0;
			y = 160;
		}

		// make player stand on icicles
		if (y > 215 && y < 235 && x > -20 && x < 150) {
			velY = 0;
			y = 215;
		}
		
		// bring coal back to top once it leaves
		if(coalY > 450) {
			coalY = -40;
			for(int i =0; i<4; i++) {
				int coalXVal = (int)(Math.random()*(721)+0); 
				coalX[i] = coalXVal;
			}
		}

		// if jumping is true
		if (jumping) {
			// push character up for 0.1 seconds
			velY--;
			if ((System.currentTimeMillis() - jumpingTime) > 100) {
				// set jumping to false
				jumping = false;
			}
		}
		
		// if jumping is false
		if (!jumping) {
			// keep pushing character down
			velY = velY + 5;
		}
 
		// add xvelocity to character x and yvelocity to character y
		x = x + velX;
		y = y + velY;
		
		// reset main character bounds
		char1.setBounds(x, y, 100, 100);
		
		// resent checkHit bounds
		checkHit.setBounds(x+40,y+10, 20,50);

	}

	
	// method shoots snowball
	public void shootSnowball() {
		
		// set snow ball postion
		sb.setBounds(snowballXValue, snowballYValue, 40, 40);

		// create timer for snowball
		Timer timer = new Timer(40, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get snowball x and y position
				int currentSnowballX = sb.getX();
				int currentSnowballY = sb.getY();
				
				//shoot snowball for period of time
				long duration = System.currentTimeMillis() - startTime;

				// check hpw far it got
				float progress = (float) duration / (float) PLAY_TIME;
				// if snowball gets further than distance end it
				if (progress > 1f) {
					progress = 1f;
					((Timer) (e.getSource())).stop();
				}

				// if snowball shot right
				if (directionRight == true && directionLeft == false) {
					sb.setVisible(true);
					// add to x postion
					currentSnowballX = x + (int) Math.round((760 - x) * progress);
					currentSnowballY = y + 20;
					sb.setLocation(currentSnowballX, currentSnowballY);
				}
				
				// if snowball shot left
				if (directionRight == false && directionLeft == true) {
					sb.setVisible(true);
					// take away from x postion
					currentSnowballX = x - (int) Math.round((0 + x) * progress);
					currentSnowballY = y + 20;
					sb.setLocation(currentSnowballX, currentSnowballY);
				}

				// once it gets far on right get rid of it
				if (currentSnowballX > x + 150) {
					sb.setVisible(false);
					sb.setBounds(0, 0, 0, 0);
				}

				// once it gets far on left get rid of it
				if (currentSnowballX < x - 150) {
					sb.setVisible(false);
					sb.setBounds(0, 0, 0, 0);
				}

				// once it gets far on right get rid of it
				if (currentSnowballX > 750) {
					sb.setVisible(false);
				}
				
				// once it gets far on left get rid of it
				if (currentSnowballX < 20) {
					sb.setVisible(false);
				}
			}
		});
		// get current time
		startTime = System.currentTimeMillis();
		// restart entire process
		timer.start();
	}

	// check if character is hit
	public void checkifSantahit() {
		
		// if grinch and character intersect
		if (isGrinchActive && checkHit.getBounds().intersects(grinch.getBounds())) {
			santaHit = true;
		}
		// if coal and character intersect
		if ( checkHit.getBounds().intersects(coal1.getBounds())) {
			santaHit = true;
		}
		// if coal and character intersect
		if ( checkHit.getBounds().intersects(coal2.getBounds())) {
			santaHit = true;
		}
		// if coal and character intersect
		if ( checkHit.getBounds().intersects(coal3.getBounds())) {
			santaHit = true;
		}
		// if coal and character intersect
		if ( checkHit.getBounds().intersects(coal4.getBounds())) {
			santaHit = true;
		}

		// once character is hit
		if (santaHit == true) {
			// get rid of one life and prevent being hit for 2 seconds
			if (lives == 3) {
				heart3.setVisible(false);
				santaHit = false;
				startTime2 = System.currentTimeMillis();
				lives--;
			}
			// get rid of one life and prevent being hit for 2 seconds
			if (lives == 2 && System.currentTimeMillis() > startTime2 + 2000) {
				heart2.setVisible(false);
				santaHit = false;
				startTime3 = System.currentTimeMillis();
				lives--;
			}
			// get rid of one life and call lost method
			if (lives == 1 && System.currentTimeMillis() > startTime3 + 2000 && running == true) {
				heart1.setVisible(false);
				lost(!win);
				// prevent if statement from calling itself again
				running = false;
			}
			santaHit = false;

		}
	}

	// check if grinch hit
	public static void checkifShot() {
		
		// if snowball and grinch intersect
		if (isGrinchActive && sb.getBounds().intersects(grinch.getBounds())) {
			grinchHit = true;
		}
		
		// get rid of one life and prevent being hit for 1 second
		if (grinchHit == true) {
			if (grinchLives == 3) {
				heart4.setVisible(false);
				grinchHit = false;
				startTime4 = System.currentTimeMillis();
				grinchLives--;
			}
			// get rid of one life and prevent being hit for 1 second
			if (grinchLives == 2 && System.currentTimeMillis() > startTime4 + 1000) {
				heart5.setVisible(false);
				grinchHit = false;
				startTime5 = System.currentTimeMillis();
				grinchLives--;
			}
			// get rid of one life and call lost method
			if (grinchLives == 1 && System.currentTimeMillis() > startTime5 + 1000 && running == true) {
				heart6.setVisible(false);
				lost(win);
				// prevent if statement from recalling itself
				running = false;
			}
			grinchHit = false;

		}

	}

	// pre: boolean win determines of won or lost
	public static void lost(boolean win) {
		// stops all threads
		Thread.yield();
		// end jframe
		jf.dispose();
		// call game over class
		new gameOver(win);

	}

}
