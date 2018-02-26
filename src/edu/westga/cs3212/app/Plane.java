package edu.westga.cs3212.app;

import java.awt.event.KeyEvent;

/**
 * Defines the Plane class which is operated by the user
 *
 */
public class Plane extends Sprite {

	private static final int RISE_SLOW = -1;
	private static final int RISE_NORMAL = -2;
	private static final int RISE_FAST = -3;

	private static final int FALL_SLOW = 3;
	private static final int FALL_NORMAL = 6;
	private static final int FALL_FAST = 8;

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

		this.initializePlane();
	}

	private void initializePlane() {

		this.loadImage("src/images/plane.png");
		this.getImageDimensions();
	}

	/**
	 * Moves the Plane up
	 */
	public void move() {

		this.y += this.directionY;

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
			this.move(Plane.RISE_NORMAL);
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
			this.move(Plane.FALL_NORMAL);
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
