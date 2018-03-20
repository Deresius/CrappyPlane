package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Ground;

/**
 * Tests the methods of the Ground object.
 * 
 * @author Team 4
 *
 */
class TestGroundContructor {

	@Test
	final void testFailNegativeX() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ground(-3, 2, 300);
		}, "Ground was created with a negative X.");
	}

	@Test
	final void testFailNegativeY() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ground(3, -2, 300);
		}, "Ground was created with a negative Y.");
	}

	@Test
	final void testFailMaxXLessThanX() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ground(3, 2, 2);
		}, "Ground was created with a negative Y.");
	}

	@Test
	final void testPassAllSameNumber() {		
		Ground testGround = new Ground(3, 3, 3);
		
		assertEquals(17, testGround.getSpeed());
	}

	@Test
	final void testPassAllLargerNumbers() {
		Ground testGround = new Ground(300, 400, 350);
		
		assertEquals(17, testGround.getSpeed());
	}

	@Test
	final void testPassAllZero() {
		Ground testGround = new Ground(0, 0, 0);
		
		assertEquals(17, testGround.getSpeed());
	}

}
