package edu.sdmesa.cisc191;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
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
 * A ClockPanel shows an animated clock the bounces of the sides of the panel.
 */
public class ClockPanel extends JPanel implements ActionListener
{
	private final Font font = new Font("Ink Free", Font.BOLD, 20);
	private Color windowBackgroundColor;
	private Color clockColor;

	private int locationX = 100, locationY = 100;
	private int directionX = 1, directionY = 1;

	private int clockHeight;
	private int clockWidth;

	private Clock clock;
	
	// Student TODO: implement that a ClockPanel has-a Swing Timer
	// private ... ...;

	public ClockPanel(Color backgroundColor, Color clockColor)
	{
		this.windowBackgroundColor = backgroundColor;
		this.clockColor = clockColor;

		clock = new Clock();

		// Student TODO: create and start animation timer (using a Swing Timer) to update at 60 times per second (1000/60)

		
	}

	private void updateClockSize(Graphics g)
	{
		// calculate the clock height and width
		clockHeight = g.getFontMetrics().getAscent();
		clockWidth = g.getFontMetrics().stringWidth(clock.getTime());
	}

	private void moveClock()
	{
		// define the boundaries
		int rightWall = this.getWidth() - clockWidth;
		int leftWall = 0;
		int topWall = 0 + clockHeight;
		int bottomWall = this.getHeight();

		// Calculate a new location
		locationX = locationX + directionX;
		locationY = locationY + directionY;

		// if clock hits left wall or the right wall, change the x direction
		if (locationX <= leftWall || locationX >= rightWall)
		{
			directionX = -directionX;
		}

		// if clock hits top or bottom walls, change the y direction
		if (locationY >= bottomWall || locationY <= topWall)
		{
			directionY = -directionY;
		}
	}
	
	public int getLocationX()
	{
		return locationX;
	}

	public int getLocationY()
	{
		return locationY;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		// draw the windowBackgroundColor color
		g.setColor(windowBackgroundColor);
		g.fillRect(0, 0, getWidth(), getHeight());

		// draw the clock
		g.setFont(font);
		updateClockSize(g);
		g.setColor(clockColor);
		g.drawString(clock.getTime(), locationX, locationY);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Student TODO: Fill in the needed code to animate the clock. 

		
	}

}
