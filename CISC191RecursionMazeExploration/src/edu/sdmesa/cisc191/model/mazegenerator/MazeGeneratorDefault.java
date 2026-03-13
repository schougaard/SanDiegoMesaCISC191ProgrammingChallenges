package edu.sdmesa.cisc191.model.mazegenerator;

import edu.sdmesa.cisc191.model.Maze;

public class MazeGeneratorDefault extends MazeGenerator
{
	@Override
	public Maze generateMaze(int width, int height)
	{
		return new Maze();
	}
}
