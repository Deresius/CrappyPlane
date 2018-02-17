package edu.westga.cs3212.app;

public class Ground extends Sprite {

	public Ground(int x, int y) {
		super(x, y);

		initializeGround();
	}

	private void initializeGround() {

<<<<<<< HEAD
		loadImage("src/images/Spring_Grass_PNG_Transparent_Clip_Art_Image.png");
		getImageDimensions();
	}
=======
    private void initializeGround() {
        
        loadImage("src/images/grass.png");
        getImageDimensions();
    }
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
