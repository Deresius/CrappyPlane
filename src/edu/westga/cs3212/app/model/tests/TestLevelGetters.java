package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

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

}
