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
 * @version 2025.01.25.001
 * 
 * Responsibilities of class:
 * Test the function of Logic.java
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 public class Tests
{

	 /**
	  * Check to see if the blue value of each pixel in an image has been set to 0
	  */
	 @Test
	 @Order(1)
	 public void testZeroBlue()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("bees.png");
	     Picture solution = new Picture("beesZeroBlue.png");

	     /* apply the filter */
	     Logic.zeroBlue(studentSol);
   

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Zero Blue");
	         fail("Images do not match - check the GUI comparison");
	     }
	     
	 }

	 @Test
	 @Order(2)
	 public void testBlackAndWhite()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("bees.png");
	     Picture solution = new Picture("beesBlackAndWhite.png");

	     /* apply the filter */
	     Logic.blackAndWhite(studentSol);

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Black and White");
	         fail("Images do not match - check the GUI comparison");
	     }
	 }

	 @Test
	 @Order(3)
	 public void testNegative()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("bees.png");
	     Picture solution = new Picture("beesNegative.png");

	     /* apply the filter */
	     Logic.negative(studentSol);

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Negative");
	         fail("Images do not match - check the GUI comparison");
	     }
	 }

	 @Test
	 @Order(4)
	 public void testMakeSunset()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("fireFall.png");
	     Picture solution = new Picture("fireFallMakeSunset.png");

	     /* apply the filter */
	     Logic.makeSunset(studentSol, 1.5, .9);

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Make Sunset");
	         fail("Images do not match - check the GUI comparison");
	     }
	 }

	 @Test
	 @Order(5)
	 void testFlipHorizontal()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("fireFall.png");
	     Picture solution = new Picture("fireFallFlipHorizontal.png");

	     /* apply the filter */
	     Logic.flipHorizontal(studentSol);

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Flip Horizontal");
	         fail("Images do not match - check the GUI comparison");
	     }
	 }

	 @Test
	 @Order(6)
	 public void testFlipVertical()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("fireFall.png");
	     Picture solution = new Picture("fireFallFlipVertical.png");

	     /* apply the filter */
	     Logic.flipVertical(studentSol);

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Flip Vertical");
	         fail("Images do not match - check the GUI comparison");
	     }
	 }

	 @Test
	 @Order(7)
	 public void testBlur()
	 {
	     /* Create two identical Picture objects from the same picture */
	     Picture studentSol = new Picture("fireFall.png");
	     Picture solution = new Picture("fireFallBlur.png");

	     /* apply the filter */
	     Logic.blur(studentSol);

	     //the resulting student image should be pixel by pixel equivalent to the solution image
	     if (!studentSol.equals(solution)) {
	         showGUIAndWait(studentSol, solution, "Blur");
	         fail("Images do not match - check the GUI comparison");
	     }
	 }

	 /**
	  * Helper method to show GUI and wait for user to close it
	  */
	 private void showGUIAndWait(Picture studentImage, Picture solutionImage, String filterName) {

	     
	     // a trick - system in will force test to wait
	     try {
		     PipedOutputStream out = new PipedOutputStream();
		     PipedInputStream in = new PipedInputStream(out);
		     System.setIn(in);  

		     SwingUtilities.invokeLater(() -> {
		    	 String title = "FAILED - [" + filterName + "] Comparison (Expected vs Your Result)";
		         PictureExplorer explorer = new PictureExplorer(solutionImage, studentImage, out, title);
		         System.out.println("GUI displayed. Close the window when you're done examining the differences.");
		   	 });
		     
		     // In another thread or class:
	         System.in.read();
		     System.out.println("Images don't match! Opening GUI for comparison: " + filterName);

	     } catch (Exception e) {
	    	 //You must pass the filters one-by-one. 
	    	 System.err.println("Error reading input: " + e.getMessage());
	     }
	     
 	 }
	

}
