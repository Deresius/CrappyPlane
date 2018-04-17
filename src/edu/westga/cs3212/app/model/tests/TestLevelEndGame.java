package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

class TestLevelEndGame {


	@Test
	final void testEndGameUpdatesFinalScore() {
		Level level = new Level();
		level.initLevel();
		level.setStarted(true);
		level.updateScore();
		level.endGame();
		assertEquals(1, level.getFinalScore());
	}
	
	@Test
	final void testEndGameDoesNotUpdateFinalScoreIfScored() {
		Level level = new Level();
		level.initLevel();
		level.setStarted(true);
		level.updateScore();
		level.setScored(true);
		level.endGame();
		assertEquals(0, level.getFinalScore());
	}
	
	
	@Test
	final void testEndGameSetsScoredToTrue() {
		Level level = new Level();
		level.initLevel();
		level.setStarted(true);
		level.updateScore();
		level.endGame();
		assertEquals(true, level.getScored());
	}

}
