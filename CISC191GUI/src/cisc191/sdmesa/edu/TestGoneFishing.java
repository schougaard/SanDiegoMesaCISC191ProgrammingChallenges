package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

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
