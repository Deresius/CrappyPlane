package edu.westga.cs3212.app;

import java.util.Random;

public class Clouds extends Sprite {
	
	private int lowestAltitudeToDraw;
	private int rightSideOfScreen;
	private int speed = 6;
		
	public Clouds(int x, int y, int maxX , int maxY) {
		super(x, y);
		
		this.lowestAltitudeToDraw = maxY;
		this.rightSideOfScreen = maxX;
		
		this.initializeGround();
		
	}

	public int getSpeed() {
		return speed;
	}
	
	private void initializeGround() {

		this.loadImage("src/images/cloud.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {
		this.x -= this.speed;
		
		if( this.x < -this.rightSideOfScreen / 2 ) {
			Random rand = new Random();
			
			this.x = this.rightSideOfScreen + rand.nextInt(this.rightSideOfScreen);
			
			this.y = (int)(rand.nextInt(this.lowestAltitudeToDraw) * .6);
			this.speed = rand.nextInt(7) + 1;
			
		}

	}
}
