package edu.westga.cs3212.app;

public class Sky extends Sprite{

	public Sky(int x, int y) {
		super(x, y);
		
		this.initializeSky();
	}

	private void initializeSky() {
		this.loadImage("src/images/sky.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {}

}
