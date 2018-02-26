package edu.westga.cs3212.app;

public class Ground extends Sprite {

	private int maxDrawToLeft;

	public Ground(int x, int y, int maxX) {
		super(x, y);

		this.maxDrawToLeft = maxX;

		this.initializeGround();
	}

	private void initializeGround() {
		this.loadImage("src/images/grass.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {

		if (this.x > (-this.maxDrawToLeft)) {
			this.x = this.x - 17;
		} else {
			this.x = this.maxDrawToLeft;
		}

	}

}
