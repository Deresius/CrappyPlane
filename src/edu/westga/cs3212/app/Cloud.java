package edu.westga.cs3212.app;

import java.util.Random;

public class Cloud extends Sprite {

	private int lowestAltitudeToDraw;
	private int rightSideOfScreen;
	private int speed = 6;

	/**
	 * Creates a cloud object with a given location and max location
	 * 
	 * @param x
	 *            The horizontal location
	 * @param y
	 *            The vertical location
	 * @param maxX
	 *            Lowest altitude it can be drawn
	 * @param maxY
	 *            Farthest it can travel
	 */
	public Cloud(int x, int y, int maxX, int maxY) {
		super(x, y);

		if (maxX < x) {
			throw new IllegalArgumentException("Max X is lower than starting position");
		}
		if (maxY < y) {
			throw new IllegalArgumentException("Max Y is lower than starting position");
		}

		this.lowestAltitudeToDraw = maxY;
		this.rightSideOfScreen = maxX;

		this.initializeGround();

	}

	/**
	 * @return The speed of the cloud
	 */
	public int getSpeed() {
		return this.speed;
	}

	private void initializeGround() {

		this.loadImage("src/images/cloud.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {
		this.x -= this.speed;

		if (this.x < -this.rightSideOfScreen / 2) {
			Random rand = new Random();

			this.x = this.rightSideOfScreen + rand.nextInt(this.rightSideOfScreen);

			this.y = (int) (rand.nextInt(this.lowestAltitudeToDraw) * .6);
			this.speed = rand.nextInt(7) + 1;

		}

	}
}
