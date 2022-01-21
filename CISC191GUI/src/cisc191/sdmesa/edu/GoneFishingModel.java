package cisc191.sdmesa.edu;

/**
 * Lead Author(s):
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 */

import java.util.Random;

public class GoneFishingModel
{
	public static int DIMENSION = 6;
	private boolean[][] grid = new boolean[DIMENSION][DIMENSION];
	private int triesRemaining = 30;
	private int fishRemaining = 10;

	public GoneFishingModel()
	{
		Random randomNumberGenerator = new Random();
		for (int fishCounter = 0; fishCounter < fishRemaining; fishCounter++)
		{
			int x, y;
			do
			{
				x = randomNumberGenerator.nextInt(DIMENSION);
				y = randomNumberGenerator.nextInt(DIMENSION);
			} while (grid[x][y]);
			grid[x][y] = true;
		}
	}

	public boolean fishAt(int row, int column)
	{
		boolean foundFish = grid[row][column];
		triesRemaining--;
		if (foundFish)
		{
			fishRemaining--;
		}

		return foundFish;
	}

	public int getTriesRemaining()
	{
		return triesRemaining;
	}

	public int getFishRemaining()
	{
		return fishRemaining;
	}

	public boolean fishWin()
	{
		return triesRemaining == 0 && fishRemaining > 0;
	}

	public boolean playerWins()
	{
		return fishRemaining == 0;
	}
}
