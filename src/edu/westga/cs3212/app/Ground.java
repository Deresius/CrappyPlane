package edu.westga.cs3212.app;

public class Ground extends Sprite {

	public Ground(int x, int y) {
		super(x, y);

		initializeGround();
	}

	private void initializeGround() {
		loadImage("src/images/grass.png");
		getImageDimensions();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
