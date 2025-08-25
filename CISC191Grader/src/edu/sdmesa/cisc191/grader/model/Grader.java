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
 * Calculates grades based on level of achievements on learning outcomes.
 */
public class Grader 
{
	private final LearningOutcome[] learningOutcomes = LearningOutcome.values();

	public LearningOutcome[] getLearningOutcomes()  
	{
		return learningOutcomes;
	}
	
	private int[] calculateAchievementLevelCountTable()
	{
		int[] levelCountTable = new int[Achievement.values().length];
		
		for (LearningOutcome outcome : learningOutcomes)
		{
			levelCountTable[outcome.getAchievement().getlevel()]++;
		}
		
		return levelCountTable;
	}
	
	public int getLevel(Achievement achievement)
	{
		return calculateAchievementLevelCountTable()[achievement.getlevel()];
	}

	public String calculateCurrentGrade()
	{
		int[] levelCountTable = calculateAchievementLevelCountTable();
		int numberOfCompleted = 9 - levelCountTable[Achievement.NOT_YET.getlevel()];
		
		if (numberOfCompleted == 9)
		{
			return calculateFinalGrade();
		}
		else if (numberOfCompleted == 0)
		{
			return "Not yet";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] == numberOfCompleted)
		{
			return "A";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] + 
				levelCountTable[Achievement.MIDDLE_DEVELOPER.getlevel()] == numberOfCompleted)
		{
			return "B";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] + 
				levelCountTable[Achievement.MIDDLE_DEVELOPER.getlevel()] + 
				levelCountTable[Achievement.JUNIOR_DEVELOPER.getlevel()] == numberOfCompleted)
		{
			return "C";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] + 
				levelCountTable[Achievement.MIDDLE_DEVELOPER.getlevel()] + 
				levelCountTable[Achievement.JUNIOR_DEVELOPER.getlevel()] + 
				levelCountTable[Achievement.INTERN.getlevel()] >= 1)
		{
			return "D";
		}
		else
		{
			return "?";
		}
	}
	
	public String calculateFinalGrade()
	{
		int[] levelCountTable = calculateAchievementLevelCountTable();
		
		if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] >= 7 &&
			levelCountTable[Achievement.INTERN.getlevel()] == 0 &&
			levelCountTable[Achievement.NOT_YET.getlevel()] == 0)
		{
			return "A";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] + 
			     levelCountTable[Achievement.MIDDLE_DEVELOPER.getlevel()] >= 7 &&
				 levelCountTable[Achievement.INTERN.getlevel()] == 0 &&
				 levelCountTable[Achievement.NOT_YET.getlevel()] == 0)
		{
			return "B";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] + 
				 levelCountTable[Achievement.MIDDLE_DEVELOPER.getlevel()] + 
				 levelCountTable[Achievement.JUNIOR_DEVELOPER.getlevel()] >= 9)
		{
			return "C";
		}
		else if (levelCountTable[Achievement.SENIOR_DEVELOPER.getlevel()] + 
				 levelCountTable[Achievement.MIDDLE_DEVELOPER.getlevel()] + 
				 levelCountTable[Achievement.JUNIOR_DEVELOPER.getlevel()] + 
				 levelCountTable[Achievement.INTERN.getlevel()] >= 5)
		{
			return "D";
		}
		else
		{
			return "Not yet";
		}
	}

}
