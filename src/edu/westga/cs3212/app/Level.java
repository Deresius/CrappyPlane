package edu.westga.cs3212.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Sets up the level to be played
 *
 * @author Team 4
 */
public class Level extends JPanel implements ActionListener {

	/**
	 * Generated serial for warning suppression.
	 */
	private static final long serialVersionUID = 4780054145331265009L;
	private Timer timer;

	private Plane plane;
	private ArrayList<Ground> ground;
	private ArrayList<Clouds> clouds;
	private ArrayList<Obstacle> obstacles;
	private Sky sky;
	private boolean ingame;
	private final int PLANE_START_LOCATION_X = 40;
	private final int PLANE_START_LOCATION_Y = 60;
	private int LEVEL_WIDTH;
	private int LEVEL_HEIGHT;
	private final int DELAY = 15;
	private int distance = 0;

	public Level() {
		this.LEVEL_HEIGHT = CrappyPlane.verticalPixelCount;
		this.LEVEL_WIDTH = CrappyPlane.horizontalPixelCount;

		initLevel();

	}

	private void initLevel() {

		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.ingame = true;
		this.clouds = new ArrayList<Clouds>();
		this.ground = new ArrayList<Ground>();
		this.obstacles = new ArrayList<Obstacle>();

		this.setPreferredSize(new Dimension(this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);

		ground.add(new Ground(0, LEVEL_HEIGHT - 150, LEVEL_WIDTH));
		ground.add(new Ground(LEVEL_WIDTH, LEVEL_HEIGHT - 150, LEVEL_WIDTH));
		this.sky = new Sky(0, 0);
		this.timer = new Timer(this.DELAY, this);
		this.timer.start();

		this.obstacles.add(new Obstacle(LEVEL_WIDTH, 0, LEVEL_WIDTH, LEVEL_HEIGHT));

		this.plane = new Plane(PLANE_START_LOCATION_X, PLANE_START_LOCATION_Y);
		this.clouds.add(new Clouds(LEVEL_WIDTH, 0, LEVEL_WIDTH, LEVEL_HEIGHT));
		this.clouds.add(new Clouds(LEVEL_WIDTH, 0, LEVEL_WIDTH, LEVEL_HEIGHT));
		this.clouds.add(new Clouds(LEVEL_WIDTH, 0, LEVEL_WIDTH, LEVEL_HEIGHT));
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

	private void drawObjects(Graphics g) {

		g.drawImage(this.sky.getImage(), this.sky.getX(), this.sky.getY(), LEVEL_WIDTH, LEVEL_HEIGHT, this);

		for (int i = 1; i < 4; i++) {
			for (Clouds cloud : this.clouds) {
				if (cloud.getSpeed() == i) {
					g.drawImage(cloud.getImage(), cloud.getX(), cloud.getY(), (190 * cloud.getSpeed()) / 2,
							(110 * cloud.getSpeed()) / 2, this);
				}
			}
		}

		if (this.plane.isVisible()) {
			g.drawImage(this.plane.getImage(), this.plane.getX(), this.plane.getY(), this);
		}

		for (Obstacle obstacle : this.obstacles) {
			g.drawImage(obstacle.getImage(), obstacle.getX(), obstacle.getY(), 80, 100, this);
		}

		for (int i = 4; i < 7; i++) {
			for (Clouds cloud : this.clouds) {
				if (cloud.getSpeed() == i) {
					g.drawImage(cloud.getImage(), cloud.getX(), cloud.getY(), (190 * cloud.getSpeed()) / 4,
							(110 * cloud.getSpeed()) / 4, this);
				}
			}
		}

		for (Ground ground : this.ground) {
			g.drawImage(ground.getImage(), ground.getX(), ground.getY(), (int) (LEVEL_WIDTH * 1.1), 150, this);
		}
		g.setFont(new Font("Helvetica", Font.PLAIN, 20));

		g.setColor(Color.WHITE);
		g.drawString("Don't Panic: Press Spacebar", 500, 200);
		g.drawString("Distance: " + distance, LEVEL_WIDTH - 200, 20);

	}

	private void drawGameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 50);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2, this.LEVEL_HEIGHT / 2);
		g.drawString("Score: " + distance, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2, (this.LEVEL_HEIGHT / 2) + 60);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.inGame();

		this.updatePlane();

		this.updateLevel();

		this.checkCollisions();

		this.repaint();
	}

	private void updateLevel() {
		this.distance++;

		for (Clouds cloud : this.clouds) {
			cloud.move();
		}

		for (Ground individualGround : this.ground) {
			individualGround.move();
		}

		for (Obstacle individualObstacle : this.obstacles) {
			individualObstacle.move();
		}

		Random rand = new Random();

		if (this.distance % 600 == 0) {
			this.obstacles.add(new Obstacle(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
			this.obstacles.add(new Obstacle(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		}

		if (this.distance % 200 == 0) {
			this.clouds.add(new Clouds(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
			this.clouds.add(new Clouds(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
			this.clouds.add(new Clouds(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
			this.clouds.add(new Clouds(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
			this.clouds.add(new Clouds(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
			this.clouds.add(new Clouds(this.LEVEL_WIDTH + rand.nextInt(this.LEVEL_WIDTH),
					(int) (rand.nextInt(this.LEVEL_HEIGHT) * .8), this.LEVEL_WIDTH, this.LEVEL_HEIGHT));
		}
	}

	private void inGame() {

		if (!this.ingame) {
			this.timer.stop();
		}
	}

	private void updatePlane() {

		if (this.plane.isVisible()) {
			this.plane.move();
		}
	}

	public void checkCollisions() {

		Rectangle player = this.plane.getBoundaries();

		if (this.plane.getY() + this.plane.getHeight() > this.LEVEL_HEIGHT) {
			this.plane.setVisible(false);
			this.ingame = false;
		}

		for (Obstacle individualObstacle : this.obstacles) {

			Rectangle obstacleBounds = individualObstacle.getBoundaries();

			if (player.intersects(obstacleBounds)) {
				this.plane.setVisible(false);
				this.ingame = false;
			}

		}

		/*
		 * if(player.intersects("obstacle")) { take damage
		 * 
		 * }
		 */

	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			plane.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			plane.keyPressed(e);
		}
	}

}
