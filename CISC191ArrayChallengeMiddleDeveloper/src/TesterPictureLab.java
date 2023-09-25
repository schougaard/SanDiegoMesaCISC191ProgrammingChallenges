

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

public class TesterPictureLab {

	/**
	 * Check to see if the blue value of each pixel in an image has been set to 0
	 */
	@Test
	void testZeroBlue() {
		
		/* Create two identical Picture objects from the same picture */
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		/* apply the zeroBlue filter */
		Logic.zeroBlue(p);
 		
		/* obtain the 2D Pixel array representation for both objects */
		Pixel[][] pixels = p.getPixels2D();		//student code	
		Pixel[][] pixels2 = p2.getPixels2D();	//solution

		
		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(pixels[r][c].getBlue()!=0) {									//blue val should be 0
					p.explore();
					try {
						JOptionPane.showMessageDialog(null, "Found a non-zeroed blue value for a pixel. \n The picture should look less blue!");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fail("Found a pixel with a non-zeroed blue value");
					 
				}else if(pixels2[r][c].getRed()!=pixels[r][c].getRed()) {		//red val should be the same
					p.explore();
					try {
						JOptionPane.showMessageDialog(null, "incorrect red value found");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fail("Red value should not be different from original");
				}else if(pixels2[r][c].getGreen()!=pixels[r][c].getGreen()) {   //blue val should be the same
					p.explore();

					try {
						JOptionPane.showMessageDialog(null, "incorrect green value found");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fail("green value should not be different from original");
				}
			}
		}
		
	}
	
	/*
	 * Checks to see if BW is applied to image by taking the average of all the pixels colors (red, green, blue) 
	 * and see it that to be the value of each color channel
	 */
//	@Test
//	void testBW(){
//		
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		//Logic.blackAndWhite(p);
//		LogicSol.blackAndWhite(p2);
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D(); 
//		
//		
//		//check first pixel and 3rd pixel of row 0 for quick messages to Student on issues
//		assertEquals( pixels[0][0].getRed(), pixels2[0][0].getRed() );
//		assertEquals( pixels[0][3].getRed() , pixels2[0][3].getRed() );
//
//		
//		//Compare the pixels of student and solution
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					try {
//						p.explore();
//						JOptionPane.showMessageDialog(null, "The average value of pixel at row "+r+" col " + c + " was not correct. \n Check the solution to see that your solution alters the image at all.");
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					fail("The average value of pixel at row "+r+" col " + c + " was not correct. \n Check the solution to see that your solution alters the image at all.");
//				}
//			}
//		}
//	}
//	
//	/* 
//	 * Check to see if student code creates a negative of the original image
//	 */
//	@Test
//	void testNegative(){
//		
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.negative(p);
//		LogicSol.negative(p2);
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//		
//
//		//Compare the pixels of student and solution
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					try {
//						p.explore();
//						JOptionPane.showMessageDialog(null, "The negative value of pixel at row "+r+" col " + c + " was not correct. \n"+ " Check the GUI to see that your solution alters the image at all.");
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					assertEquals( pixels[r][c].getRed(), pixels2[r][c].getRed() );
//				}
//			}
//		}
//		
//	}
//	
//	/*
//	 * See canvas for more details on applying sunset tone to a picture
//	 */
//	@Test
//	void testSunset(){
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.makeSunset(p, 1.5, .9 );
//		LogicSol.makeSunset(p2, 1.5, .9 );
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//
//		// Only the blue value of the pixels should be altered to be 0
//		// all other color channel values should be the same as original on the new altered picture
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					String msg = "Your provided solution for sunset did not match the solution. Check the GUI to see that your filter applies a different color at all to the picture";
//
//					try {
//						p.explore();
//						JOptionPane.showMessageDialog(null, msg);
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					assertEquals( pixels[r][c].getRed(), pixels2[r][c].getRed() );
//
//				}
//			}
//		}
//		
//	}
//	
//
//	/*
//	 * Checks to see if the image was flipped horizontally
//	 */
//	@Test
//	void testFlipHor(){
//	  |  __ \              | |
//	  | |__) |___  __ _  __| |
//	  |  _  // _ \/ _` |/ _` |
//	  | | \ \  __/ (_| | (_| |
//	  |_|  \_\___|\__,_|\__,_|
//	                          
//	  The method name should be mirrorHorizontal and will Flip the image Horizontally or from left to right.
//	 
//	
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.mirrorHorizontal(p);
//		LogicSol.mirrorHorizontal(p2);
// 		
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//
//		// Only the blue value of the pixels should be altered to be 0
//		// all other color channel values should be the same as original on the new altered picture
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					String msg = "Your provided solution for flipping the image horizontally did not match the solution. Check the GUI to see that your solution flips the image at all.";
//					try {
//						p.explore();
//						JOptionPane.showMessageDialog(null, msg);
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					assertEquals( pixels[r][c].getRed(), pixels2[r][c].getRed() );
//				}
//			}
//		}
//		
//	}
//	
//	/*
//	 * Checks to see if the image was flipped vertically
//	 */
//	@Test
//	void testFlipVer(){
//	
////	  _____                _ 
////	  |  __ \              | |
////	  | |__) |___  __ _  __| |
////	  |  _  // _ \/ _` |/ _` |
////	  | | \ \  __/ (_| | (_| |
////	  |_|  \_\___|\__,_|\__,_|
////	                          
////	  The method name should be mirrorVertical and will Flip the image Vertically (from top to bottom).
//	                          
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.mirrorVertical(p);
//		LogicSol.mirrorVertical(p2);
// 		
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//
//		// Only the blue value of the pixels should be altered to be 0
//		// all other color channel values should be the same as original on the new altered picture
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					String msg = "Your provided solution for flipping the image vertically did not match the solution. Check the GUI to see that it is flipping at all.";
//					try {
//						p.explore();
//						JOptionPane.showMessageDialog(null, msg);
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					assertEquals( pixels[r][c].getRed(), pixels2[r][c].getRed() );
//				}
//			}
//		}
//		
//	}
//	
//	/*
//	 * Tests to see if blurring works for a 2x2 rectangular window.
//	 */
//	@Test
//	void testBlur(){
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.blur(p);
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//
//		//last row of pixels should be skipped to prevent out of bound issues and
//		//algorithm does not account for it
//		assertEquals( pixels[pixels.length-1][0].getRed(), pixels2[pixels.length-1][0].getRed() );
//
//		//last column is also skipped
//		assertEquals( pixels[0][pixels[0].length-1].getRed(), pixels2[0][pixels[0].length-1].getRed() );
//
//		
//		//first pixel (top-left corner) red value should be the average of the four pixels
//		//the first 2x2 red values are: 196, 195, 194, 193
//		assertEquals(pixels[0][0].getRed(), 194);
//		 
//		//check blue just in case for pixel at [0][0]
//		assertEquals(pixels[0][0].getBlue(), 195);
//		
//		
//		//check middle pixel
//		assertEquals(pixels[pixels.length/2][pixels[0].length/2].getRed(), 63);
//		assertEquals(pixels[pixels.length/2][pixels[0].length/2].getBlue(), 78);
//		assertEquals(pixels[pixels.length/2][pixels[0].length/2].getGreen(), 33);
//		
//	}
	
	
	
	
	/** 
	 * Helper method to check that the red, green, and blue channel values of two pixels are the same
	 * @param a, the first Pixel object to check
	 * @param b, the second Pixel object to check
	 * @return true if two Pixel objects' red, green, and blue values are the same
	 */
	public boolean compPixelColors(Pixel a, Pixel b) {
		return a.getBlue()!=b.getBlue() 
				&& a.getRed()!=b.getRed() 
					&& a.getGreen()!=b.getGreen();
	}

}
