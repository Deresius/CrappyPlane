package edu.westga.cs3212.app;

import java.awt.event.KeyEvent;

/**
 * Defines the Plane class which is operated by the user
 *
 */
public class Plane extends Sprite {

	private int directionY;

	/**
	 * Create a Plane at a given x,y location
	 * 
	 * @param x
	 *            The horizontal location of the Plane
	 * @param y
	 *            The vertical location of the Plane
	 */
	public Plane(int x, int y) {
		super(x, y);

		initializePlane();
	}

	private void initializePlane() {

		loadImage("src/images/plane.png");
		getImageDimensions();
	}

	/**
	 * Moves the Plane up
	 */
	public void move() {

		this.y += this.directionY;

		if (this.x < 1) {
			this.x = 1;
		}

		if (this.y < 1) {
			this.y = 1;
		}
	}

	/**
	 * Registers when a key is pressed and responds
	 * 
	 * @param e
	 *            The event
	 */
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			this.directionY = -1;
		}

	}

	/**
	 * Registers when a key is released and responds
	 * 
	 * @param e
	 *            The event
	 */
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			this.directionY = +3;
		}
	}
}
