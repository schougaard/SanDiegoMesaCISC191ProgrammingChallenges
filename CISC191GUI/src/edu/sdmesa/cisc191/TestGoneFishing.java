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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.*;

class TestGoneFishing
{

	@Test
	void testGoneFishingModel()
	{
		GoneFishingModel model = new GoneFishingModel();
		assertEquals(10, model.getFishRemaining());
		assertEquals(30, model.getTriesRemaining());
		assertFalse(model.fishWin());
		assertFalse(model.playerWins());
		assertFalse(model.isGameOver());
		
		model.fishAt(0, 0);
		assertTrue(model.getFishRemaining() >= 9);
		assertEquals(29, model.getTriesRemaining());
		assertFalse(model.fishWin());
		assertFalse(model.playerWins());
		assertFalse(model.isGameOver());
		
		model.fishAt(5, 5);
		assertTrue(model.getFishRemaining() >= 8);
		assertEquals(28, model.getTriesRemaining());
		assertFalse(model.fishWin());
		assertFalse(model.playerWins());
		assertFalse(model.isGameOver());
		
		// New model, fish 30 times
		model = new GoneFishingModel();
		for (int row = 0; row < 6; row++)
		{
			for (int column = 0; column < 5; column++)
			{
				if (!model.isGameOver())
				{
					model.fishAt(row, column);
				}
			}
		}
		
		assertTrue(model.getFishRemaining() >= 0);
		assertTrue(model.getTriesRemaining() >= 0);
		assertTrue(model.playerWins() || model.fishWin());
		assertTrue(model.isGameOver());
	}
	
	@Test
	void testFishingButton()
	{
		FishingButton button = new FishingButton(1, 2);
		assertEquals(1, button.getRow());
		assertEquals(2, button.getColumn());
	    button.reveal(true);
	    button.reveal(false);
		// Check that button can be clicked
		button.doClick();
	}
	
//	@Test
//	void testGoneFishingView()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView(model);
//		model.fishAt(0, 0);
//		view.updateGUI();
//	    assertTrue(view instanceof JFrame);
//	}
//
//	@Test
//	void testGoneFishingController()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView(model);
//		GoneFishingController controller = 
//				new GoneFishingController(model, view);
//		
//		controller.onFishingButtonClicked(new FishingButton(1, 2));
//		// There should be one less tries remaining
//		assertEquals(29, model.getTriesRemaining());
//		// There should be nine or ten fish remaining depending on whether we caught anything.
//		assertTrue(model.getFishRemaining() == 10 || model.getFishRemaining() == 9);
//	}
//	
//	@Test
//	void testGoneFishingButtonListener()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView(model);
//		GoneFishingController controller = 
//				new GoneFishingController(model, view);
//		FishingButton fishingButton = new FishingButton(1, 2);
//		FishingButtonListener listener = new FishingButtonListener(controller, fishingButton);
//		String buttonTextBefore = fishingButton.getText();
//		fishingButton.doClick();
//		// Button text should change
//		assertNotEquals(buttonTextBefore, fishingButton.getText());
//		// There should be one less tries remaining
//		assertEquals(29, model.getTriesRemaining());
//		// There should be nine or ten fish remaining depending on whether we caught anything.
//		assertTrue(model.getFishRemaining() == 10 || model.getFishRemaining() == 9);
//	}
//	
//	@Test
//	void testTriesAndFishRemaining()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView(model);
//		GoneFishingController controller = new GoneFishingController(model, view);
//		
//		int triesRemaining = model.getTriesRemaining();
//		
//		// Click each button if possible until we run out of tries
//		for (int i = 0; i < GoneFishingModel.DIMENSION; i++) 
//		{
//			for (int j = 0; j < GoneFishingModel.DIMENSION; j++) 
//			{
//				if (!model.isGameOver())
//				{
//					// Manually inject buttons with listeners
//					FishingButton button = new FishingButton(i, j);
//					FishingButtonListener listener = new FishingButtonListener(controller, button);
//					// Click a button, use a try
//					button.doClick();
//					triesRemaining--;
//					assertEquals(triesRemaining, model.getTriesRemaining());
//				}
//			}
//		}
//		
//		assertEquals(0, model.getTriesRemaining());
//		// There are at least six positions not checked,
//		// so there can be at most six fish left
//		assertTrue(model.getFishRemaining() <= 6);
//	}
//	
//	@Test
//	void testGoneFishingButtonShouldntBeClickedTwice()
//	{
//		GoneFishingModel model = new GoneFishingModel();
//		GoneFishingView view = new GoneFishingView(model);
//		GoneFishingController controller = new GoneFishingController(
//				model, view
//		);
//		
//		FishingButton fishingButton = new FishingButton(2, 1);
//		controller.registerListener(fishingButton);
//		
//		// Simulate a click
//		fishingButton.doClick();
//		int triesAfterFirstClick = model.getTriesRemaining();
//		// Simlate a click on the same button
//		fishingButton.doClick();
//		int triesAfterSecondClick = model.getTriesRemaining();
//		// Second click should not change anything
//		assertEquals(triesAfterFirstClick, triesAfterSecondClick);
//	}
}
