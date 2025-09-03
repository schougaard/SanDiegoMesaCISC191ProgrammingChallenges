package edu.sdmesa.cisc191.model.mazegenerator;

import edu.sdmesa.cisc191.model.Location;
import edu.sdmesa.cisc191.model.Maze;
import edu.sdmesa.cisc191.model.cell.Cell;
import edu.sdmesa.cisc191.model.cell.Path;
import edu.sdmesa.cisc191.model.cell.Wall;

public class MazeGeneratorRandom extends MazeGenerator
{
	/**
	 * Generates a maze randomly. It's practically not a maze.
	 * 
	 * @param width  width of the maze
	 * @param height height of the maze
	 * @param seed   a random seed
	 * @return a Maze object
	 */
	public Maze generateMaze(int width, int height)
	{
		Cell[][] cells = new Cell[height][width];

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				cells[row][col] = (int) (Math.random() * 10) < 3
						? new Wall(new Location(row, col))
						: new Path(new Location(row, col));
			}
		}

		// Openings in the wall
		cells[Maze.entranceLocation.getRow()][Maze.entranceLocation
				.getColumn()] = new Path(Maze.entranceLocation);
		cells[Maze.exitLocation.getRow()][Maze.exitLocation
				.getColumn()] = new Path(Maze.exitLocation);

		Maze maze = new Maze(cells);

		return maze;
	}
}
