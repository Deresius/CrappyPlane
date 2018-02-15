package edu.westga.cs3212.app;

public class Ground extends Sprite {

	public Ground(int x, int y) {
		super(x, y);

		initializeGround();
	}

	private void initializeGround() {

		loadImage("src/images/Spring_Grass_PNG_Transparent_Clip_Art_Image.png");
		getImageDimensions();
	}

}
