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
	LO2("M2 Arrays"),
	LO3("M3 Beginning Classes"),
	LO4("M4 Advanced Classes"),
	LO5("M5 Generic Collections"),
	LO1("M6 Object Oriented Design"),
	LO6("M7 GUI"),
	LO7("M8 Exceptions"),
	LO8("M9 File I/O"),
	LO9("M10 Recursion");
	
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
