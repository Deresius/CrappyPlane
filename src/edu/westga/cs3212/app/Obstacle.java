package edu.westga.cs3212.app;

import java.util.Random;

public class Obstacle extends Sprite{
	
	private int lowestAltitudeToDraw;
	private int rightSideOfScreen;
	private int speed = 3;
	
	public Obstacle(int x, int y, int maxX , int maxY) {
		super(x, y);			
		lowestAltitudeToDraw = maxY;
		rightSideOfScreen = maxX;
		initializeObstacle();
	}
	
	public int getSpeed() {
		return speed;
	}
	
	private void initializeObstacle() {

		loadImage("src/images/balloon.png");
		getImageDimensions();
	}

	@Override
	public void move() {
		x -= speed;
		
		if( x < -rightSideOfScreen / 2 ) {
			Random rand = new Random();
			
			x = rightSideOfScreen + rand.nextInt(rightSideOfScreen);
			
			     y = (int)(rand.nextInt(lowestAltitudeToDraw) * .7);
			     //speed = rand.nextInt(4) + 1;
			     
			     Random rando = new Random();
					int theRandom = rando.nextInt(3) + 1;
					if(theRandom == 1) {
						loadImage("src/images/balloon2.png");
					}else if(theRandom == 2) {
						loadImage("src/images/balloon3.png");
					}else {
						loadImage("src/images/balloon.png");
					}
			
			
		}
		
	

	}

}
