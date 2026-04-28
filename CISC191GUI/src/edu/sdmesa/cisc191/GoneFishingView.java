package edu.sdmesa.cisc191;

import javax.swing.JFrame;

/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class:
 * 
 */

public class GoneFishingView extends JFrame
{
	/**
	 * TODO
	 * 
	 * @param model
	 */
	public GoneFishingView()
	{
		// TODO

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * TODO
	 * Hint: This will be called by the controller's constructor, when the
	 * controller object is created.
	 * 
	 * @param controller
	 */
	public void setController(GoneFishingController controller)
	{
		// TODO
		// Hint: On top of just setting the controller, you may also want to set
		// up any listeners for all the buttons here.

	}

	/**
	 * TODO
	 */
	public void updateUI()
	{
		// TODO

	}

	/**
	 * Starts the game
	 * 
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		GoneFishingModel model = new GoneFishingModel();
		GoneFishingView view = new GoneFishingView();

		// the view should be hooked up to the controller inside the
		// controller's constructor
		new GoneFishingController(model, view);
	}
}
