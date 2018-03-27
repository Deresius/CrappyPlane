package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Obstacle;

/**
 * Tests the construction a an Obstacle object.
 * 
 * @author Team 4
 *
 */
class TestObstacleConstructor {

	@Test
	final void testFailNegativeX() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Obstacle(-3, 2, 2, 3);
		}, "Obstacle was created with a negative X.");
	}

	@Test
	final void testFailNegativeY() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Obstacle(3, -2, 2, 3);
		}, "Obstacle was created with a negative Y.");
	}

	@Test
	final void testFailInvalidMaxX() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Obstacle(3, 2, 4, 3);
		}, "Obstacle was created with a MaxX greater than X.");
	}

	@Test
	final void testFailInvalidMaxY() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Obstacle(3, 4, 2, 0);
		}, "Obstacle was created with a MaxY less than Y.");
	}

	@Test
	final void testPassValidCloud() {
		Obstacle testObstacle = new Obstacle(3, 2, 2, 3);

		assertEquals(5, testObstacle.getSpeed());
	}

}
