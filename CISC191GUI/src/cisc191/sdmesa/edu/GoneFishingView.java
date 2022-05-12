package cisc191.sdmesa.edu;

import javax.swing.JFrame;

public class GoneFishingView extends JFrame
{

	/**
	 * TODO
	 * @param model
	 */
	public GoneFishingView(GoneFishingModel model)
	{
		// TODO

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * TODO
	 * @param args
	 */
	public static void main(String[] args)
	{
		new GoneFishingView(new GoneFishingModel());
	}

	/**
	 * TODO
	 */
	public void updateUI()
	{
		// TODO
	}
}
