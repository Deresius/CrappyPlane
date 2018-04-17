package edu.westga.cs3212.app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.app.model.Level;

class TestLevelUpdateLevel {

	private Level level;

	@BeforeEach
	void setUp() throws Exception {
		this.level = new Level();
		this.level.initLevel();
	}

	@Test
	final void testCloudsMoved() {
		double startLocation = this.level.getClouds().get(0).getX();
		this.level.updateLevel();
		double nextLocation = this.level.getClouds().get(0).getX();
		assertNotEquals(startLocation, nextLocation, "Cloud did not move");
	}

	@Test
	final void testGroundMoved() {
		double startLocation = this.level.getGround().get(0).getX();
		this.level.updateLevel();
		double nextLocation = this.level.getGround().get(0).getX();
		assertNotEquals(startLocation, nextLocation, "Ground did not move");
	}

	@Test
	final void testObstaclesMoved() {
		double startLocation = this.level.getObstacles().get(0).getX();
		this.level.updateLevel();
		double nextLocation = this.level.getObstacles().get(0).getX();
		assertNotEquals(startLocation, nextLocation, "Obstacle did not move");
	}
	
	@Test
	final void testPlaneMoved() {
		double startLocation = this.level.getPlane().getY();
		this.level.setVisible(true);
		this.level.updateLevel();
		double nextLocation = this.level.getPlane().getY();
		assertNotEquals(0, (startLocation - nextLocation));
	}

	@Test
	final void testDistanceChanged() {
		double startDistance = this.level.getDistance();
		this.level.setStarted(true);
		this.level.updateLevel();
		double nextDistance = this.level.getDistance();
		assertTrue(startDistance < nextDistance, "Distance did not change");
	}

}
