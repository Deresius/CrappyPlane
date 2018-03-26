package edu.westga.cs3212.app.model;

import java.util.ArrayList;

/**
 * The Class HighScoreList.
 */
public class Scoreboard {

	private static final int MAX_SIZE = 10;
	private ArrayList<Score> highScores;

	/**
	 * Instantiates a new high score list.
	 */
	public Scoreboard() {
		this.highScores = new ArrayList<Score>();
		while (this.highScores.size() < MAX_SIZE) {
			this.highScores.add(new Score("", 0));
		}
	}

	/**
	 * Gets the high scores.
	 *
	 * @return the high scores
	 */
	public ArrayList<Score> getHighScores() {
		return this.highScores;
	}

	/**
	 * Adds the new highscore if it is worthy
	 *
	 * @param highScore
	 *            the high score
	 * 
	 * @return true, if successful
	 */
	public boolean add(Score newScore) {
		int index = this.highScores.size() - 1;
		Score current = this.highScores.get(index);
		if (current.getScore() > newScore.getScore()) {
			while (current.getScore() < newScore.getScore()) {
				current = this.highScores.get(index);
			}
			this.highScores.add(index, newScore);
			if (this.highScores.size() > MAX_SIZE) {
				this.highScores.remove(this.highScores.size() - 1);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes a highscore.
	 *
	 * @param highscore
	 *            the highscore
	 * @return true, if successful
	 */
	public boolean remove(Score highscore) {
		return this.highScores.remove(highscore);
	}
}
