package cisc191.sdmesa.edu;

import javax.swing.JFrame;

/**
 * Lead Author(s):
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * 
 */

public class GoneFishingView extends JFrame
{

	/**
	 * TODO
	 * @param model
	 */
	public GoneFishingView(GoneFishingModel model)
	{
		// TODO

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * TODO
	 * @param args
	 */
	public static void main(String[] args)
	{
		new GoneFishingView(new GoneFishingModel());
	}

	/**
	 * TODO
	 */
	public void updateUI()
	{
		// TODO
	}
}
