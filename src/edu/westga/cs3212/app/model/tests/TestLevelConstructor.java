package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

/**
 * Tests the Level constructor
 * 
 */
class TestLevelConstructor {
	private Dimension screenSize;

	@BeforeEach
	void setUp() throws Exception {
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}

	@Test
	final void testPassMakeNewLevelHasCorrectWidthAndHeight() {
		Level myLevel = new Level();
		int expect = (int) this.screenSize.getWidth() + (int) this.screenSize.getHeight();
		assertEquals(expect, myLevel.getWidth() + myLevel.getHeight());
	}

	@Test
	final void testPassNewLevelHasCorrectImage() {
		Level myLevel = new Level();
		ImageIcon expect = new ImageIcon("src/images/cloud.png");
		assertEquals(expect.getImage(), myLevel.getImage());
	}

}
