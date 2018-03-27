package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

/**
 * Tests Level's hide console method.
 * 
 * @author Team 4
 *
 */
class TestLevelHideConsole {

	@Test
	void testHideConsole() {
		Level level = new Level();

		level.hideConsole();

		assertEquals(false, level.consoleVisible());
	}

}
