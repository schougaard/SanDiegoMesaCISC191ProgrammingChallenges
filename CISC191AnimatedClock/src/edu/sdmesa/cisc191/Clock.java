package edu.sdmesa.cisc191;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @otherContributors: None
 * @version 2.0
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 */

/**
 * The Clock class implements a clock that updates the time each second.
 */
public class Clock implements ActionListener
{
	private int counter = 0;

	public Clock()
	{
		// Student TODO: create and start a Swing Timer to update each second
		
	}

	/**
	 * Get the current time as a String
	 * @return Digital time, for instance, "00:00", "00:01", "00:02" etc.
	 */
	public String getTime()
	{
		String minutes = counter / 60 > 9 ? "" + counter / 60 : "0" + counter / 60;
		String seconds = counter % 60 > 9 ? "" + counter % 60 : "0" + counter % 60;
		return minutes + ":" + seconds;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Student TODO: update the clock
		
	}

}
