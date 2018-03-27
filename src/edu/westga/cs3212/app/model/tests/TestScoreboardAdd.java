package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Score;
import edu.westga.cs3212.app.model.Scoreboard;

class TestScoreboardAdd {

	@Test
	final void testPassAddFirstHighScoreToBoardHasSizeOfOne() {
		Scoreboard board = new Scoreboard();
		board.add(new Score("Name", 1));
		int expect = 1;

		assertEquals(expect, board.getHighScores().get(0).getScore());
	}

	@Test
	final void testPassAddThreeNewScoresWithTwoAsTheSameNumber() {
		Scoreboard board = new Scoreboard();
		board.add(new Score("Name1", 1));
		board.add(new Score("Name2", 1));
		board.add(new Score("Name3", 2));
		int expect = 2;

		assertEquals(expect, board.getHighScores().get(0).getScore());
		assertEquals("Name1", board.getHighScores().get(1).getPlayersName());
	}

	@Test
	final void testPassAddElevenScoresShouldHaveCorrectHighScore() {
		Scoreboard board = new Scoreboard();
		for (int index = 0; index <= board.getMaxSize(); index++) {
			board.add(new Score("Name" + index, index));
		}

		int expect = 10;
		assertEquals(expect, board.getHighScores().get(0).getScore());
	}

	@Test
	final void testPassAddElevenScoresShouldKeepSizeTen() {
		Scoreboard board = new Scoreboard();
		for (int index = 0; index <= board.getMaxSize(); index++) {
			board.add(new Score("Name" + index, index));
		}

		int expect = 10;
		assertEquals(expect, board.getHighScores().size());
	}
}
