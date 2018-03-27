package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;
import edu.westga.cs3212.app.model.Plane;

class TestLevelGetters {

	@Test
	final void testGetWidth() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Level level = new Level();
		int expect = screenSize.width;
		assertEquals(expect, level.getWidth());

	}

	@Test
	final void testGetHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Level level = new Level();
		int expect = screenSize.height;
		assertEquals(expect, level.getHeight());
	}

	@Test
	final void testGetImage() {
		Level level = new Level();
		Image expect = new ImageIcon("src/images/cloud.png").getImage();
		assertEquals(expect, level.getImage());
	}

	@Test
	final void testSetStartedTrue() {
		Level level = new Level();
		level.setStarted(true);
		assertEquals(true, level.isStarted());
	}
	
	@Test
	final void testSetStartedFalse() {
		Level level = new Level();
		level.setStarted(false);
		assertEquals(false, level.isStarted());
	}
	
	@Test
	final void testSetInGameTrue() {
		Level level = new Level();
		level.setInGame(true);
		assertEquals(true, level.isIngame());
	}
	
	@Test
	final void testSetInGameFalse() {
		Level level = new Level();
		level.setInGame(false);
		assertEquals(false, level.isIngame());
	}
	
	@Test
	final void testGetPlane() {
		Level level = new Level();
		level.initLevel();
		assertEquals(true, level.getPlane() != null);
	}
	
	@Test
	final void testSetEasyDrawTrue() {
		Level level = new Level();
		level.setEasyDraw(true);
		assertEquals(true, level.getEasyDraw());
	}
	
	@Test
	final void testSetEasyDrawFalse() {
		Level level = new Level();
		level.setEasyDraw(false);
		assertEquals(false, level.getEasyDraw());
	}
}
