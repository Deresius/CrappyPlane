package edu.westga.cs3212.app.model;

/**
 * The ground that gives the user a sense of speed
 * 
 * @author Team 4
 */
public class Ground extends Sprite {

	private int maxDrawToLeft;
	private int speed = 17;

	/**
	 * Instantiates a new ground object at the given location with a max width
	 *
	 * @param x
	 *            the x-axis location
	 * @param y
	 *            the y-axis location
	 * @param maxX
	 *            the max distance the ground can be drawn
	 */
	public Ground(int x, int y, int maxX) {
		super(x, y);

		if (maxX < x) {
			throw new IllegalArgumentException("Ground Max X location is lower than starting position");
		}

		this.maxDrawToLeft = maxX;

		this.initializeGround();
	}

	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Initialize ground.
	 */
	private void initializeGround() {
		this.loadImage("src/images/grass.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {

		if (this.x > (-this.maxDrawToLeft)) {
			this.x -= this.speed;
		} else {
			this.x = this.maxDrawToLeft;
		}

	}

}
