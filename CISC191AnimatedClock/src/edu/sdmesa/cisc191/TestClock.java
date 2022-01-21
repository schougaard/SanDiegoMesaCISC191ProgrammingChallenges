package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 2.0
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 */

class TestClock
{

	@Test
	void testClock() throws InterruptedException
	{
		Clock clock = new Clock();
		assertEquals("00:00", clock.getTime());
		Thread.sleep(1050);
		assertEquals("00:01", clock.getTime());
		Thread.sleep(1050);
		assertEquals("00:02", clock.getTime());
	}

	@Test
	void testClockPanel() throws InterruptedException
	{
		ClockPanel panel = new ClockPanel(Color.BLACK, Color.GREEN);
		panel.repaint();

		// Testing that the panel animates the clock
		int locationX = panel.getLocationX();
		int locationY = panel.getLocationY();
		Thread.sleep(1000 / 60 + 50);
		assertNotEquals(locationX, panel.getLocationX());
		assertNotEquals(locationY, panel.getLocationY());
		locationX = panel.getLocationX();
		locationY = panel.getLocationY();
		Thread.sleep(1000 / 60 + 50);
		assertNotEquals(locationX, panel.getLocationX());
		assertNotEquals(locationY, panel.getLocationY());
	}

	@Test
	void testMainWindow() throws InterruptedException
	{
		MainWindow window = new MainWindow();
		assertTrue(window.isVisible());
		window.repaint();

		// Testing that the program is still running
		Thread.sleep(1050);
		assertTrue(window.isVisible());
		Thread.sleep(1050);
		assertTrue(window.isVisible());
		Thread.sleep(1050);
		assertTrue(window.isVisible());
	}

}
