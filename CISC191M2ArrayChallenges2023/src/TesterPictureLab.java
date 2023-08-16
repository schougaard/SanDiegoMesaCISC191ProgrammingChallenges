import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesterPictureLab {

	@Test
	void testZeroBlue() {
		
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.zeroBlue(p);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(pixels[r][c].getBlue()!=0) {
					fail("Found a pixel with a non-zeroed blue value");
				}else if(pixels2[r][c].getRed()!=pixels[r][c].getRed()) {
					fail("Red value should not be different from original");
				}else if(pixels2[r][c].getGreen()!=pixels[r][c].getGreen()) {
					fail("Red value should not be different from original");
				}
			}
		}
		
	}
	
	@Test
	void testBW(){
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.blackAndWhite(p);
		LogicSol.blackAndWhite(p2);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
					fail("Found a pixel with a non-zeroed blue value");
				}
			}
		}
	}
	
	@Test
	void testNegative(){
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.blackAndWhite(p);
		LogicSol.blackAndWhite(p2);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
					fail("Found a pixel with a non-zeroed blue value");
				}
			}
		}
		
	}
	
	@Test
	void testSepia(){
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.sepia(p);
		LogicSol.sepia(p2);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
					fail("Found a pixel with a non-zeroed blue value");
				}
			}
		}
		
	}
	
	@Test
	void testFlipHor(){
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.mirrorHorizontal(p);
		LogicSol.mirrorHorizontal(p2);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
					fail("Found a pixel with a non-zeroed blue value");
				}
			}
		}
		
	}
	
	@Test
	void testFlipVer(){
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.mirrorVertical(p);
		LogicSol.mirrorVertical(p2);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
					fail("Found a pixel with a non-zeroed blue value");
				}
			}
		}
		
	}
	
	@Test
	void testBlur(){
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		Logic.blur(p);
		LogicSol.blur(p2);
 		
		Pixel[][] pixels = p.getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();

		// Only the blue value of the pixels should be altered to be 0
		// all other color channel values should be the same as original on the new altered picture
		for(int r = 0; r < pixels.length; r++) {
			for(int c = 0; c < pixels[r].length; c++) {
				if(compPixelColors(pixels[r][c], pixels2[r][c])) {
					fail("Found a pixel with a non-zeroed blue value");
				}
			}
		}
		
	}
	
	
	
	public boolean compPixelColors(Pixel a, Pixel b) {
		return a.getBlue()!=b.getBlue() 
				&& a.getRed()!=b.getRed() 
					&& a.getGreen()!=b.getGreen();
	}

}
