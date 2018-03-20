package edu.westgs.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Cloud;

/**
 * Tests the movement of a cloud object.
 * 
 * @author Team 4
 *
 */
class TestCloudMovement {

	@Test
	final void testHeightStaysSameOnNormalMove() {
		Cloud myCloud = new Cloud(300, 200, 200, 300);
		
		myCloud.move();
		int expect = 200;
		
		assertEquals(expect, myCloud.getY());
	}

	@Test
	final void testDistanceMoved() {
		Cloud myCloud = new Cloud(300, 200, 200, 300);
		
		myCloud.move();
		int expect = 300 - myCloud.getSpeed();
		
		assertEquals(expect, myCloud.getX());
	}

}
