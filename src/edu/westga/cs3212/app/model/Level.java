package edu.westga.cs3212.app.model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.westga.cs3212.app.server.HighscoreClient;

/**
 * Sets up the level to be played
 *
 * @author Team 4
 */
public class Level extends JPanel {

	/**
	 * Generated serial for warning suppression.
	 */
	private static final long serialVersionUID = 4780054145331265009L;
	private static final int CLOUD_SPAWN_FREQUENCY = 500;
	private static final int OBSTACLE_SPAWN_FREQUENCY = 1000;

	private Plane plane;
	private ArrayList<Ground> ground;
	private ArrayList<Cloud> clouds;
	private ArrayList<Obstacle> obstacles;

	private boolean ingame;
	private boolean started = false;
	private int distance;
	private int finalScore;
	private boolean scored;
	private Random rand = new Random();

	private final int PLANE_START_LOCATION_X = 40;
	private final int PLANE_START_LOCATION_Y = 60;

	private int LEVEL_WIDTH;
	private int LEVEL_HEIGHT;

	private Image cloudImage;

	private boolean easyDraw;
	private boolean showConsole;

	/**
	 * Instantiates a new level, based on the given viewport.
	 */
	public Level() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.LEVEL_HEIGHT = (int) screenSize.getHeight();
		this.LEVEL_WIDTH = (int) screenSize.getWidth();
		ImageIcon ii = new ImageIcon("src/images/cloud.png");
		this.cloudImage = ii.getImage();
		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);
		this.initLevel();

	}

	/**
	 * Initializes the level.
	 */
	public void initLevel() {
		this.obstacles = new ArrayList<Obstacle>();
		this.clouds = new ArrayList<Cloud>();
		this.easyDraw = false;
		this.started = false;
		this.scored = false;
		this.ingame = true;
		this.distance = 0;
		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);
		this.setupGround();
	}

	public void startLevel() {
		this.started = true;

		this.setupSky();
		this.setupObstacles();
	}

	public void scoreGame() {
		this.finalScore = this.distance;
	}

	public void updateScore() {
		if (this.started) {
			this.distance++;
		}
	}

	/**
	 * Called to update the level for moving objects, and spawning clouds and .
	 */
	public void updateLevel() {

		updateGround();
		updatePlane();

		if (this.isStarted()) {
			updateClouds();
			updateObstacles();
			updateScore();
			spawnObstacles();
			spawnClouds();
		}

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

	private void updatePlane() {
		this.plane.move();

	}

	public void endGame() {
		this.ingame = false;
		if (!scored) {
			scoreGame();
			scored = true;
			new HighscoreClient();
		}
	}

	private void setupSky() {

		this.clouds = new ArrayList<Cloud>();

		for (int i = 0; i < 3; i++) {
			this.clouds.add(new Cloud(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		}
	}
	
	private void setupObstacles() {
		this.obstacles = new ArrayList<Obstacle>();
		this.obstacles.add(new Obstacle(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
				rand.nextInt((int) (.8 * this.LEVEL_HEIGHT)), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
	}

	private void setupGround() {
		this.ground = new ArrayList<Ground>();
		this.ground.add(new Ground(0, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
		this.ground.add(new Ground(this.LEVEL_WIDTH, this.LEVEL_HEIGHT - 150, this.LEVEL_WIDTH));
	}

	public boolean showConsole() {
		return this.showConsole = true;
	}

	public boolean hideConsole() {
		return this.showConsole = false;
	}

	public boolean consoleVisible() {
		return this.showConsole;
	}

	public void setEasyDraw(boolean val) {
		this.easyDraw = val;
	}

	public boolean isIngame() {
		return this.ingame;
	}

	public boolean isStarted() {
		return this.started;
	}

	public int getFinalScore() {
		return this.finalScore;
	}

	public int getDistance() {
		return this.distance;
	}

	public Image getCloudImage() {
		return this.cloudImage;
	}

	public boolean getEasyDraw() {
		return this.easyDraw;
	}

	public ArrayList<Obstacle> getObstacles() {
		return this.obstacles;
	}

	public ArrayList<Ground> getGround() {
		return this.ground;
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

	public boolean getScored() {
		return this.scored;
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
		return this.clouds;
	}

	public int getCloudSpawnFrequency() {
		return CLOUD_SPAWN_FREQUENCY;
	}

	public int getObstacleSpawnFrequency() {
		return OBSTACLE_SPAWN_FREQUENCY;
	}

	public void setStarted(boolean val) {
		this.started = val;
	}

	public void setInGame(boolean val) {
		this.ingame = val;
	}

	public void setScored(boolean val) {
		this.scored = val;
	}

}