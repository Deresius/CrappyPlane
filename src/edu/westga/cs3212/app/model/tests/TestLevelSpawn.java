package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

class TestLevelSpawn {
	
	private Level level;

	@BeforeEach
	void setUp() throws Exception {
		this.level = new Level();
		this.level.initLevel();
		this.level.setStarted(true);
	}

	@Test
	final void testSpawnNewObstacle() {
		int firstSize = this.level.getObstacles().size();
		this.level.updateLevel();
		while ((this.level.getDistance() % this.level.getObstacleSpawnFrequency()) != 0) {
			this.level.updateLevel();
		}
		int nextSize = this.level.getObstacles().size();
		assertNotEquals(0, (firstSize - nextSize));
	}
	
	
	@Test
	final void testSpawnNewCloud() {
		int firstSize = this.level.getClouds().size();
		this.level.updateLevel();
		while ((this.level.getDistance() % this.level.getCloudSpawnFrequency()) != 0) {
			this.level.updateLevel();
		}
		int nextSize = this.level.getClouds().size();
		assertNotEquals(0, (firstSize - nextSize));
	}

}
