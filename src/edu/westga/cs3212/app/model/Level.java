package edu.westga.cs3212.app.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.westga.cs3212.app.controller.ControlListener;

/**
 * Sets up the level to be played
 *
 * @author Team 4
 */
public class Level extends JPanel implements Runnable {

	
	/**
	 * Generated serial for warning suppression.
	 */
	private static final long serialVersionUID = 4780054145331265009L;
	
	private static final int CLOUD_SPAWN_FREQUENCY = 500;
	private static final int OBSTACLE_SPAWN_FREQUENCY = 1000;
	
	private Random rand = new Random();
	
	private Plane plane;
	private ArrayList<Ground> ground;
	private ArrayList<Cloud> clouds;
	private ArrayList<Obstacle> obstacles;
	
	private boolean ingame;
	private boolean started = false;
	private int distance;
	private boolean scored;
	private int finalScore;	
	
	private final int PLANE_START_LOCATION_X = 40;
	private final int PLANE_START_LOCATION_Y = 60;
	
	private int LEVEL_WIDTH;
	private int LEVEL_HEIGHT;
	
	private final int DELAY = 10;
		
	private Image cloudImage;
	
	private boolean easyDraw;
	
	private Thread animator;
	
	

	/**
	 * Instantiates a new level, based on the given viewport.
	 */
	public Level() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.LEVEL_HEIGHT = (int) screenSize.getHeight();
		this.LEVEL_WIDTH = (int) screenSize.getWidth();

		this.initLevel();

		ImageIcon ii = new ImageIcon("src/images/cloud.png");
		this.cloudImage = ii.getImage();

	}
	
	/**
	 * Gets the cloud image
	 */
	public Image getImage() {
		return this.cloudImage;
	}


	/**
	 * Gets the height of the level
	 */
	public int getHeight() {
		return this.LEVEL_HEIGHT;
	}

	/**
	 * Gets the width of the level
	 */
	public int getWidth() {
		return this.LEVEL_WIDTH;
	}
	
	/**
	 * Gets the plane in the level
	 */
	public Plane getPlane() {
		return this.plane;
	}
	
	public void setStarted(boolean val) {
		this.started = val;
	}
	
	public void setInGame(boolean val) {
		this.ingame = val;
	}

	/**
	 * Initializes the level.
	 */
	public void initLevel() {
		ControlListener listener = new ControlListener(this);
		this.addKeyListener(listener);
		this.setFocusable(true);
		this.easyDraw = false;
		
		this.ingame = true;
		this.distance = 0;
		this.scored = false;		

		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);
		
		this.setupGround();
		this.setupSky();
		this.setupObstacles();		

		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);		
	}

	private void setupObstacles() {
		this.obstacles = new ArrayList<Obstacle>();
		this.obstacles.add(new Obstacle(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
				rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
	}

	private void setupSky() {
		Color lgtBlue = new Color(41, 151, 255);
		this.setBackground(lgtBlue);
		
		this.clouds = new ArrayList<Cloud>();
		
		for(int i = 0; i < 3; i++) {
			this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		}
	}

	private void setupGround() {
		this.ground = new ArrayList<Ground>();
		this.ground.add(new Ground(0, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
		this.ground.add(new Ground(this.LEVEL_WIDTH, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (this.ingame) {

			this.drawObjects(g);

		} else {

			this.drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Called to Draw the objects on the screen
	 *
	 * @param g
	 *            the graphics
	 */
	private void drawObjects(Graphics g) {
		if(!easyDraw) {
			g.drawImage(this.plane.getImage(), (int) this.plane.getX(), (int) this.plane.getY(), this);
		}else {
			g.setColor(Color.red);
			g.fillOval((int) plane.getX(), (int) plane.getY(), 200, 50);
		}
				
		for (Obstacle obstacle : this.obstacles) {
			if(!easyDraw) {
				g.drawImage(obstacle.getImage(), (int) obstacle.getX(), (int) obstacle.getY(), 80, 100, this);
			}else {
				g.setColor(Color.orange);
				g.fillOval((int) obstacle.getX(), (int) obstacle.getY(), 80, 100);
			}
			
		}

		for (Cloud cloud : this.clouds) {
			if(!easyDraw) {
				g.drawImage(cloudImage, (int) cloud.getX(), (int) cloud.getY(), (190 * cloud.getSpeed()) / 4,
						(110 * cloud.getSpeed()) / 4, this);
			}else {
				g.setColor(Color.white);
				g.fillOval((int) cloud.getX(), (int) cloud.getY(), 190, 110);
			}			
		}

		for (Ground ground : this.ground) {
			if(!easyDraw) {
				g.drawImage(ground.getImage(), (int) ground.getX(), (int) ground.getY(), (int) (this.LEVEL_WIDTH * 1.1), this.LEVEL_HEIGHT / 6, this);
			}			
		}
		drawScore(g);
		drawControls(g);

	}


	private void drawScore(Graphics g) {
		g.setFont(new Font("Helvetica", Font.PLAIN, 25));
		g.setColor(Color.WHITE);
		g.drawString("Distance: " + distance, LEVEL_WIDTH - 250, 20);
	}


	private void drawControls(Graphics g) {
		if (!started) {
			String msg = "Don't Panic: Press Spacebar";
			Font small = new Font("Helvetica", Font.BOLD, 50);
			FontMetrics fm = getFontMetrics(small);
			g.drawString(msg,(this.LEVEL_WIDTH - (fm.stringWidth(msg) / 2)) / 2, this.LEVEL_HEIGHT / 2);
		}
	}

	/**
	 * Called to draw game over.
	 *
	 * @param g
	 *            the graphics
	 */
	private void drawGameOver(Graphics g) {
		this.setBackground(Color.black);
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 50);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2, this.LEVEL_HEIGHT / 2);
		g.drawString("Score: " + finalScore, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2,
				(this.LEVEL_HEIGHT / 2) + 60);
	}   

	/**
	 * Called to update the level for moving objects, and spawning clouds and .
	 */
	private void updateLevel() {
		updateScore();
		updateClouds();
		updateGround();
		updateObstacles();
		updatePlane();

		spawnObstacles();
		spawnClouds();
	}

	private void spawnClouds() {
		if (this.distance % CLOUD_SPAWN_FREQUENCY == 0 && started) {
			this.clouds.add(new Cloud(this.LEVEL_WIDTH    ,
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

		}
	}

	private void spawnObstacles() {
		if (this.distance % OBSTACLE_SPAWN_FREQUENCY == 0 && started) {
			this.obstacles.add(new Obstacle(this.LEVEL_WIDTH,
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

		}
	}

	private void updateScore() {
		if (started) {
			this.distance++;
		}
	}

	private void updateObstacles() {
		for (Obstacle individualObstacle : this.obstacles) {
			individualObstacle.move();
		}
	}

	private void updateClouds() {
		for (Cloud cloud : this.clouds) {
			cloud.move();
		}
	}

	private void updateGround() {
		for (Ground individualGround : this.ground) {
			individualGround.move();
		}
	}

	private void scoreGame() {
		this.finalScore = distance;
	}

	private void updatePlane() {

		if (this.plane.isVisible()) {
			this.plane.move();
		}
	}

	/**
	 * Check collisions for collisions between the plane, the ground, and objects,
	 * to end the game.
	 */
	public void checkCollisions() {

		Rectangle player = this.plane.getBoundaries();

		if (this.plane.getY() + this.plane.getHeight() > this.LEVEL_HEIGHT) {
			endGame();
		}

		for (Obstacle individualObstacle : this.obstacles) {

			Rectangle obstacleBounds = individualObstacle.getBoundaries();

			if (player.intersects(obstacleBounds)) {
				endGame();
			}
		}
	}

	private void endGame() {
		this.ingame = false;
		if (!scored) {
			scoreGame();
			scored = true;
		}
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}
	
	public void setEasyDraw(boolean val) {
		this.easyDraw = val;
	}

	public boolean isIngame() {
		return ingame;
	}

	public boolean isStarted() {
		return started;
	}

	public boolean isEasyDraw() {
		return easyDraw;
	}

	private void cycle() {
		updateScore();
		this.updateLevel();
		this.checkCollisions();
		this.repaint();
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {

			cycle();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}

	}

}