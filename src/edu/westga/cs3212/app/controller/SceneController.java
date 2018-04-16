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

public class SceneController extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int DELAY = 10;
	private Thread animator;
	private Level level;
	
	
	public SceneController(Level level) {
		this.level = level;
		ControlListener listener = new ControlListener(this.level);
		this.addKeyListener(listener);
		this.setFocusable(true);
		Color lgtBlue = new Color(41, 151, 255);
		this.setBackground(lgtBlue);
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
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Painter painter = new Painter(this.level);

		if (this.level.isIngame()) {
			painter.drawObjects(g);

		} else {
			setBackground(Color.BLACK);
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
	
	private void cycle() {
		this.level.updateScore();
		this.level.updateLevel();
		this.checkCollisions();
		this.repaint();
	}

}
