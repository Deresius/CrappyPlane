package edu.westga.cs3212.app;

import java.util.Random;

public class Obstacle extends Sprite{
	
	private int lowestAltitudeToDraw;
	private int rightSideOfScreen;
	private int speed = 5;
	
	public Obstacle(int x, int y, int maxX , int maxY) {
		super(x, y);
		
		this.lowestAltitudeToDraw = maxY;
		this.rightSideOfScreen = maxX;
		
		this.initializeObstacle();
	}
	
	public int getSpeed() {
		return speed;
	}
	
	private void initializeObstacle() {

		this.loadImage("src/images/balloon.png");
		this.getImageDimensions();
	}

	@Override
	public void move() {
		this.x -= this.speed;
		
		if( this.x < -this.rightSideOfScreen / 2 ) {
			Random rand = new Random();
			
			this.x = this.rightSideOfScreen + rand.nextInt(this.rightSideOfScreen);
			
			this.y = (int)(rand.nextInt(this.lowestAltitudeToDraw) * .7);
			     //speed = rand.nextInt(4) + 1;
			     
			     Random rando = new Random();
					int theRandom = rando.nextInt(3) + 1;
					if(theRandom == 1) {
						this.loadImage("src/images/balloon2.png");
					}else if(theRandom == 2) {
						this.loadImage("src/images/balloon3.png");
					}else {
						this.loadImage("src/images/balloon.png");
					}
			
			
		}
		
	

	}

}
