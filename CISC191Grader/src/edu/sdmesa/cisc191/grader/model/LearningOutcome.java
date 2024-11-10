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
 * Recording a level of achievement for a Learning Outcome.
 */
public enum LearningOutcome
{
	LO1("Employ design principles of object oriented programming"),
	LO2("Construct programs utilizing single and multidimensional arrays"),
	LO3("Construct programs utilizing objects and classes in object-oriented programming"),
	LO4("Construct programs utilizing inheritance and polymorphism"),
	LO5("Construct programs utilizing generic collections and data structures"),
	LO6("Construct programs utilizing graphical user interfaces with event-driven programming"),
	LO7("Construct programs utilizing exception handling"),
	LO8("Construct programs utilizing text file I/O"),
	LO9("Construct programs utilizing recursion"),
	LO10("Construct programs utilizing multiple threads");
	
	// A learning outcome has a title for presentation
	private final String title;
	// A learning outcome has an level of achievement
	private Achievement achievement;
	
	LearningOutcome(String initialTitle)
	{
		title = initialTitle;
		setAchievement(Achievement.NOT_YET);
	}

	public String getTitle() 
	{
		return title;
	}

	public Achievement getAchievement() 
	{
		return achievement;
	}

	public void setAchievement(Achievement newAchievement) 
	{
		achievement = newAchievement;
	}
	
	

}
