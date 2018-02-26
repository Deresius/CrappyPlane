package edu.westga.cs3212.app;

/**
 * The Class Sky.
 */
public class Sky extends Sprite{

	/**
	 * Instantiates a new sky.
	 *
	 * @param x the x
	 * @param y the y
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
	public void move() {}

}
