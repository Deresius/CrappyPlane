package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

/**
 * Tests the getter methods of the Level class.
 * 
 * @author Team 4
 *
 */
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

		assertEquals(expect, level.getCloudImage());
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

	@Test
	final void testGetDistance() {
		Level level = new Level();

		assertEquals(true, level.getDistance() == 0);
	}

	@Test
	final void testGetFinalScore() {
		Level level = new Level();

		assertEquals(true, level.getFinalScore() == 0);
	}

	@Test
	final void testGetObstacles() {
		Level level = new Level();

		assertEquals(true, level.getObstacles() != null);
	}

	@Test
	final void testGetGround() {
		Level level = new Level();

		assertEquals(true, level.getGround() != null);
	}

	@Test
	final void testGetClouds() {
		Level level = new Level();

		assertEquals(true, level.getClouds() != null);
	}
}
