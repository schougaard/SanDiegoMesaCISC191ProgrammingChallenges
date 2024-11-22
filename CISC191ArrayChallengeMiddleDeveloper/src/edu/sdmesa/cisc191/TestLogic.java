package edu.sdmesa.cisc191;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import edu.gatech.cc.Picture;
import edu.gatech.cc.PictureExplorer;
import edu.gatech.cc.Pixel;

/**
 * Lead Author(s):
 * 
 * @author Dom David
 * 
 * Other contributors:
 * 
 * Allan Schougaard
 * 
 * References:
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 * 
 * Version/date 1.0
 * 
 * Responsibilities of class:
 * Test the function of Logic.java
 * 
 */

public class TestLogic
{

	
	/**
	 * Check to see if the blue value of each pixel in an image has been set to 0
	 */
	@Test
	void testZeroBlue()
	{

		/* Create two identical Picture objects from the same picture */
		Picture studentSol = new Picture("bees.png");
		Picture solution = new Picture("beesZeroBlue.png");

		/* apply the filter */
		Logic.zeroBlue(studentSol);
 
		/* obtain the 2D Pixel array representation for both objects */
		Pixel[][] pixelsStudentSol	= studentSol.getPixels2D(); 	// student code
		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image

		//visit every row
		for(int row = 0; row < pixelsStudentSol.length; row++)
		{
			//visit every column in the row
			for(int col = 0; col < pixelsStudentSol[row].length; col++)
			{
				//Pixel values of student and solution should be the same
				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
			}
		}

	}

//	/*
//	 * Checks to see if BW is applied to image by taking the average of all the
//	 * pixels colors (red, green, blue) and see it that to be the value of each
//	 * color channel
//	 */
//	@Test
//	void testBW()
//	{
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentSol = new Picture("bees.png");
//		Picture solution = new Picture("beesBlackAndWhite.png");
//
//		/* apply the filter */
//		Logic.blackAndWhite(studentSol);
// 
//		/* obtain the 2D Pixel array representation for both objects */
//		Pixel[][] pixelsStudentSol	= studentSol.getPixels2D(); 	// student code
//		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image
//
//		//visit every row
//		for(int row = 0; row < pixelsStudentSol.length; row++)
//		{
//			//visit every column in the row
//			for(int col = 0; col < pixelsStudentSol[row].length; col++)
//			{
//				//Pixel values of student and solution should be the same
//				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
//			}
//		}
//
//
//	}
//
//	/*
//	 * Check to see if student code creates a negative of the original image
//	 */
//	@Test
//	void testNegative()
//	{
//
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentSol = new Picture("bees.png");
//		Picture solution = new Picture("beesNegative.png");
//
//		/* apply the filter */
//		Logic.negative(studentSol);
// 
//		/* obtain the 2D Pixel array representation for both objects */
//		Pixel[][] pixelsStudentSol	= studentSol.getPixels2D(); 	// student code
//		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image
//
//		//visit every row
//		for(int row = 0; row < pixelsStudentSol.length; row++)
//		{
//			//visit every column in the row
//			for(int col = 0; col < pixelsStudentSol[row].length; col++)
//			{
//				//Pixel values of student and solution should be the same
//				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
//			}
//		}
//
//	}
//	
//	
//	
//
//	/*
//	 * See canvas for more details on applying sunset tone to a picture
//	 */
//	@Test
//	void testSunset()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentSol = new Picture("fireFall.png");
//		Picture solution = new Picture("fireFallMakeSunset.png");
//
//		/* apply the filter */
//		Logic.makeSunset(studentSol, 1.5, .9);
// 
//		/* obtain the 2D Pixel array representation for both objects */
//		Pixel[][] pixelsStudentSol	= studentSol.getPixels2D(); 	// student code
//		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image
//
//		//visit every row
//		for(int row = 0; row < pixelsStudentSol.length; row++)
//		{
//			//visit every column in the row
//			for(int col = 0; col < pixelsStudentSol[row].length; col++)
//			{
//				//Pixel values of student and solution should be the same
//				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
//			}
//		}
//
//	}
//
//	/*
//	 * Checks to see if the image was flipped horizontally
//	 */
//	@Test
//	void testFlipHor()
//	{
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentSol = new Picture("fireFall.png");
//		Picture solution = new Picture("fireFallFlipHorizontal.png");
//
//		/* apply the filter */
//		Logic.flipHorizontal(studentSol);
// 
//		/* obtain the 2D Pixel array representation for both objects */
//		Pixel[][] pixelsStudentSol	= studentSol.getPixels2D(); 	// student code
//		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image
//
//		//visit every row
//		for(int row = 0; row < pixelsStudentSol.length; row++)
//		{
//			//visit every column in the row
//			for(int col = 0; col < pixelsStudentSol[row].length; col++)
//			{
//				//Pixel values of student and solution should be the same
//				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
//			}
//		}
//		
//	}
//
//	/*
//	 * Checks to see if the image was flipped vertically
//	 */
//	@Test
//	void testFlipVer()
//	{
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentSol = new Picture("fireFall.png");
//		Picture solution = new Picture("fireFallFlipVertical.png");
//
//		/* apply the filter */
//		Logic.flipVertical(studentSol);
// 
//		/* obtain the 2D Pixel array representation for both objects */
//		Pixel[][] pixelsStudentSol = studentSol.getPixels2D(); 		// student code
//		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image
//
//		//visit every row
//		for(int row = 0; row < pixelsStudentSol.length; row++)
//		{
//			//visit every column in the row
//			for(int col = 0; col < pixelsStudentSol[row].length; col++)
//			{
//				//Pixel values of student and solution should be the same
//				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
//			}
//		}
//	}
//
//	/*
//	 * Tests to see if blurring works for a 2x2 rectangular window.
//	 */
//	@Test
//	void testBlur()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentSol = new Picture("fireFall.png");
//		Picture solution = new Picture("fireFallBlur.png");
//
//		/* apply the filter */
//		Logic.blur(studentSol);
// 
//		/* obtain the 2D Pixel array representation for both objects */
//		Pixel[][] pixelsStudentSol	= studentSol.getPixels2D(); 	// student code
//		Pixel[][] pixelsFilteredSol = solution.getPixels2D(); 		// filtered image
//
//		//visit every row
//		for(int row = 0; row < pixelsStudentSol.length; row++)
//		{
//			//visit every column in the row
//			for(int col = 0; col < pixelsStudentSol[row].length; col++)
//			{
//				//Pixel values of student and solution should be the same
//				assert(pixelsStudentSol[row][col].getColor().equals(pixelsFilteredSol[row][col].getColor()));
//			}
//		}
//	}



}
