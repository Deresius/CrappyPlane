package edu.westga.cs3212.app;

public class Ground extends Sprite {

	private int maxDrawToLeft;
	
	public Ground(int x, int y, int maxX) {
		super(x, y);

		maxDrawToLeft = maxX;
		
		initializeGround();
	}

	private void initializeGround() {
		loadImage("src/images/grass.png");
		getImageDimensions();
	}

	@Override
	public void move() {
		
		if(x > (-maxDrawToLeft))
		{
			x = x - 17;
		}else {
			x = maxDrawToLeft;
		}
		
		
		
		// TODO Auto-generated method stub

	}

}
