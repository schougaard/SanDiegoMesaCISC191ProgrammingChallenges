package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import edu.gatech.cc.Picture;
import edu.gatech.cc.PictureExplorer;
import edu.gatech.cc.Pixel;

/**
 * Lead Author(s):
 * 
 * @author Dom David
 * 
 *         Other contributors:
 * 
 *         Allan Schougaard
 * 
 *         References:
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 * 
 * @version 2025.01.25.001
 * 
 *          Responsibilities of class:
 *          Test the function of Logic.java
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests
{

	/**
	 * Check to see if the blue value of each pixel in an image has been set to
	 * 0
	 */
	@Test
	@Order(1)
	public void testZeroBlue()
	{
		/* Create two identical Picture objects from the same picture */
		Picture studentPicture = new Picture("bees.png");
		Picture expectedPicture = new Picture("beesZeroBlue.png");

		/* apply the filter */
		Logic.zeroBlue(studentPicture);

		// the resulting student image should be pixel by pixel equivalent to
		// the expectedPicture image
		assertEquals(expectedPicture, studentPicture, "Zero Blue");
	}

	@Test
	@Order(2)
	public void testBlackAndWhite()
	{
		/* Create two identical Picture objects from the same picture */
		Picture studentPicture = new Picture("bees.png");
		Picture expectedPicture = new Picture("beesBlackAndWhite.png");

		/* apply the filter */
		Logic.blackAndWhite(studentPicture);

		// the resulting student image should be pixel by pixel equivalent to
		// the expectedPicture image
		assertEquals(expectedPicture, studentPicture, "Black and White");
	}

//	@Test
//	@Order(3)
//	public void testNegative()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("bees.png");
//		Picture expectedPicture = new Picture("beesNegative.png");
//
//		/* apply the filter */
//		Logic.negative(studentPicture);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEquals(expectedPicture, studentPicture, "Negative");
//	}
//
//	@Test
//	@Order(4)
//	public void testMakeSunset()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("fireFall.png");
//		Picture expectedPicture = new Picture("fireFallMakeSunset.png");
//
//		/* apply the filter */
//		Logic.makeSunset(studentPicture, 1.5, .9);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEquals(expectedPicture, studentPicture, "Make Sunset");
//	}
//
//	@Test
//	@Order(5)
//	void testFlipHorizontal()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("fireFall.png");
//		Picture expectedPicture = new Picture("fireFallFlipHorizontal.png");
//
//		/* apply the filter */
//		Logic.flipHorizontal(studentPicture);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEquals(expectedPicture, studentPicture, "Flip Horizontal");
//	}
//
//	@Test
//	@Order(6)
//	public void testFlipVertical()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("fireFall.png");
//		Picture expectedPicture = new Picture("fireFallFlipVertical.png");
//
//		/* apply the filter */
//		Logic.flipVertical(studentPicture);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEquals(expectedPicture, studentPicture, "Flip Vertical");
//	}
//
//	@Test
//	@Order(7)
//	public void testBlur()
//	{
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("fireFall.png");
//		Picture expectedPicture = new Picture("fireFallBlur.png");
//
//		/* apply the filter */
//		Logic.blur(studentPicture);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEquals(expectedPicture, studentPicture, "Blur");
//	}

	// //////// Private utility methods

	/**
	 * Purpose: Checks that the student picture is the same as the expected picture pixel by pixel
	 * @param expectedPicture
	 * @param studentPicture
	 * @param filterName Name of test/filter that is supposed to have been applied to the student picture
	 */
	private void assertEquals(Picture expectedPicture, Picture studentPicture,
			String filterName)
	{
		Pixel[][] expectedPixels = expectedPicture.getPixels2D();
		Pixel[][] studentPixels = studentPicture.getPixels2D();

		if (expectedPixels.length != studentPixels.length)
		{
			fail("Images do not match. Expected number of rows: "
					+ expectedPixels.length + ", actual number of rows: "
					+ studentPixels.length);
		}

		// visit every row
		for (int row = 0; row < expectedPixels.length; row++)
		{
			if (expectedPixels[row].length != studentPixels[row].length)
			{
				fail("Images do not match. For row number: " + row
						+ " expected number of columns: "
						+ expectedPixels[row].length
						+ ", actual number of columns: "
						+ studentPixels[row].length);
			}

			// visit every column in the row
			for (int col = 0; col < expectedPixels[row].length; col++)
			{
				// Pixel values of student and expectedPicture should be the
				// same
				if (!expectedPixels[row][col].getColor()
						.equals(studentPixels[row][col].getColor()))
				{
					showGUIAndWait(expectedPicture, studentPicture, filterName);
					fail("Images do not match. Pixel at row: " + row
							+ " column: " + col + " expected value: "
							+ expectedPixels[row][col].getColor()
							+ " Actual value: "
							+ studentPixels[row][col].getColor());
				}
			}
		}
	}

	/**
	 * Purpose: Show expected and student pictures side-by-side for visual comparison
	 * @param expectedPicture
	 * @param studentPicture
	 * @param filterName Name of test/filter that is supposed to have been applied to the student picture
	 */
	private void showGUIAndWait(Picture expectedPicture, Picture studentPicture,
			String filterName)
	{
		// a trick - system in will force test to wait
		try
		{
			PipedOutputStream out = new PipedOutputStream();
			PipedInputStream in = new PipedInputStream(out);
			System.setIn(in);

			SwingUtilities.invokeLater(() -> {
				String title = filterName + " Comparison";
				PictureExplorer explorer = new PictureExplorer(expectedPicture,
						studentPicture, out, title);
				System.out.println(
						"GUI displayed. Close the window when you're done examining the differences.");
			});

			// In another thread or class:
			System.in.read();

		}
		catch (Exception e)
		{
			// You must pass the filters one-by-one.
			System.err.println("Error reading input: " + e);
		}

	}

}
