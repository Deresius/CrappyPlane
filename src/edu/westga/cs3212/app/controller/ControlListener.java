package edu.westga.cs3212.app.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.westga.cs3212.app.model.Level;

public class ControlListener extends KeyAdapter {
	
	private Level theLevel;
	
	public ControlListener(Level myLevel) {
		this.theLevel = myLevel;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.theLevel.getPlane().keyReleased(e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.theLevel.getPlane().keyPressed(e);
		this.theLevel.setStarted(true);
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_R) {
			this.theLevel.setStarted(false);
			this.theLevel.setInGame(true);
			this.theLevel.initLevel();
			System.out.println("Pressed R");
		}
		
		if (key == KeyEvent.VK_E) {
			this.theLevel.setEasyDraw(true);
			System.out.println("Pressed E");
		}

	}
	
	
	public Level getLevel() {
		return this.theLevel;
	}
}
