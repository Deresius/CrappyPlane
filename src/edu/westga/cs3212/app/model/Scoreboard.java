package edu.westga.cs3212.app.model;

import java.util.ArrayList;

/**
 * The Class HighScoreList.
 */
public class Scoreboard {

	public static final int MAX_SIZE = 10;
	private ArrayList<Score> highScores;

	/**
	 * Instantiates a new high score list.
	 */
	public Scoreboard() {
		this.highScores = new ArrayList<Score>();
		
		int score = 10000;
		
		for(int i = 0; i < MAX_SIZE ; i++ )
		{
			this.highScores.add(new Score("AAA", score));
			score -= 1000;
		}
		
		//while (this.highScores.size() < MAX_SIZE) {
			//this.highScores.add(new Score("", 0));
		//}
	}

	public int getMaxSize() {
		return MAX_SIZE;
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
	public void add(Score newScore) {
			this.highScores.add(newScore);
			this.highScores.sort(null);
			this.highScores.remove(this.highScores.size() - 1);
	}
}
