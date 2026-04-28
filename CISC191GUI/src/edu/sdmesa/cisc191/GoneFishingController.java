package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * 
 * @author
 * @author <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors: <<add additional contributors (mentors, tutors,
 *         friends) here, with contact information>>
 * 
 *         References: Morelli, R., & Walde, R. (2016). Java, Java, Java:
 *         Object-Oriented Problem Solving. Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class:
 * 
 */

public class GoneFishingController
{
	/**
	 * TODO
	 * 
	 * @param goneFishingModel
	 * @param goneFishingView
	 */
	public GoneFishingController(GoneFishingModel goneFishingModel,
			GoneFishingView goneFishingView)
	{
		// TODO: Initialize any instance variables/fields here

		// TODO: Hook up the view to the controller, and the controller should
		// tell view to update itself to reflect the current state of the model

	}

	/**
	 * Purpose: Handle the event of a fishing button being clicked.
	 * 
	 * @param button
	 */
	public void onFishingButtonClicked(FishingButton button)
	{
		// TODO: What should happen when a fishing button is clicked?
		// Hint: The controller manipulates the model and then tell the view to
		// update itself to reflect the current state of the model.

	}

	/**
	 * Purpose: Register the button with its own listener.
	 * 
	 * @param button
	 */
	public void registerListener(FishingButton button)
	{
		// TODO

	}

	public int getTriesRemaining()
	{
		// TODO
		return -1;
	}

	public int getFishRemaining()
	{
		// TODO
		return -1;
	}

	public boolean fishWin()
	{
		// TODO
		return false;
	}

	public boolean playerWins()
	{
		// TODO
		return false;
	}
}

// public class GoneFishingController
// {
// /**
// * TODO
// *
// * @param goneFishingModel
// * @param goneFishingView
// */
// public GoneFishingController(GoneFishingModel goneFishingModel,
// GoneFishingView goneFishingView)
// {
// // TODO
// }
//
// }
