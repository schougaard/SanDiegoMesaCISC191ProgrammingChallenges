package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * 
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 *         Other contributors:
 *         Alex Chow
 * 
 *         Responsibilities of class:
 * 	       Virtually model the data of the game
 */

import java.util.Random;

// DIRECTIONS: Comment this code

// TODO: comment each method and each line of code to show you understand how it
// works

public class GoneFishingModel
{
	// TODO: comment the code
	
	public static final int DIMENSION = 6;
	private boolean[][] fishGrid = new boolean[DIMENSION][DIMENSION];
	private int triesRemaining = 30;
	private int fishRemaining = 10;

	/**
	 * Creates a model for the game that tracks fish, tries and fish remaining
	 * and determines if the game is over.
	 */
	public GoneFishingModel()
	{
		// TODO: comment the code
		
		Random randomNumberGenerator = new Random();
		for (int fishCounter = 0; fishCounter < fishRemaining; fishCounter++)
		{
			int row, column;
			do
			{
				row = randomNumberGenerator.nextInt(DIMENSION);
				column = randomNumberGenerator.nextInt(DIMENSION);
			} while (fishGrid[row][column]);
			fishGrid[row][column] = true;
		}
	}

	/**
	 * Check to see if there is a fish at a given location
	 * 
	 * @param row the row of the location
	 * @param column the column of the location
	 * @return true if the there is a fish at the location; false if not.
	 */
	public boolean fishAt(int row, int column)
	{
		// TODO: comment the code
		
		if (isGameOver())
		{
			throw new IllegalStateException("You cannot fish after the game is over");
		}
		else
		{
			triesRemaining--;
			boolean foundFish = fishGrid[row][column];
			if (foundFish)
			{
				fishRemaining--;
			}
			return foundFish;
		}
	}

	/**
	 * @return the number of tries (clicks) the user has left
	 */
	public int getTriesRemaining()
	{
		// TODO: comment the code
		
		return triesRemaining;
	}

	/**
	 * @return the number of fish left the in the fame
	 */
	public int getFishRemaining()
	{
		// TODO: comment the code

		return fishRemaining;
	}

	/**
	 * Determines if the fish has won the game
	 * 
	 * @return true if the fish has own; false if not.
	 */
	public boolean fishWin()
	{
		// TODO: comment the code

		return triesRemaining == 0 && fishRemaining > 0;
	}

	/**
	 * Determines if the player has won the game
	 * 
	 * @return true if the player has won; false if not.
	 */
	public boolean playerWins()
	{
		// TODO: comment the code

		return fishRemaining == 0;
	}

	/**
	 * Determines if the game has ended.
	 * 
	 * @return true if the game is over; false if not.
	 */
	public boolean isGameOver()
	{
		// TODO: comment the code

		return fishWin() || playerWins();
	}
}
