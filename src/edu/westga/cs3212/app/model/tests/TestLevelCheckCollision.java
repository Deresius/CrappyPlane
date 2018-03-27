package edu.westga.cs3212.app.model.tests;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

class TestLevelCheckCollision {

	@Test
	void testCheckCollision() {
		Level level = new Level();
		level.checkCollisions();
	}

}
