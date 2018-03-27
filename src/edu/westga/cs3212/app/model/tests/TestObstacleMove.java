package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Obstacle;

/**
 * Tests Obstacle's move method.
 * 
 * @author Team 4
 *
 */
class TestObstacleMove {

	@Test
	final void testHeightStaysSameOnNormalMove() {
		Obstacle myObstacle = new Obstacle(300, 200, 200, 300);

		myObstacle.move();
		int expect = 200;

		assertEquals(expect, myObstacle.getY());
	}

	@Test
	final void testDistanceMoved() {
		Obstacle myObstacle = new Obstacle(300, 200, 200, 300);

		myObstacle.move();
		int expect = 300 - myObstacle.getSpeed();

		assertEquals(expect, myObstacle.getX());
	}

	@Test
	final void testObstacleResets() {
		Obstacle myObstacle = new Obstacle(20, 200, 10, 300);

		myObstacle.move();
		myObstacle.move();
		myObstacle.move();
		myObstacle.move();
		myObstacle.move();
		boolean expect = true;
		
		assertEquals(expect, (myObstacle.getX() > 6));
	}

}
