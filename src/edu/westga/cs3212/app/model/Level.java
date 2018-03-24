package edu.westga.cs3212.app.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

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
	//private Timer timer;
	private Plane plane;
	private ArrayList<Ground> ground;
	private ArrayList<Cloud> clouds;
	private ArrayList<Obstacle> obstacles;
	private boolean ingame;
	private boolean started = false;
	private final int PLANE_START_LOCATION_X = 40;
	private final int PLANE_START_LOCATION_Y = 60;
	private int LEVEL_WIDTH;
	private int LEVEL_HEIGHT;
	private final int DELAY = 10;
	private int distance;
	private Image image;
	private Image imageGrass;
	private Thread animator;
	private int finalScore;
	private boolean scored;

	/**
	 * Instantiates a new level, based on the given viewport.
	 */
	public Level() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.LEVEL_HEIGHT = (int) screenSize.getHeight();
		this.LEVEL_WIDTH = (int) screenSize.getWidth();

		this.initLevel();

		ImageIcon ii = new ImageIcon("src/images/cloud.png");
		this.image = ii.getImage();

		ImageIcon iii = new ImageIcon("src/images/grass.png");
		this.imageGrass = iii.getImage();

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
	 * Initializes the level.
	 */
	private void initLevel() {

		this.scored = false;
		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.ingame = true;
		this.distance = 0;
		this.clouds = new ArrayList<Cloud>();
		this.ground = new ArrayList<Ground>();
		this.obstacles = new ArrayList<Obstacle>();

		this.setPreferredSize(new Dimension(this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);

		this.ground.add(new Ground(0, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
		this.ground.add(new Ground(this.LEVEL_WIDTH, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));

		Random rand = new Random();

		this.obstacles.add(new Obstacle(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
				rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);

		this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
				rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
				rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
				rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
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

		Color lgtBlue = new Color(41, 151, 255);
		g.setColor(lgtBlue);
		g.fillRect(0, 0, LEVEL_WIDTH, LEVEL_HEIGHT);
		if (this.plane.isVisible()) {
			g.drawImage(this.plane.getImage(), this.plane.getX(), this.plane.getY(), this);
		}

		for (Obstacle obstacle : this.obstacles) {
			g.drawImage(obstacle.getImage(), obstacle.getX(), obstacle.getY(), 80, 100, this);
		}

		for (Cloud cloud : this.clouds) {

			g.drawImage(cloud.getImage(), cloud.getX(), cloud.getY(), (190 * cloud.getSpeed()) / 4,
					(110 * cloud.getSpeed()) / 4, this);
		}

		for (Ground ground : this.ground) {
			g.drawImage(ground.getImage(), ground.getX(), ground.getY(), (int) (this.LEVEL_WIDTH * 1.1), 150, this);
		}
		g.setFont(new Font("Helvetica", Font.PLAIN, 25));

		g.setColor(Color.WHITE);

		g.drawString("Distance: " + distance, LEVEL_WIDTH - 250, 20);
		if (!started) {
			g.drawString("Don't Panic: Press Spacebar", 500, 200);
		}

	}

	/**
	 * Called to draw game over.
	 *
	 * @param g
	 *            the graphics
	 */
	private void drawGameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 50);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2, this.LEVEL_HEIGHT / 2);
		g.drawString("Score: " + finalScore, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2, (this.LEVEL_HEIGHT / 2) + 60);
	}

	/**
	 * Called to update the level for moving objects, and spawning clouds and .
	 */
	private void updateLevel() {
		if (started) {
			this.distance++;
		}

		updateClouds();
		updateGround();

		for (Obstacle individualObstacle : this.obstacles) {
			individualObstacle.move();
		}

		Random rand = new Random();

		if (this.distance % 1000 == 0 && started) {
			this.obstacles.add(new Obstacle(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

		}

		if (this.distance % 500 == 0 && started) {
			this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

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

	private void inGame() {

		if (!this.ingame) {
			//this.timer.stop();
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
			this.plane.setVisible(false);
			this.ingame = false;
			if(!scored) {
				scoreGame();
				scored = true;
			}
		}

		for (Obstacle individualObstacle : this.obstacles) {

			Rectangle obstacleBounds = individualObstacle.getBoundaries();

			if (player.intersects(obstacleBounds)) {
				this.plane.setVisible(false);
				this.ingame = false;
				if(!scored) {
					scoreGame();
					scored = true;
				}
			}
		}
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			plane.keyReleased(e);
		}

		
		
		@Override
		public void keyPressed(KeyEvent e) {
			plane.keyPressed(e);
			started = true;
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_R) {
				started = false;
				ingame = true;
				initLevel();
				
			}
		}
	}

	private void cycle() {
		if (started) {
			this.distance++;
		}
		this.inGame();
		this.updateLevel();

		this.updatePlane();
		this.checkCollisions();
		this.repaint();
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {

			cycle();
		    repaint();

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