package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * @author Tasha Frankie
 * @author Allan Schougaard 
 * 
 * Other contributors:
 * None
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

class TestGoneFishing
{

	@Test
	void testGoneFishingButton()
	{
		FishingButton button = new FishingButton(1, 2);
		assertEquals(1, button.getRow());
		assertEquals(2, button.getColumn());
	}
	
//	@Test
//	void testGoneFishingView()
//	{
//		GoneFishingModel goneFishingModel = new GoneFishingModel();
//		GoneFishingView goneFishingView = new GoneFishingView(goneFishingModel);
//		goneFishingView.updateUI();
//		goneFishingModel.fishAt(0, 0);
//		goneFishingView.updateUI();
//	}

//	@Test
//	void testGoneFishingButtonListener()
//	{
//		GoneFishingModel goneFishingModel = new GoneFishingModel();
//		GoneFishingView goneFishingView = new GoneFishingView(goneFishingModel);
//		FishingButton fishingButton = new FishingButton(1, 2);
//		FishingButtonListener listener = new FishingButtonListener(goneFishingModel, goneFishingView, fishingButton);
//		String buttonTextBefore = fishingButton.getText();
//		listener.actionPerformed(null);
//		// Button text should change
//		assertNotEquals(buttonTextBefore, fishingButton.getText());
//		// There should be one less tries remaining
//		assertEquals(29, goneFishingModel.getTriesRemaining());
//		// There should be nine or ten fish remaining depending on whether we caught anything.
//		assertTrue(goneFishingModel.getFishRemaining() == 10 || goneFishingModel.getFishRemaining() == 9);
//	}

}
