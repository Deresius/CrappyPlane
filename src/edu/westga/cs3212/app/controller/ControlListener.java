package edu.westga.cs3212.app.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.westga.cs3212.app.model.Level;

/**
 * Handles all controls for a Level.
 * 
 * @author Team 4
 *
 */
public class ControlListener extends KeyAdapter {

	private Level theLevel;

	/**
	 * Constructs a ControlListener object with the given Level.
	 * 
	 * @param myLevel
	 *            The Level the ControlListener will handle keys for.
	 */
	public ControlListener(Level myLevel) {
		this.theLevel = myLevel;

	}

	/**
	 * Handles a key being released.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		this.theLevel.getPlane().keyReleased(e);

	}

	/**
	 * Handles a key being pressed down.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		this.theLevel.getPlane().keyPressed(e);
		this.theLevel.setStarted(true);
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_R) {
			this.theLevel.setStarted(false);
			this.theLevel.setInGame(true);
			this.theLevel.initLevel();
		}

		if (key == KeyEvent.VK_E) {
			this.theLevel.setEasyDraw(true);
		}

	}

	/**
	 * Returns the Level.
	 * 
	 * @return The Level.
	 */
	public Level getLevel() {
		return this.theLevel;
	}
}