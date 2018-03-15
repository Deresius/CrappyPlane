package edu.westga.cs3212.app.model;

import java.util.Random;

/**
 * Creates an obstacle that can be hit by the plane
 * 
 * @author Team 4
 */
public class Obstacle extends Sprite {

	private int lowestAltitudeToDraw;
	private int rightSideOfScreen;
	private int speed = 5;

	/**
	 * Creates an obstacle with a given location and max location
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
	public Obstacle(int x, int y, int maxX, int maxY) {
		super(x, y);

		if (maxX > x) {
			throw new IllegalArgumentException("Obstacle is being created on the screen");
		}

		if (maxY < y) {
			throw new IllegalArgumentException("Obstacle Max Y is lower than starting position");
		}

		this.lowestAltitudeToDraw = maxY;
		this.rightSideOfScreen = maxX;

		this.initializeObstacle();
	}

	/**
	 * @return the speed of the obstacle
	 */
	public int getSpeed() {
		return this.speed;
	}

	private void initializeObstacle() {

		this.loadImage("src/images/balloon.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {
		this.x -= this.speed;

		if (this.x < -this.rightSideOfScreen / 10) {
			Random rand = new Random();

			this.x = this.rightSideOfScreen + rand.nextInt(this.rightSideOfScreen / 3);

			this.y = (int) (rand.nextInt(this.lowestAltitudeToDraw) * .7);

			Random rando = new Random();
			int theRandom = rando.nextInt(3) + 1;

			// Needs optimization. Commented out randomization of image in this manner.
			// finding a new method of randomization(pointing)
			// will drastically increase speed at draw time.
			/*
			 * if (theRandom == 1) { this.loadImage("src/images/balloon2.png"); } else if
			 * (theRandom == 2) { this.loadImage("src/images/balloon3.png"); } else {
			 * this.loadImage("src/images/balloon.png"); }
			 */

		}

	}

}
