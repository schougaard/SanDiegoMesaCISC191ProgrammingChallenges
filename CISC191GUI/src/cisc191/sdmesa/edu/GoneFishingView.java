package cisc191.sdmesa.edu;

import javax.swing.JFrame;

public class GoneFishingView extends JFrame
{

	public GoneFishingView(GoneFishingModel model)
	{
		// TODO

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new GoneFishingView(new GoneFishingModel());
	}

	public void updateUI()
	{
		// TODO
	}
}
