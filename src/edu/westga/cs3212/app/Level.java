package edu.westga.cs3212.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Level extends JPanel implements ActionListener {
	
	/**
	 * Generated serial for warning suppression.
	 */
	private static final long serialVersionUID = 4780054145331265009L;
	private Timer timer;
    private Plane plane;
    private boolean ingame;
    private final int PLANE_START_LOCATION_X = 40;
    private final int PLANE_START_LOCATION_Y = 60;
    private final int LEVEL_WIDTH = 400;
    private final int LEVEL_HEIGHT = 300;
    private final int DELAY = 15;
	
	public Level() {
		initLevel();

	}
	
	private void initLevel() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(LEVEL_WIDTH, LEVEL_HEIGHT));

        plane = new Plane(PLANE_START_LOCATION_X, PLANE_START_LOCATION_Y);


        timer = new Timer(DELAY, this);
        timer.start();
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

	private void drawObjects(Graphics g) {

        if (plane.isVisible()) {
            g.drawImage(plane.getImage(), plane.getX(), plane.getY(),
                    this);
        }

        g.setFont(new Font("Helvetica", Font.PLAIN, 20));

        g.setColor(Color.WHITE);
        g.drawString("Don't Panic: Press Spacebar", 500, 200);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (LEVEL_WIDTH - fm.stringWidth(msg)) / 2,
                LEVEL_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updatePlane();

        checkCollisions();

        repaint();
    }

    
	 private void inGame() {
	        
	        if (!ingame) {
	            timer.stop();
	        }
	    }

	 private void updatePlane() {

	        if (plane.isVisible()) {
	            plane.move();
	        }
	    }

	 
	 public void checkCollisions() {

	        /*Rectangle player = plane.getBoundaries();

	        if(player.intersects("the ground")) {
	        	plane.setVisible(false);
	        	ingame = false;
	        }
	        
	        if(player.intersects("obstacle")) {
	        	//take damage
	        	
	        }*/
	        
	    }

	

	private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            plane.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            plane.keyPressed(e);
        }
    }



	

}
