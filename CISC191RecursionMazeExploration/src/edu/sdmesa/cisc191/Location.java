package edu.sdmesa.cisc191;

public class Location
{
	private final int row;
	private final int column;
	
	public Location(int initRow, int initColumn)
	{
		if (initRow < 0 || initRow >= Maze.HEIGHT)
		{
			throw new IllegalArgumentException("Row must be between 0 and " + Maze.HEIGHT + "!");
		}
		
		if (initColumn < 0 || initColumn >= Maze.WIDTH)
		{
			throw new IllegalArgumentException("Column must be between 0 and " + Maze.WIDTH + "!");
		}
		
		row = initRow;
		column = initColumn;
	}

	public Location getLocationToRight()
	{
		return new Location(row, column + 1);
	}
	
	public Location getLocationToLeft()
	{
		return new Location(row, column - 1);
	}

	public Location getLocationAbove()
	{
		return new Location(row - 1, column);
	}
	
	public Location getLocationBelow()
	{
		return new Location(row + 1, column);
	}
	
	public int getRow()
	{
		return row;
	}

	public int getColumn()
	{
		return column;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Location)) return false;
		
		Location other = (Location)obj;
		
		return other.row == row && other.column == column;
	}
	
	@Override
	public String toString()
	{
		return "Location at row: " + row + ", column: " + column;
	}
}
