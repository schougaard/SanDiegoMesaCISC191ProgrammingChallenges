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
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class:
 * 
 */
public class Logic
{

	/*
	 * Use the main method in this file to visually inspect the "filters" that
	 * you are
	 * applying to the image(s)! Please see the comment(s) for examples.
	 */
	public static void main(String[] arg)
	{

		// Create a myPicture object from the provided file name.
		// If you use your own image, be sure to place it in the images folder
		// of this project
		DigitalPicture myPicture = new Picture("bees.png");
		myPicture.setTitle("Original Image");

		// Use the explore method of the object to view the picture.
		myPicture.explore();

		/*
		 * Apply the filter then invoke explorer again to view the changes. :)
		 * ---------------------------------------------------------------------
		 * ---------------
		 */

		// Apply one of the filters then view the image again with explore!
		zeroBlue(myPicture); // <----- Change this to one of the other filters
								// that you have written
		myPicture.setTitle("After Filter"); // change the title of the JFrame
		myPicture.explore();

	}

	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out.
	 * All
	 * other channels remain the same
	 * 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture)
	{

		// obtain a representation of the picture as a 2D array of Pixel objects
		Pixel[][] pixel2D = picture.getPixels2D();

		// Traverse the 2D array
		for (int row = 0; row < pixel2D.length; row++)
		{
			for (int col = 0; col < pixel2D[row].length; col++)
			{
				// invoke the setBlue method on each Pixel object
				pixel2D[row][col].setBlue(0);
			}
		}

	}

	public static void blur(DigitalPicture studentSol)
	{
		// TODO Auto-generated method stub

	}

	public static void flipHorizontal(DigitalPicture studentSol)
	{
		// TODO Auto-generated method stub
		studentSol.getPixels2D();
	}

	public static void flipVertical(DigitalPicture studentSol)
	{
		// TODO Auto-generated method stub

	}

	public static void negative(DigitalPicture studentSol)
	{
		// TODO Auto-generated method stub

	}

	public static void blackAndWhite(DigitalPicture studentSol)
	{
		// TODO Auto-generated method stub

	}

	public static void makeSunset(DigitalPicture studentSol, double d, double e)
	{
		// TODO Auto-generated method stub

	}

}
