import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JOptionPane;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.jupiter.api.Test;

class TesterPictureLab {

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
	
//	/*
//	 * Checks to see if BW is applied to image by taking the average of all the pixels colors (red, green, blue) 
//	 * and see it that to be the value of each color channel
//	 */
//	@Test
//	void testBW(){
//		
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.blackAndWhite(p);
//		LogicSol.blackAndWhite(p2);
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
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
//		//Compare the pixels of student and solution
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					try {
//						JOptionPane.showMessageDialog(null, "The negative value of pixel at row "+r+" col " + c + "was not correct. \n"+ " Check the GUI to see that your solution alters the image at all.");
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					fail("The negative value of pixel at row "+r+" col " + c + "was not correct. \n"+ " Check the GUI to see that your solution alters the image at all.");
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
//					fail(msg);
//				}
//			}
//		}
//		
//	}
//	
//	/*
//	 * Checks to see if the image was flipped horizontally
//	 */
//	@Test
//	void testFlipHor(){
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
//					fail(msg);
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
//					fail(msg);
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
//		LogicSol.blur(p2);
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//
//		//Compare the pixels of student and solution
//		for(int r = 0; r < pixels.length; r++) {
//			for(int c = 0; c < pixels[r].length; c++) {
//				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
//					String msg = "The pixel at row \"+r+\" col \" + c + \" is not the same as the solution";
//					try {
//						p.explore();
//						JOptionPane.showMessageDialog(null, msg);
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					fail(msg);
//				}
//			}
//		}
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
