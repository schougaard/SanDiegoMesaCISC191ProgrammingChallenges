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
				pixel2D[r][c].setBlue(0);
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
				int avg = (pixel2D[r][c].getRed() + pixel2D[r][c].getGreen() + pixel2D[r][c].getBlue()) / 3;
				pixel2D[r][c].setGreen(avg);
				pixel2D[r][c].setBlue(avg);
				pixel2D[r][c].setRed(avg);

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
				pixel2D[r][c].setBlue(255 - pixel2D[r][c].getBlue());
				pixel2D[r][c].setGreen(255 - pixel2D[r][c].getGreen());
				pixel2D[r][c].setRed(255 - pixel2D[r][c].getRed());
			}
		}
	}


	public static Color getAverage(DigitalPicture picture, int r, int c) {
		Pixel[][] pixel2D = picture.getPixels2D();

		int red = 0, green = 0, blue = 0;
		for (int row = r - 1; row <= r + 1; row++) {
			for (int col = c - 1; col <= c + 1; col++) {
				red += pixel2D[row][col].getRed();
				green += pixel2D[row][col].getGreen();
				blue += pixel2D[row][col].getBlue();
			}
		}

		return new Color(red / 9, green / 9, blue / 9);
	}

	/**
	 * Alters the image so that it applies a Sepia color tone to the image using the formula below.
	 * sepia tr = 0.393R + 0.769G + 0.189B tg = 0.349R + 0.686G + 0.168B tb = 0.272R
	 * + 0.534G + 0.131B
	 * @param picture, the image to be altered
	 */
	public static void sepia(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				int newR = (int) (pixel2D[r][c].getRed() * .393) + (int) (pixel2D[r][c].getGreen() * .769)
						+ (int) (pixel2D[r][c].getBlue() * .189);
				int newG = (int) (pixel2D[r][c].getRed() * .349) + (int) (pixel2D[r][c].getGreen() * .686)
						+ (int) (pixel2D[r][c].getBlue() * .168);
				int newB = (int) (pixel2D[r][c].getRed() * .272) + (int) (pixel2D[r][c].getGreen() * .534)
						+ (int) (pixel2D[r][c].getBlue() * .131);
				newR = newR > 255 ? newR = 255 : newR;
				newG = newG > 255 ? newG = 255 : newG;
				newB = newB > 255 ? newB = 255 : newB;
				pixel2D[r][c].setRed(newR);
				pixel2D[r][c].setBlue(newB);
				pixel2D[r][c].setGreen(newG);
			}
		}

	}
	
	
	/**
	 * Alters the image so that it's flipped horizontally. 
	 * @param picture, the image to be altered
	 */
	public static void mirrorHorizontal(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length / 2; c++) {
				Color temp = pixel2D[r][c].getColor();
				pixel2D[r][c].setColor((pixel2D[r][pixel2D[r].length - 1 - c]).getColor());
				pixel2D[r][pixel2D[r].length - 1 - c].setColor(temp);
			}
		}

	}

	/**
	 * Alters the image so that it's flipped vertically.
	 * @param picture, the image to be altered
	 */
	public static void mirrorVertical(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		int red = 0, green = 0, blue = 0;
		for (int r = 0; r < pixel2D.length / 2; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				Color temp = pixel2D[r][c].getColor();
				pixel2D[r][c].setColor((pixel2D[pixel2D.length - 1 - r][c]).getColor());
				pixel2D[pixel2D.length - 1 - r][c].setColor(temp);
			}
		}

	}
	
	/**
	 * Alters the image so that it's blurred using a 2x2 window
	 * @param picture, the image to be altered
	 */
	public static void blur(DigitalPicture picture) {
		System.out.println("blurring");
		Pixel[][] pixel2D = picture.getPixels2D();

		int window = 2;
		for (int row = 0; row < pixel2D.length - window; row++) {
			for (int col = 0; col < pixel2D[row].length - window; col++) {
				int red = 0, green = 0, blue = 0;
				for (int row2 = row - window < 0 ? row : row - window; row2 <= row + window; row2++) {
					for (int col2 = col - window < 0 ? col : col - window; col2 <= col + window; col2++) {
						red += pixel2D[row2][col2].getRed();
						green += pixel2D[row2][col2].getGreen();
						blue += pixel2D[row2][col2].getBlue();
					}
				}
				Color color = new Color(red / 25, green / 25, blue / 25);
				pixel2D[row][col].setColor(color);
			}
		}

	}


}
