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
		int key = e.getKeyCode();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_R) {
			
		}
		if (key == KeyEvent.VK_E) {

		}

	}
}
