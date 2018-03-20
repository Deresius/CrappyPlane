package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Ground;

/**
 * Tests the movement of the Ground object.
 * 
 * @author Team 4
 *
 */
class TestGroundMovement {

	@Test
	final void testHeightStaysSameOnNormalMove() {
		Ground myGround = new Ground(300, 200, 300);

		myGround.move();
		int expect = 200;

		assertEquals(expect, myGround.getY());
	}

	@Test
	final void testDistanceMoved() {
		Ground myGround = new Ground(300, 200, 300);

		myGround.move();
		int expect = 300 - myGround.getSpeed();

		assertEquals(expect, myGround.getX());
	}

	@Test
	final void testResetToMaxXWhenMoveIsCalledAtNegativeMaxX() {
		Ground myGround = new Ground(5, 10, 5);
		int expect = myGround.getX();

		myGround.move();
		myGround.move();

		assertEquals(expect, myGround.getX());
	}

}
