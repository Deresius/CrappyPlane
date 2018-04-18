package edu.westga.cs3212.app.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JPanel;

import edu.westga.cs3212.app.model.Level;
import edu.westga.cs3212.app.model.Obstacle;
import edu.westga.cs3212.app.model.Plane;
import edu.westga.cs3212.app.view.Painter;

/**
 * The controller class for the level/playable scene of the crappyplane game.
 */
public class SceneController extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private final int DELAY = 10;
	private Thread animator;
	private Level level;
	private ControlListener listener;
	private Painter painter;

	/**
	 * Constructs the scene controller, with the provided level bound to focus.
	 */
	public SceneController(Level level) {
		this.level = level;
		this.listener = new ControlListener(this);
		this.addKeyListener(listener);
		this.setFocusable(true);
		Color lgtBlue = new Color(41, 151, 255);
		this.setBackground(lgtBlue);
	}

	/**
	 * The Runnable method.
	 */
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
	 * The call to draw the scene.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.painter = new Painter(this.level);

		if (this.level.isIngame()) {

			painter.drawObjects(g);

		} else {
			setBackground(Color.BLACK);
			painter.drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * The animators thread control.
	 */
	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	/**
	 * Initializes a new level, setting the background color for the sky.
	 */
	public void startLevel() {
		Color lgtBlue = new Color(41, 151, 255);
		
		this.setBackground(lgtBlue);
		
		this.level.initLevel();
	}

	/**
	 * Restarts the game.
	 */
	public void restartGame() {
		Color lgtBlue = new Color(41, 151, 255);
		
		this.setBackground(lgtBlue);
		
		this.level.endGame();
		this.level.initLevel();
	}

	/**
	 * Check collisions for collisions between the plane, the ground, and objects,
	 * to end the game.
	 */
	public void checkCollisions() {

		Plane plane = this.level.getPlane();

		Rectangle player = plane.getBoundaries();

		if (plane.getY() + plane.getHeight() > this.level.getHeight()) {
			this.level.endGame();
		}

		for (Obstacle individualObstacle : this.level.getObstacles()) {

			Rectangle obstacleBounds = individualObstacle.getBoundaries();

			if (player.intersects(obstacleBounds)) {
				this.level.endGame();
			}
		}
	}

	/**
	 * Called by the run method to tick time/distance called for the game engine.
	 */
	private void cycle() {
		this.level.updateLevel();
		this.repaint();
		if (this.level.isStarted()) {
			this.checkCollisions();

		}

	}

	/**
	 * Returns the level of this controller.
	 */
	public Level getLevel() {
		return this.level;
	}

}
