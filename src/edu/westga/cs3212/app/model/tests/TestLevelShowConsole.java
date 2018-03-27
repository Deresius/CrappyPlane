package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

class TestLevelShowConsole {

	@Test
	void testShowConsole() {
		Level level = new Level();
		level.showConsole();
		assertEquals(true, level.consoleVisible());
	}

}
