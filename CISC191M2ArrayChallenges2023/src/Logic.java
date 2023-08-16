import java.awt.Color;

public class Logic {
	
	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out.
	 * All other channels remain the same 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setBlue(??? <-- replace);
			}
		}
	}

	/**
	 * Alters the picture so that is is black and white by setting each pixels color value to be the average
	 * of the pixels red, green, and blue channel. 
	 * @param picture,  the image to be altered
	 */
	public static void blackAndWhite(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();

		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				int avg = ?;
				pixel2D[r][c].setGreen(avg);
				pixel2D[r][c].setBlue(???);
				pixel2D[r][c].setRed((???);

			}
		}
		
	}

	/**
	 * Alters the picture to create a negative of it using the provided formula.
	 *
	 * @param picture the image to be edited
	 */
	public static void negative(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				 
			}
		}
	}

 
	/**
	 * Alters the image so that it applies a Sepia color tone to the image using the formula below.
	 * sepia tr = 0.393R + 0.769G + 0.189B tg = 0.349R + 0.686G + 0.168B tb = 0.272R
	 * + 0.534G + 0.131B
	 * @param picture, the image to be altered
	 */
	public static void sepia(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		 

	}
	
	
	/**
	 * Alters the image so that it's flipped horizontally. 
	 * @param picture, the image to be altered
	 */
	public static void mirrorHorizontal(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		 

	}

	/**
	 * Alters the image so that it's flipped vertically.
	 * @param picture, the image to be altered
	 */
	public static void mirrorVertical(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		 
		 

	}
	
	/**
	 * Alters the image so that it's blurred using a 2x2 window
	 * @param picture, the image to be altered
	 */
	public static void blur(DigitalPicture picture) {
		System.out.println("blurring");
		Pixel[][] pixel2D = picture.getPixels2D();
 

	}


}
