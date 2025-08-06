package edu.sdmesa.cisc191;

import java.awt.Color;
import edu.gatech.cc.DigitalPicture;
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
		Pixel[][] pixels2D = picture.getPixels2D();

		// Traverse the 2D array
		for (int row = 0; row < pixels2D.length; row++)
		{
			for (int col = 0; col < pixels2D[row].length; col++)
			{
				// invoke the setBlue method on each Pixel object
				pixels2D[row][col].setBlue(0);
			}
		}

	}
	
	/**
	 * Purpose: Make the picture black & white, and gray
	 * @param picture
	 */
	public static void blackAndWhite(DigitalPicture picture)
	{
		// TODO Implement this method

	}
	
	/**
	 * Purpose: Invert the colors of image
	 * @param picture
	 */
	public static void negative(DigitalPicture picture)
	{
		// TODO Implement this method

	}
	
	/**
	 * Purpose: Simulate that the picture was taken at sunset
	 * @param picture
	 * @param redMultiplier Factor increase of the red (usually > 1)
	 * @param greenBlueMultiplier Factor increase of green and blue (usually < 1)
	 */
	public static void makeSunset(DigitalPicture picture, double redMultiplier,
			double greenBlueMultiplier)
	{
		// TODO Implement this method

	}

	/**
	 * Purpose: Flip the image left to right (as used in many selfie cams)
	 * @param picture
	 */
	public static void flipHorizontal(DigitalPicture picture)
	{
		// TODO Implement this method
		
	}

	/**
	 * Purpose: Turn the picture up-side-down
	 * @param picture
	 */
	public static void flipVertical(DigitalPicture picture)
	{
		// TODO Implement this method

	}

	/**
	 * Purpose: Make the image less sharp
	 * @param picture
	 */
	public static void blur(DigitalPicture picture)
	{
		// TODO Implement this method

	}

	/*
	 * Use the main method in this file to visually inspect the "filters" that
	 * you are
	 * applying to the image(s)! Please see the comment(s) for examples.
	 */
//	public static void main(String[] arg)
//	{
//
//		// Create a myPicture object from the provided file name.
//		// If you use your own image, be sure to place it in the images folder
//		// of this project
//		DigitalPicture myPicture = new Picture("bees.png");
//		myPicture.setTitle("Original Image");
//
//		// Use the explore method of the object to view the picture.
//		myPicture.explore();
//
//		/*
//		 * Apply the filter then invoke explorer again to view the changes. :)
//		 * ---------------------------------------------------------------------
//		 * ---------------
//		 */
//
//		// Apply one of the filters then view the image again with explore!
//		zeroBlue(myPicture); // <----- Change this to one of the other filters
//								// that you have written
//		myPicture.setTitle("After Filter"); // change the title of the JFrame
//		myPicture.explore();
//
//	}

}
