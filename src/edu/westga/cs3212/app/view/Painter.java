package edu.westga.cs3212.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.westga.cs3212.app.model.Cloud;
import edu.westga.cs3212.app.model.Ground;
import edu.westga.cs3212.app.model.Level;
import edu.westga.cs3212.app.model.Obstacle;
import edu.westga.cs3212.app.model.Plane;

public class Painter extends JPanel {

	private static final long serialVersionUID = 4019176462855353817L;
	private Level theLevel;

	public Painter(Level myLevel) {
		this.theLevel = myLevel;
	}

	/**
	 * Called to Draw the objects on the screen
	 *
	 * @param g
	 *            the graphics
	 */
	public void drawObjects(Graphics g) {
		Plane plane = this.theLevel.getPlane();
		if (!this.theLevel.getEasyDraw()) {
			g.drawImage(plane.getImage(), (int) plane.getX(), (int) plane.getY(), this);
		} else {
			g.setColor(Color.red);
			g.fillOval((int) plane.getX(), (int) plane.getY(), 200, 50);
		}

		for (Obstacle obstacle : this.theLevel.getObstacles()) {
			if (!this.theLevel.getEasyDraw()) {
				g.drawImage(obstacle.getImage(), (int) obstacle.getX(), (int) obstacle.getY(), 80, 100, this);
			} else {
				g.setColor(Color.orange);
				g.fillOval((int) obstacle.getX(), (int) obstacle.getY(), 80, 100);
			}

		}

		for (Cloud cloud : this.theLevel.getClouds()) {
			if (!this.theLevel.getEasyDraw()) {
				g.drawImage(this.theLevel.getCloudImage(), (int) cloud.getX(), (int) cloud.getY(),
						(190 * cloud.getSpeed()) / 4, (110 * cloud.getSpeed()) / 4, this);
			} else {
				g.setColor(Color.white);
				g.fillOval((int) cloud.getX(), (int) cloud.getY(), 190, 110);
			}
		}

		for (Ground ground : this.theLevel.getGround()) {
			if (!this.theLevel.getEasyDraw()) {
				g.drawImage(ground.getImage(), (int) ground.getX(), (int) ground.getY(),
						(int) (this.theLevel.getWidth() * 1.1), this.theLevel.getHeight() / 6, this);
			}
		}
		drawScore(g);
		drawControls(g);

	}

	public void drawScore(Graphics g) {
		g.setFont(new Font("Helvetica", Font.PLAIN, 25));
		g.setColor(Color.WHITE);
		g.drawString("Distance: " + this.theLevel.getDistance(), this.theLevel.getWidth() - 250, 20);
	}

	public void drawControls(Graphics g) {
		if (!this.theLevel.isStarted()) {
			String msg = "Don't Panic: Press Spacebar";
			Font small = new Font("Helvetica", Font.BOLD, 50);
			FontMetrics fm = getFontMetrics(small);
			g.drawString(msg, (this.theLevel.getWidth() - (fm.stringWidth(msg) / 2)) / 2,
					this.theLevel.getHeight() / 2);
		}
		
		if(this.theLevel.consoleVisible()) {
			Font small = new Font("Helvetica", Font.BOLD, 50);
			FontMetrics fm = getFontMetrics(small);
			String console = "Console Activated - Press 'H' to hide this menu";
			String controls = "Press 'E' to activate simple graphics mode.";
			g.drawString(console, (this.theLevel.getWidth() - (fm.stringWidth(console) / 2)) / 2,
					(int) (this.theLevel.getHeight() * .55));
			g.drawString(controls, (this.theLevel.getWidth() - (fm.stringWidth(console) / 2)) / 2,
					(int) (this.theLevel.getHeight() * .6));
		}
	}

	/**
	 * Called to draw game over.
	 *
	 * @param g
	 *            the graphics
	 */
	public void drawGameOver(Graphics g) {
		theLevel.setBackground(Color.BLACK);
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 50);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (this.theLevel.getWidth() - fm.stringWidth(msg)) / 2, this.theLevel.getHeight() / 2);
		g.drawString("Score: " + this.theLevel.getFinalScore(), (this.theLevel.getWidth() - fm.stringWidth("Score:" + this.theLevel.getFinalScore())) / 2,
				(this.theLevel.getHeight() / 2) + 60);
		g.drawString("Press 'R' to Restart", (this.theLevel.getWidth() - fm.stringWidth("Press 'R' to Restart")) / 2,
				(this.theLevel.getHeight() / 2) + 150);
	}

}
