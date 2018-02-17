package edu.westga.cs3212.app;

public class Clouds extends Sprite {
	public Clouds(int x, int y) {
        super(x, y);

        initializeGround();
    }

    private void initializeGround() {
        
        loadImage("src/images/cloud.png");
        getImageDimensions();
    }

	@Override
	public void move() {
		if(x != -200) {
			x-=1;
		}
		
	}
}
