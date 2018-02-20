/**
 * 
 */
package edu.westgs.cs3212.app.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.Clouds;

/**
 * @author William Leatherman
 * @version 2018-02-17
 * 
 *          Tests the Clouds class.
 *
 */
class CloudsTests {

	/**
	 * Tests finding the horizontal location.
	 */
	@Test
	void testFindHorizontalLocation() {
		Clouds testCloud = new Clouds(40, 80);

		assertEquals(40, testCloud.getX());
	}

	/**
	 * Tests finding the vertical location.
	 */
	@Test
	void testFindVerticalLocation() {
		Clouds testCloud = new Clouds(40, 80);

		assertEquals(80, testCloud.getY());
	}

	/**
	 * Tests setting the visibility.
	 */
	@Test
	void testSetVisibility() {
		Clouds testCloud = new Clouds(40, 80);

		testCloud.setVisible(false);

		assertEquals(false, testCloud.isVisible());
	}

	/**
	 * Tests getting the width of a cloud. Default of 1988.
	 */
	@Test
	void testGetWidth() {
		Clouds testCloud = new Clouds(40, 80);

		assertEquals(1988, testCloud.getWidth());
	}

	/**
	 * Tests getting the height of a cloud. Default of 1290.
	 */
	@Test
	void testGetHeight() {
		Clouds testCloud = new Clouds(40, 80);

		assertEquals(1290, testCloud.getHeight());
	}

}
