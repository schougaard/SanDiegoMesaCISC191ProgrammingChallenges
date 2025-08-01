package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import edu.gatech.cc.Picture;
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

public class Tests
{
	
	/**
	 * Run main to see images in failed tests. Use: Run As -> Java Application
	 * @param args
	 */
	public static void main(String[] args)
	{
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
				.request()
				.selectors(DiscoverySelectors.selectClass(Tests.class)).build();

		Launcher launcher = LauncherFactory.create();

		// Listener for live test logging
		TestResultListener liveListener = new TestResultListener();
		launcher.registerTestExecutionListeners(liveListener);

		// Listener for summary stats (including success count)
		SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(summaryListener);

		// Run tests
		launcher.execute(request);

		// Output summary
		TestExecutionSummary summary = summaryListener.getSummary();

		System.out.println("------------------------------------------------");
		System.out.println(
				"Number of tests found     : " + summary.getTestsFoundCount());
		System.out.println("Number of tests succeeded : "
				+ summary.getTestsSucceededCount());
		System.out.println(
				"Number of tests failed    : " + summary.getTestsFailedCount());
		System.out.println("Number of tests skipped   : "
				+ summary.getTestsSkippedCount());
		System.out.println("------------------------------------------------");

		if (!summary.getFailures().isEmpty())
		{
			System.out.println("Failures:");
			summary.getFailures()
					.forEach(failure -> System.out.println(" - "
							+ failure.getTestIdentifier().getDisplayName()
							+ ": " + failure.getException().getMessage()));
		}
	}

	/**
	 * Check to see if the blue value of each pixel in an image has been set to
	 * 0
	 */
	@Test
	public void testZeroBlue()
	{
		/* Create two identical Picture objects from the same picture */
		Picture studentPicture = new Picture("bees.png");
		Picture expectedPicture = new Picture("beesZeroBlue.png");

		/* apply the filter to the Picture in-place (mutating) */
		Logic.zeroBlue(studentPicture);

		// the resulting student image should be pixel by pixel equivalent to
		// the expectedPicture image
		assertEqualImages(expectedPicture, studentPicture);
	}

	/*
	 * Checks to see if BW is applied to image by taking the average of all the
	 * pixels colors (red, green, blue) and see it that to be the value of each
	 * color channel
	 */
	@Test
	public void testBlackAndWhite()
	{

		/* Create two identical Picture objects from the same picture */
		Picture studentPicture = new Picture("bees.png");
		Picture expectedPicture = new Picture("beesBlackAndWhite.png");

		/* apply the filter */
		Logic.blackAndWhite(studentPicture);

		// the resulting student image should be pixel by pixel equivalent to
		// the expectedPicture image
		assertEqualImages(expectedPicture, studentPicture);
	}

//	/*
//	 * Check to see if student code creates a negative of the original image
//	 */
//	@Test
//	public void testNegative()
//	{
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("bees.png");
//		Picture expectedPicture = new Picture("beesNegative.png");
//
//		/* apply the filter */
//		Logic.negative(studentPicture);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEqualImages(expectedPicture, studentPicture);
//	}
//
//	/*
//	 * See canvas for more details on applying sunset tone to a picture
//	 */
//	@Test
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
//		assertEqualImages(expectedPicture, studentPicture);
//	}
//
//	/*
//	 * Checks to see if the image was flipped horizontally
//	 */
//	@Test
//	void testFlipHorizontal()
//	{
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("fireFall.png");
//		Picture expectedPicture = new Picture("fireFallFlipHorizontal.png");
//
//		/* apply the filter */
//		Logic.flipHorizontal(studentPicture);
//		
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEqualImages(expectedPicture, studentPicture);
//	}
//
//	/*
//	 * Checks to see if the image was flipped vertically
//	 */
//	@Test
//	public void testFlipVertical()
//	{
//
//		/* Create two identical Picture objects from the same picture */
//		Picture studentPicture = new Picture("fireFall.png");
//		Picture expectedPicture = new Picture("fireFallFlipVertical.png");
//
//		/* apply the filter */
//		Logic.flipVertical(studentPicture);
//
//		// the resulting student image should be pixel by pixel equivalent to
//		// the expectedPicture image
//		assertEqualImages(expectedPicture, studentPicture);
//	}
//
//	/*
//	 * Tests to see if blurring works for a 2x2 rectangular window.
//	 */
//	@Test
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
//		assertEqualImages(expectedPicture, studentPicture);
//	}
	
	private static void assertEqualImages(Picture expectedPicture, Picture studentPicture) 
	{
		Pixel[][] expectedPixels = expectedPicture.getPixels2D();
		Pixel[][] studentPixels = studentPicture.getPixels2D();
		assertEquals(expectedPixels.length, studentPixels.length, "Row length different");
		//visit every row
		for(int row = 0; row < expectedPixels.length; row++)
		{
			assertEquals(expectedPixels[row].length, studentPixels[row].length, "Column length different");
			//visit every column in the row
			for(int col = 0; col < expectedPixels[row].length; col++)
			{
				//Pixel values of student and solution should be the same
				assertEquals(expectedPixels[row][col].getColor(), studentPixels[row][col].getColor(), "Picture pixel at: " + row + "," + col);
			}
		}
	}
	


}
