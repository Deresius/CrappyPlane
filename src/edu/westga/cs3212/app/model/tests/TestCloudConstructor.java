package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Cloud;
import edu.westga.cs3212.app.model.Ground;

/**
 * Tests the constructor for the Cloud class
 * 
 * @author Team 4
 */
class TestCloudConstructor {

	@Test
	final void testFailNegativeX() {	
		assertThrows(IllegalArgumentException.class, () -> {
			new Cloud(-3, 2, 2, 3);
		}, "Cloud was created with a negative X.");
	}

	@Test
	final void testFailNegativeY() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cloud(3, -2, 2, 3);
		}, "Cloud was created with a negative Y.");
	}

	@Test
	final void testFailInvalidMaxX() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cloud(3, 2, 4, 3);
		}, "Cloud was created with a MaxX greater than X.");
	}

	@Test
	final void testFailInvalidMaxY() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cloud(3, 2, 4, 3);
		}, "Cloud was created with a MaxY less than Y.");
	}

	@Test
	final void testPassValidCloud() {
		Cloud testCloud = new Cloud(3, 2, 2, 3);
		
		assertEquals(6, testCloud.getSpeed());
	}

	@Test
	final void testPassValidCloudLargeNumbers() {
		Cloud testCloud = new Cloud(300, 200, 200, 300);
		
		assertEquals(6, testCloud.getSpeed());
	}

	@Test
	final void testPassValidCloudNegativeMaxX() {
		Cloud testCloud = new Cloud(3, 2, -200, 3);
		
		assertEquals(6, testCloud.getSpeed());
	}

	@Test
	final void testPassValidCloudAllZero() {
		Cloud testCloud = new Cloud(0, 0, 0, 0);
		
		assertEquals(6, testCloud.getSpeed());
	}

	@Test
	final void testPassValidCloudAllSameNumber() {		
		Cloud testCloud = new Cloud(200, 200, 200, 200);
		
		assertEquals(6, testCloud.getSpeed());
	}

}
