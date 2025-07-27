package edu.sdmesa.cisc191;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * Lead Author(s):
 * @author Alex Chow
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0
 */

/**
 * This class is the control panel GUI in the maze explorer app. It contains
 * the speed slider, control buttons, and other associated widgets.
 */
public class ControlsGUI extends JPanel
{
	private MazeController controller;
	private MazeExplorer exp;
	private JSlider slider;
	private JButton stepButton;
	private JButton pauseButton;
	private JButton resetButton;
	private JLabel sliderLabel;
	private JPanel buttonsPanel;
	
	public ControlsGUI(MazeController controller, MazeExplorer exp)
	{
		this.controller = controller;
		this.exp = exp;
		
		setup();
	}

	/**
	 * The main set up helper method.
	 */
	private void setup()
	{		
		BoxLayout mainContainer = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(mainContainer);
		
		setupSliderLabel();		
		setupSlider();
		setupStepButton();		
		setupPauseButton();
		setupResetButton();
		
		setupButtonsPanel();		
	}

	/**
	 * The helper method to set up the buttons panel.
	 */
	private void setupButtonsPanel()
	{
		buttonsPanel = new JPanel();
		add(buttonsPanel);
		
		buttonsPanel.add(stepButton);
		buttonsPanel.add(pauseButton);
		buttonsPanel.add(resetButton);
	}

	/**
	 * The helper method to set up the reset button.
	 */
	private void setupResetButton()
	{
		resetButton = new JButton("Reset");
		resetButton.addActionListener(e -> {
			controller.reset();
			exp.runSolver();
			reset();
		});
	}
	
	/**
	 * The callback function that resets the GUI as necessary.
	 */
	private void reset()
	{
		disableButton(resetButton);
		enableButton(pauseButton);
		enableButton(stepButton);
	}

	/**
	 * The helper method to set up pause button.
	 */
	private void setupPauseButton()
	{
		pauseButton = new JButton("Play");
		pauseButton.addActionListener(e -> {
			controller.togglePause();
		});
	}
	
	/**
	 * Updates the button to say pause or play at the GUI level.
	 */
	public void togglePause()
	{
		if (controller.isPaused()) {
			pauseButton.setText("Play");
		} else {
			pauseButton.setText("Pause");
		}
	}

	/**
	 * The helper method to set up the step button.
	 */
	private void setupStepButton()
	{
		stepButton = new JButton("Step");
		stepButton.addActionListener(e -> {
			controller.nextStep();
		});
	}

	/**
	 * The helper method to set up the slider label.
	 */
	private void setupSliderLabel()
	{
		sliderLabel = new JLabel("Automatically step every " + controller.getMillis() + " milliseconds");
		sliderLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(sliderLabel);
	}
	
	/**
	 * Disables a JButton.
	 * @param button the button to disable
	 */
	public void disableButton(JButton button)
	{
		if (button == null) return;
		button.setEnabled(false);
	}
	
	/**
	 * Enables a JButton.
	 * @param button the button to enable
	 */
	public void enableButton(JButton button)
	{
		if (button == null) return;
		button.setEnabled(true);
	}
	
	/**
	 * Returns the step button.
	 * @return the step button
	 */
	public JButton getStepButton()
	{
		return stepButton;
	}

	/**
	 * Returns the pause button.
	 * @return the pause button
	 */
	public JButton getPauseButton()
	{
		return pauseButton;
	}

	/**
	 * Returns the reset button.
	 * @return the reset button
	 */
	public JButton getResetButton()
	{
		return resetButton;
	}
	
	/**
	 * The helper method to set up the speed slider.
	 */
	private void setupSlider()
	{
		slider = new JSlider();
		slider.setPreferredSize(new Dimension(400, 100));
		slider.setMinimum(MazeController.minWait);
		slider.setMaximum(MazeController.maxWait);
		slider.setValue(MazeController.maxWait);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(100);
		slider.addChangeListener(e -> {
			controller.setMillis(slider.getValue());
			sliderLabel.setText("Automatically step every " + controller.getMillis() + " milliseconds");
		});
		
		Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
		labelTable.put( 1, new JLabel("1") );
		for (int i = 1; i <= 10; i++) {
			labelTable.put( i * 100, new JLabel((i * 100) + "") );
		}
		slider.setLabelTable(labelTable);
		add(slider);
	}
}
