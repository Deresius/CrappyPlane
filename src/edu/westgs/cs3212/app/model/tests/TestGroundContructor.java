package edu.westgs.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Ground;

class TestGroundContructor {

	@Test
	final void testFailNegativeX() {
		try {
			new Ground(-3, 2, 300);
			fail("Ground was created with a negative X");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testFailNegativeY() {
		try {
			new Ground(3, -2, 300);
			fail("Ground was created with a negative Y");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testFailMaxXLessThanX() {
		try {
			new Ground(3, 2, 2);
			fail("Ground was created with a negative Y");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testPassAllSameNumber() {
		try {
			new Ground(3, 3, 3);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	final void testPassAllLargerNumbers() {
		try {
			new Ground(300, 400, 350);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	final void testPassAllZero() {
		try {
			new Ground(0, 0, 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
