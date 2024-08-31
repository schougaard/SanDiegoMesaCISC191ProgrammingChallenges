package edu.gatech.cc;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureMain
{

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args)
	{
		Picture picture = new Picture(PictureExplorer.imageFolderName + "dragonFly.png");

		/**
		 * Instructions: As you complete a given filter, you must enable the button in
		 * the GUI under PictureExplorer.java.
		 * 
		 * For example, look for the commented out line shown below in
		 * PictureExplorer.java. Uncomment it so that it correctly invokes your written
		 * blackAndWhite filter method. // Logic.blackAndWhite(picture);
		 * 
		 * 
		 */

		picture.explore();

	}

}