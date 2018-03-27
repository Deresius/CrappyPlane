package edu.westga.cs3212.app.model;

/**
 * Defines the Plane class which is operated by the user
 *
 * @author Team 4
 */
public class Plane extends Sprite {

	public static final int RISE_NORMAL = -2;
	public static final int FALL_NORMAL = 6;

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
