package edu.westga.cs3212.app.model;

/**
 * The Sky for the background of the running application
 * 
 * @author Team 4
 */
public class Sky extends Sprite {

	/**
	 * Instantiates a new sky that will be used as the background
	 *
	 * @param x
	 *            The horizontal location of the Sky
	 * @param y
	 *            The vertical location of the Sky
	 */
	public Sky(int x, int y) {
		super(x, y);

		this.initializeSky();
	}

	/**
	 * Initialize sky.
	 */
	private void initializeSky() {
		this.loadImage("src/images/sky.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {
	}

}
