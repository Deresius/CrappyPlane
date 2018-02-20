package edu.westga.cs3212.app;

import java.awt.event.KeyEvent;

/**
 * Defines the Plane class which is operated by the user
 *
 */
public class Plane extends Sprite {

	private static final int RISE_SLOW = 1;
	private static final int FALL_NORMAL = -3;

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
			this.move(this.RISE_SLOW);
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
			this.move(this.FALL_NORMAL);
		}
	}

	/**
	 * Moves the plane in the given direction
	 * 
	 * @param speed
	 *            Controls both speed and direction. Up if positive and down if
	 *            negative. Larger the number the faster it goes
	 * 
	 */
	public void move(int speed) {
		this.directionY = speed;
	}
}
