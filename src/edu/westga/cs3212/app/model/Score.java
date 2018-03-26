package edu.westga.cs3212.app.model;

/**
 * The Class HighScore.
 */
public class Score {

	/** The players name. */
	private String playersName;

	/** The score. */
	private int score;

	/**
	 * Instantiates a new high score.
	 *
	 * @param playersName
	 *            the players name
	 * @param score
	 *            the score
	 */
	public Score(String playersName, int score) {
		if (playersName == null || playersName == "") {
			throw new IllegalArgumentException("Must enter a name.");
		}
		if (score <= 0) {
			throw new IllegalArgumentException("Must have a positive score.");
		}

		this.playersName = playersName;
		this.score = score;
	}

	/**
	 * Gets the players name.
	 *
	 * @return the players name
	 */
	public String getPlayersName() {
		return playersName;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

}
