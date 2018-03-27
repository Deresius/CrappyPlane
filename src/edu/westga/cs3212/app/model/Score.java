package edu.westga.cs3212.app.model;

/**
 * The Class HighScore.
 */
public class Score implements Comparable<Score>{

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
		if (playersName == null) {
			throw new IllegalArgumentException("Must enter a name.");
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

	@Override
	public int compareTo(Score score) {
		if (this.score < score.getScore()) {
			return 1;
		}
		else if (this.score == score.getScore()) {
			return 0;
		}
		else {
			return -1;
		}
	}

	

}
