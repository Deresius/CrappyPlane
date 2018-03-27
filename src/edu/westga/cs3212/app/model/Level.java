package edu.westga.cs3212.app.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
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

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Painter painter = new Painter(this);

		if (isIngame()) {

			painter.drawObjects(g);

		} else {

			painter.drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
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

		for (int i = 0; i < 3; i++) {
			this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		}
	}

	private void setupGround() {
		this.ground = new ArrayList<Ground>();
		this.ground.add(new Ground(0, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
		this.ground.add(new Ground(this.LEVEL_WIDTH, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
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
			this.clouds.add(new Cloud(this.LEVEL_WIDTH, (int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH,
					this.LEVEL_HEIGHT));

		}
	}

	private void spawnObstacles() {
		if (this.distance % OBSTACLE_SPAWN_FREQUENCY == 0 && started) {
			this.obstacles.add(new Obstacle(this.LEVEL_WIDTH, (int) (rand.nextInt(this.LEVEL_HEIGHT) * .8),
					this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

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
		this.updateScore();
		this.updateLevel();
		this.checkCollisions();
		this.repaint();
	}

	public int getFinalScore() {
		return finalScore;
	}

	public int getLevelWidth() {
		return LEVEL_WIDTH;
	}

	public int getDistance() {
		return distance;
	}

	public int getLevelHeight() {
		return LEVEL_HEIGHT;
	}

	public Image getCloudImage() {
		return cloudImage;
	}

	public boolean getEasyDraw() {
		return this.easyDraw;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public ArrayList<Ground> getGround() {
		return ground;
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

	public ArrayList<Cloud> getClouds() {
		return clouds;
	}

	public void setGround(ArrayList<Ground> ground) {
		this.ground = ground;
	}

	public void setClouds(ArrayList<Cloud> clouds) {
		this.clouds = clouds;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public void setEasyDraw(Boolean val) {
		this.easyDraw = val;
	}

	public void setStarted(boolean val) {
		this.started = val;
	}

	public void setInGame(boolean val) {
		this.ingame = val;
	}

}