package edu.westgs.cs3212.app.model.cloudtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Cloud;

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
