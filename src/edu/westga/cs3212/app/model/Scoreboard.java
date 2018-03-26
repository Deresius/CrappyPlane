package edu.westga.cs3212.app.model;

import java.util.ArrayList;

/**
 * The Class HighScoreList.
 */
public class Scoreboard {

	/** The high score collection. */
	private ArrayList<Score> highScoreCollection;

	/**
	 * Instantiates a new high score list.
	 */
	public Scoreboard() {
		this.highScoreCollection = new ArrayList<Score>();
	}

	/**
	 * Gets the high scores.
	 *
	 * @return the high scores
	 */
	public ArrayList<Score> getHighScores() {
		return this.highScoreCollection;
	}

	/**
	 * Adds the new highscore.
	 *
	 * @param highScore
	 *            the high score
	 * @return true, if successful
	 */
	public boolean add(Score highScore) {
		return this.highScoreCollection.add(highScore);
	}

	/**
	 * Removes a highscore.
	 *
	 * @param highscore
	 *            the highscore
	 * @return true, if successful
	 */
	public boolean remove(Score highscore) {
		return this.highScoreCollection.remove(highscore);
	}
}
