package edu.westga.cs3212.app.model;

import java.util.ArrayList;


/**
 * The Class HighScoreList.
 */
public class HighScores {

/** The high score collection. */
private ArrayList<HighScore> highScoreCollection;

/**
 * Instantiates a new high score list.
 */
public HighScores() {
	this.highScoreCollection = new ArrayList<HighScore>();
}

/**
 * Gets the high scores.
 *
 * @return the high scores
 */
public ArrayList<HighScore> getHighScores() {
	return this.highScoreCollection;
}

/**
 * Adds the new highscore.
 *
 * @param highScore the high score
 * @return true, if successful
 */
public boolean add(HighScore highScore) {
	return this.highScoreCollection.add(highScore);
}

/**
 * Removes a highscore.
 *
 * @param highscore the highscore
 * @return true, if successful
 */
public boolean remove(HighScore highscore) {
	return this.highScoreCollection.remove(highscore);
}
}
