package edu.westga.cs3212.app;


/**
 * The Class Ground.
 */
public class Ground extends Sprite {

	
	private int maxDrawToLeft;
	
	/**
	 * Instantiates a new ground.
	 *
	 * @param x the x
	 * @param y the y
	 * @param maxX the max X
	 */
	public Ground(int x, int y, int maxX) {
		super(x, y);

		this.maxDrawToLeft = maxX;
		
		this.initializeGround();
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
		
		if(this.x > (-this.maxDrawToLeft))
		{
			this.x = this.x - 17;
		}else {
			this.x = this.maxDrawToLeft;
		}

	}

}
