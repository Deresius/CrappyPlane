package edu.westga.cs3212.app;

public class Sky extends Sprite{

	public Sky(int x, int y) {
		super(x, y);
		
		initializeSky();
	}

	private void initializeSky() {
		loadImage("src/images/sky.png");
		getImageDimensions();
	}

	@Override
	public void move() {		
	}

}
