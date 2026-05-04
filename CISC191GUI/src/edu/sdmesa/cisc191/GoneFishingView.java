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
	 * Create GUI for game
	 * 
	 * @param goneFishingModel used to update the GUI
	 */
	public GoneFishingView(GoneFishingModel goneFishingModel)
	{
		// TODO: create and layout all the needed widgets with their listeners

		// In the end do:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * Update the GUI based on the data in the model
	 */
	public void updateGUI()
	{
		// TODO

	}
}
