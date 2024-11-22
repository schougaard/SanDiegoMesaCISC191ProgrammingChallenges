package edu.sdmesa.cisc191;

import java.awt.Color;

import edu.gatech.cc.DigitalPicture;
import edu.gatech.cc.Picture;
import edu.gatech.cc.Pixel;
/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 * Version/date:
 * 
 * Responsibilities of class:
 * 
 */
public class Logic
{


	/*
	 * Use the main method in this file to visually inspect the "filters" that you are
	 * applying to the image(s)! Please see the comment(s) for examples.
	 * 
	 */
	public static void main(String[] arg) {
		
		// Create a myPicture object from the provided file name. 
		// If you use your own image, be sure to place it in the images folder of this project 
		DigitalPicture myPicture = new Picture("bees.png");
		
		//Use the explore method of the object to view the picture.
		myPicture.explore();
		
		//Apply one of the filters then view the image again with explore!
		zeroBlue(myPicture); //<----- Change this to one of the other filters that you have written
		myPicture.explore();
		
	}
	
	
	
	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out. All
	 * other channels remain the same
	 * 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture)
	{

		//obtain a representation of the picture as a 2D array of Pixel objects
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//Traverse the 2D array
		for (int r = 0; r < pixel2D.length; r++)
		{
			for (int c = 0; c < pixel2D[r].length; c++)
			{
				//invoke the setBlue method on each Pixel object
				pixel2D[r][c].setBlue(0);
			}
		}
		
		

	}


//	/**
//	 * Alters the picture so that is is black and white by setting each pixels color value to be the average
//	 * of the pixels red, green, and blue channel. 
//	 * @param picture,  the image to be altered
//	 */
//	public static void ????(??? ???) {
//		
//		
//		
//	}

}
