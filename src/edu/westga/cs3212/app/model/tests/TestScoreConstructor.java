package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Score;

/**
 * Tests the construction of a Score object.
 * 
 * @author Team 4
 *
 */
class TestScoreConstructor {

	@Test
	void testWhenNullIsPassedForPlayerName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Score(null, 9000);
		}, "Must enter a name.");
	}

	@Test
	void testWhenScoreIsValid() {
		new Score("Username", 9000);
	}

}
