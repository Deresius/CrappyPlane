package edu.westga.cs3212.app;

import java.awt.event.KeyEvent;

public class Plane extends Sprite {

    private int directionY;
    
    public Plane(int x, int y) {
        super(x, y);

        initializePlane();
    }

    private void initializePlane() {
        
        loadImage("src/images/plane.png");
        getImageDimensions();
    }

    public void move() {

       y += directionY;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            directionY = - 1;
        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            directionY = + 3;
        }        
    }
}
	

