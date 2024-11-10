package edu.sdmesa.cisc191.grader.model;

/**
 * Lead Author(s):
 * @author Allan Schougaard 
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Version/date: 2024-11
 * 
 * Responsibilities of class:
 * Recording a level of achievement, Intern, ... Senior developer.
 */
public enum Achievement 
{
	NOT_YET("Not yet", 0),
	INTERN("Intern", 1),
	JUNIOR_DEVELOPER("Junior developer", 2),
	MIDDLE_DEVELOPER("Middle developer", 3),
	SENIOR_DEVELOPER("Senior developer", 4);
	
	// An Achievement has-a description for display
	private final String description; 
	// An Achievement has-a a numerical level
	private final int level;
	
	Achievement(String initialName, int initialLevel)
	{
		description = initialName;
		level = initialLevel;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getlevel()
	{
		return level;
	}
	
	public String toString()
	{
		return description;
	}
	
} 
