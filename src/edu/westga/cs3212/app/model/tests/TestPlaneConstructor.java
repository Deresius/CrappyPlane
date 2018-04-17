/**
 * 
 */
package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Plane;

/**
 * Tests the Plane object operated by the user.
 * 
 * @author Team 4
 *
 */
class TestPlaneConstructor {

	@Test
	final void testPassValidPlane() {
		Plane testPlane = new Plane(4, 4);

		assertNotEquals(null, testPlane);
	}

}
