package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * @author Tasha Frankie
 * @author Allan Schougaard 
 * 
 * Other contributors:
 * Alex Chow
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt, J. D., & Stein, C. (n.d.). 
 * JUnit 5 user guide. JUnit 5. 
 * https://junit.org/junit5/docs/current/user-guide/
 * 
 *  
 * Version/date: 2.0  
 * 
 * Responsibilities of class:
 * Test the Gone Fishing Game's non-visual implementation
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.*;

class TestGoneFishing
{

	@Test
	void testFishingButton()
	{
		FishingButton button = new FishingButton(1, 2);
		assertEquals(1, button.getRow());
		assertEquals(2, button.getColumn());
		assertTrue(button instanceof JButton);
	}
	
//	@Test
//	void testGoneFishingView()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView();
//		new GoneFishingController(model, view);
//		model.fishAt(0, 0);
//		view.updateUI();
//	    assertTrue(view instanceof JFrame);
//	}
//
//	@Test
//	void testGoneFishingButtonListener()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView();
//		GoneFishingController controller = 
//				new GoneFishingController(model, view);
//		FishingButton fishingButton = new FishingButton(1, 2);
//		FishingButtonListener listener = new FishingButtonListener(controller, fishingButton);
//		String buttonTextBefore = fishingButton.getText();
//		listener.actionPerformed(null);
//		// Button text should change
//		assertNotEquals(buttonTextBefore, fishingButton.getText());
//		// There should be one less tries remaining
//		assertEquals(29, model.getTriesRemaining());
//		// There should be nine or ten fish remaining depending on whether we caught anything.
//		assertTrue(model.getFishRemaining() == 10 || model.getFishRemaining() == 9);
//	    assertTrue(listener instanceof ActionListener);
//	}
//	
//	@Test
//	void testGoneFishingGetTriesAndFishRemaining()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView();
//		GoneFishingController controller = new GoneFishingController(
//				model, view
//		);
//		
//		int initialFishRemaining = model.getFishRemaining();
//		int triesRemaining = model.getTriesRemaining();
//		
//		assertEquals(initialFishRemaining, model.getFishRemaining());
//		
//		// click each button if possible until we run out of tries
//		for (int i = 0; i < GoneFishingModel.DIMENSION && !model.isGameOver(); i++) 
//		{
//			for (int j = 0; j < GoneFishingModel.DIMENSION && !model.isGameOver(); j++) 
//			{
//				// manually inject listeners
//				FishingButton button = new FishingButton(i, j);
//				FishingButtonListener listener = new FishingButtonListener(controller, button);
//				listener.actionPerformed(null);
//				assertEquals(--triesRemaining, model.getTriesRemaining());
//			}
//		}
//		
//		// If we have 0 tries remaining, we should have at most 6 fish
//		// remaining, assuming dimensions of 6 by 6.
//		assertTrue(model.getFishRemaining() <= 6);
//	}
//	
//	@Test
//	void testGoneFishingButtonShouldntBeClickedTwice()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView();
//		GoneFishingController controller = new GoneFishingController(
//				model, view
//		);
//		
//		FishingButton fishingButton = new FishingButton(2, 1);
//		controller.registerListener(fishingButton);
//		
//		// simulate a click
//		fishingButton.doClick();
//		int triesAfterFirstClick = model.getTriesRemaining();
//		
//		fishingButton.doClick();
//		int triesAfterSecondClick = model.getTriesRemaining();
//		
//		assertEquals(triesAfterFirstClick, triesAfterSecondClick);
//	}
}
