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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {

	/**
	 * Generated serial for warning suppression.
	 */
	private static final long serialVersionUID = 4780054145331265009L;
	private Timer timer;
<<<<<<< HEAD
	private Plane plane;
	private Ground ground;
	private boolean ingame;
	private final int PLANE_START_LOCATION_X = 40;
	private final int PLANE_START_LOCATION_Y = 60;
	private int LEVEL_WIDTH = 400;
	private int LEVEL_HEIGHT = 300;
	private final int DELAY = 15;

=======
    private Plane plane;
    private Ground ground;
    private Clouds clouds;
    private boolean ingame;
    private final int PLANE_START_LOCATION_X = 40;
    private final int PLANE_START_LOCATION_Y = 60;
    private int LEVEL_WIDTH = 400;
    private int LEVEL_HEIGHT = 300;
    private final int DELAY = 15;
	
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615
	public Level() {
		this.LEVEL_HEIGHT = CrappyPlane.verticalPixelCount;
		this.LEVEL_WIDTH = CrappyPlane.horizontalPixelCount;

		initLevel();

	}

	private void initLevel() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		this.ingame = true;

		setPreferredSize(new Dimension(this.LEVEL_WIDTH, this.LEVEL_HEIGHT));

<<<<<<< HEAD
		this.plane = new Plane(this.PLANE_START_LOCATION_X, this.PLANE_START_LOCATION_Y);

		this.ground = new Ground(0, 600);

		this.timer = new Timer(this.DELAY, this);
		this.timer.start();
	}
=======
        this.plane = new Plane(PLANE_START_LOCATION_X, PLANE_START_LOCATION_Y);
        this.ground = new Ground(0,600);
        this.clouds = new Clouds(LEVEL_WIDTH/2, LEVEL_HEIGHT-(LEVEL_HEIGHT- (-50)));
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (this.ingame) {

			drawObjects(g);

		} else {

			drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics g) {

<<<<<<< HEAD
		if (this.plane.isVisible()) {
			g.drawImage(this.plane.getImage(), this.plane.getX(), this.plane.getY(), this);
		}
=======
        if (plane.isVisible()) {
            g.drawImage(plane.getImage(), plane.getX(), plane.getY(),
                    this);
        }
        
        g.drawImage(ground.getImage(), ground.getX(), ground.getY(), 1200, 161, this);
        
       
        g.drawImage(clouds.getImage(),clouds.getX(), clouds.getY(),200,200,this);
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615

		g.drawImage(this.ground.getImage(), this.ground.getX(), this.ground.getY(), 1200, 161, this);

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
		g.drawString(msg, (this.LEVEL_WIDTH - fm.stringWidth(msg)) / 2, this.LEVEL_HEIGHT / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

<<<<<<< HEAD
		inGame();

		updatePlane();
=======
        updatePlane();
        
        this.clouds.move(); //TODO
        
        checkCollisions();
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615

		checkCollisions();

		repaint();
	}

	private void inGame() {

<<<<<<< HEAD
		if (!this.ingame) {
			this.timer.stop();
		}
	}
=======
	        if (plane.isVisible()) {
	            this.plane.move();
	            
	        }
	    }
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615

	private void updatePlane() {

		if (this.plane.isVisible()) {
			this.plane.move();
		}
	}

	public void checkCollisions() {

		Rectangle player = this.plane.getBoundaries();
		Rectangle groundBounds = this.ground.getBoundaries();

		if (player.intersects(groundBounds)) {
			this.plane.setVisible(false);
			this.ingame = false;
		}

		/*
		 * if(player.intersects("obstacle")) { take damage
		 * 
		 * }
		 */

	}

	private class TAdapter extends KeyAdapter {

<<<<<<< HEAD
		@Override
		public void keyReleased(KeyEvent e) {
			plane.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			plane.keyPressed(e);
		}
	}
=======
	
	
	
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615

}
