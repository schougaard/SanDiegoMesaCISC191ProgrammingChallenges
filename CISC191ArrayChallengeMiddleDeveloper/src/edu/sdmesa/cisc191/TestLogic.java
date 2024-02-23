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
		Picture studentSol = new Picture(PictureExplorer.imageFolderName + "bees.PNG");

		/* apply the zeroBlue filter */
		Logic.zeroBlue(studentSol);

		/* obtain the 2D Pixel array representation for both objects */
		Pixel[][] pixels = studentSol.getPixels2D(); // student code

		// the blue value of the pixels should be 0
		assertTrue(pixels[0][0].getBlue() == 0);
		assertTrue(pixels[pixels.length / 2][0].getBlue() == 0);
		assertTrue(pixels[pixels.length - 1][0].getBlue() == 0);

		// the other channels should not be changed
		assertTrue(pixels[0][0].getRed() != 0);
		assertTrue(pixels[pixels.length / 2][0].getRed() != 0);
		assertTrue(pixels[pixels.length - 1][0].getRed() != 0);

		// the other channels should not be changed
		assertTrue(pixels[0][0].getGreen() != 0);
		assertTrue(pixels[pixels.length / 2][0].getGreen() != 0);
		assertTrue(pixels[pixels.length - 1][0].getGreen() != 0);

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
//		// Create two Picture image objects using the same image file
//		Picture p = new Picture(PictureExplorer.imageFolderName + "bees.PNG");
//
//		// Apply the student code and solution code
//		Logic.blackAndWhite(p);
//
//		// obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//
//		// The red value of pixel should be the same as the average if BW has been
//		// applied properly
//		assertTrue(pixels[0][0].getRed() == pixels[0][0].getAverage());
//
//		// The red value of pixel should be the same as the average if BW has been
//		// applied properly
//		assertTrue(pixels[pixels.length / 2][0].getRed() == pixels[pixels.length / 2][0].getAverage());
//
//		// The red value of pixel should be the same as the average if BW has been
//		// applied properly
//		assertTrue(pixels[pixels.length - 1][0].getRed() == pixels[pixels.length - 1][0].getAverage());
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
//		// Create two Picture image objects using the same image file
//		Picture p = new Picture(PictureExplorer.imageFolderName + "bees.PNG"); // make sure you're using this image as the tester needs it
//
//		// Apply the student code and solution code
//		Logic.negative(p);
//
//		// obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//
//		// check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed() == 60);
//		assertTrue(pixels[50][0].getRed() == 40);
//		assertTrue(pixels[100][0].getRed() == 93);
//
//		// check blue of 3 different pixels
//		assertTrue(pixels[0][0].getGreen() == 125);
//		assertTrue(pixels[50][0].getGreen() == 101);
//		assertTrue(pixels[100][0].getGreen() == 167);
//
//		// check blue of 3 different pixels
//		assertTrue(pixels[0][0].getBlue() == 59);
//		assertTrue(pixels[50][0].getBlue() == 95);
//		assertTrue(pixels[100][0].getBlue() == 57);
//
//	}
//
//	/*
//	 * See canvas for more details on applying sunset tone to a picture
//	 */
//	@Test
//	void testSunset()
//	{
//		// Create two Picture image objects using the same image file
//		Picture p = new Picture(PictureExplorer.imageFolderName + "bees.PNG");
//
//		// Apply the student code and solution code
//		Logic.makeSunset(p, 1.5, .9);
//
//		// obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//
//		// check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed() == 255);
//		assertTrue(pixels[50][0].getRed() == 255);
//		assertTrue(pixels[100][0].getRed() == 243);
//
//		// check green
//		assertTrue(pixels[0][0].getGreen() == 117);
//		assertTrue(pixels[50][0].getGreen() == 138);
//		assertTrue(pixels[100][0].getGreen() == 79);
//
//		// check blue
//		assertTrue(pixels[0][0].getBlue() == 176);
//		assertTrue(pixels[50][0].getBlue() == 144);
//		assertTrue(pixels[100][0].getBlue() == 178);
//
//	}
//
//	/*
//	 * Checks to see if the image was flipped horizontally
//	 */
//	@Test
//	void testFlipHor()
//	{
//		// | __ \ | |
//		// | |__) |___ __ _ __| |
//		// | _ // _ \/ _` |/ _` |
//		// | | \ \ __/ (_| | (_| |
//		// |_| \_\___|\__,_|\__,_|
//		//
//		// The method name should be mirrorHorizontal and will Flip the image
//		// Horizontally or from left to right.
//
//		// Create two Picture image objects using the same image file
//		Picture p = new Picture(PictureExplorer.imageFolderName + "bees.PNG");
//		Picture original = new Picture(PictureExplorer.imageFolderName + "bees.PNG");
//
//		// Apply the student code and solution code
//		Logic.mirrorHorizontal(p);
//
//		Pixel[][] pixels = original.getPixels2D();
//		Pixel[][] solution = p.getPixels2D();
//
//		// The left-most and right-most pixel colors should be swapped if flipped was
//		// successful
//		// check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed() == solution[0][solution[0].length - 1].getRed());
//
//		// check green
//		assertTrue(pixels[0][0].getGreen() == solution[0][solution[0].length - 1].getGreen());
//
//		// check blue
//		assertTrue(pixels[0][0].getBlue() == solution[0][solution[0].length - 1].getBlue());
//
//		
//		// check all four corners
//		int top = 0;
//		int bottom = pixels.length-1;
//		int left = 0;
//		int right = pixels[0].length-1;
//		
//		assertTrue(compPixelColors(pixels[top][left], solution[top][right]));
//		assertTrue(compPixelColors(pixels[top][right], solution[top][left]));
//		assertTrue(compPixelColors(pixels[bottom][left], solution[bottom][right]));
//		assertTrue(compPixelColors(pixels[bottom][right], solution[bottom][left]));
//	}
//
//	/*
//	 * Checks to see if the image was flipped vertically
//	 */
//	@Test
//	void testFlipVer()
//	{
//
//		// _____ _
//		// | __ \ | |
//		// | |__) |___ __ _ __| |
//		// | _ // _ \/ _` |/ _` |
//		// | | \ \ __/ (_| | (_| |
//		// |_| \_\___|\__,_|\__,_|
//		//
//		// The method name should be mirrorVertical and will Flip the image Vertically
//		// (from top to bottom).
//
//		// Create two Picture image objects using the same image file
//		Picture p = new Picture(PictureExplorer.imageFolderName + "bees.PNG");
//		Picture p2 = new Picture(PictureExplorer.imageFolderName + "bees.PNG"); // original
//
//		// Apply the student code and solution code
//		Logic.mirrorVertical(p);
//
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D(); // original
//
//		// check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed() == pixels2[pixels2.length - 1][0].getRed());
//
//		// check green
//		assertTrue(pixels[0][0].getGreen() == pixels2[pixels2.length - 1][0].getGreen());
//
//		// check blue
//		assertTrue(pixels[0][0].getBlue() == pixels2[pixels2.length - 1][0].getBlue());
//
//		// check all four corners
//		int top = 0;
//		int bottom = pixels.length-1;
//		int left = 0;
//		int right = pixels[0].length-1;
//		
//		assertTrue(compPixelColors(pixels[top][left], pixels2[bottom][left]));
//		assertTrue(compPixelColors(pixels[bottom][left], pixels2[top][left]));
//		assertTrue(compPixelColors(pixels[top][right], pixels2[bottom][right]));
//		assertTrue(compPixelColors(pixels[bottom][right], pixels2[top][right]));
//	}
//
//	/*
//	 * Tests to see if blurring works for a 2x2 rectangular window.
//	 */
//	@Test
//	void testBlur()
//	{
//		// Create two Picture image objects using the same image file
//		Picture p = new Picture(PictureExplorer.imageFolderName + "bees.PNG");
//		Picture p2 = new Picture(PictureExplorer.imageFolderName + "bees.PNG"); // original
//
//		// Apply the student code and solution code
//		Logic.blur(p);
//
//		// obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D(); // original
//
//		// check that the formula was applied to a couple of pixels
//		int avgRed00 = (int) ((pixels2[0][0].getRed() + pixels2[1][0].getRed() + pixels2[0][1].getRed()
//				+ pixels2[1][1].getRed()) / 4.0);
//		assert (avgRed00 == pixels[0][0].getRed());
//
//		int avgRed01 = (int) ((pixels2[0][1].getRed() + pixels2[1][1].getRed() + pixels2[0][2].getRed()
//				+ pixels2[1][2].getRed()) / 4.0);
//		assert (avgRed01 == pixels[0][1].getRed());
//	}

	/**
	 * Helper method to check that the red, green, and blue channel values of two
	 * pixels are the same
	 * 
	 * @param a, the first Pixel object to check
	 * @param b, the second Pixel object to check
	 * @return true if two Pixel objects' red, green, and blue values are the same
	 */
	public boolean compPixelColors(Pixel a, Pixel b)
	{
		return a.getBlue() == b.getBlue() && a.getRed() == b.getRed() && a.getGreen() == b.getGreen();
	}

}
