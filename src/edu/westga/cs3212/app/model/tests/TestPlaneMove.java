package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Plane;

/**
 * Test Plane's move method.
 * 
 * @author Team 4
 *
 */
class TestPlaneMove {

	@Test
	final void testFirstMove() {
		Plane plane = new Plane(0, 0);

		plane.move();
		int expect = 1;

		assertEquals(expect, plane.getY());
	}

	@Test
	final void testSecondMove() {
		Plane plane = new Plane(0, 0);

		plane.move();
		plane.move(1);
		plane.move();
		int expect = 2;

		assertEquals(expect, plane.getY());
	}

	@Test
	final void testMoveTwo() {
		Plane plane = new Plane(0, 0);

		plane.move(2);
		plane.move();
		int expect = 2;

		assertEquals(expect, plane.getY());
	}

	@Test
	final void testMoveDown() {
		Plane plane = new Plane(0, 10);

		plane.move(-8);
		plane.move();
		int expect = 2;

		assertEquals(expect, plane.getY());
	}

}
