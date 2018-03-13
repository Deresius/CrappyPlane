package edu.westgs.cs3212.app.cloudtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Cloud;

/**
 * Tests the constructor for the Cloud class
 * 
 * @author Team 4
 */
class TestCloudConstructor {

	@Test
	final void testFailNegativeX() {
		try {
			new Cloud(-3, 2, 2, 3);
			fail("Cloud was created with a negative X");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testFailNegativeY() {
		try {
			new Cloud(3, -2, 2, 3);
			fail("Cloud was created with a negative Y");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testFailInvalidMaxX() {
		try {
			new Cloud(3, 2, 4, 3);
			fail("Cloud was created with a MaxX greater than X");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testFailInvalidMaxY() {
		try {
			new Cloud(3, 2, 2, 1);
			fail("Cloud was created with a MaxY less than Y");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	final void testPassValidCloud() {
		try {
			new Cloud(3, 2, 2, 3);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}