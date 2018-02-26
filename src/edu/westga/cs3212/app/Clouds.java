package edu.westga.cs3212.app;

import java.util.Random;

public class Clouds extends Sprite {
	
	private int lowestAltitudeToDraw;
	private int rightSideOfScreen;
	private int speed = 2;
		
	public Clouds(int x, int y, int maxX , int maxY) {
		super(x, y);
		lowestAltitudeToDraw = maxY;
		rightSideOfScreen = maxX;
		initializeGround();
	}

	public int getSpeed() {
		return speed;
	}
	
	private void initializeGround() {

		loadImage("src/images/cloud.png");
		getImageDimensions();
	}

	@Override
	public void move() {
		x -= speed;
		
		if( x < -rightSideOfScreen / 2 ) {
			Random rand = new Random();
			
			x = rightSideOfScreen + rand.nextInt(rightSideOfScreen);
			
			     y = (int)(rand.nextInt(lowestAltitudeToDraw) * .6);
			     speed = rand.nextInt(4) + 1;
			
			
		}
	

	}
}
