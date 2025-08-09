package edu.sdmesa.cisc191.view;

import java.awt.Dimension;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import edu.sdmesa.cisc191.model.MazeSolver;

/**
 * Lead Author(s):
 * 
 * @author Alex Chow
 * 
 *         Other contributors:
 *         None
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Version/date: 1.0
 */

/**
 * This class is the control panel GUI in the maze explorer app. It contains
 * the speed slider, control buttons, and other associated widgets.
 */
public class ControlPanel extends JPanel
{
	private MazeExplorer exp;

	private JSlider slider;
	private JButton stepButton;
	private JButton pauseButton;
	private JButton resetButton;
	private JLabel sliderLabel;
	private JPanel buttonsPanel;

	public ControlPanel(MazeExplorer exp)
	{
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

		setupMazeCleared();
	}

	private void setupMazeCleared()
	{
		// when the maze is cleared, disable step and pause buttons
		exp.getSolver().addPropertyChangeListener((mazeClearedEvent) -> {
			disableButton(stepButton);
			disableButton(pauseButton);
			enableButton(resetButton);
		});
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
			exp.reset();
			setupMazeCleared();
			exp.runSolver();
			resetGUI();
			updatePauseGUI();
		});
	}

	/**
	 * The callback function that resets the GUI as necessary.
	 */
	private void resetGUI()
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
			exp.getSolver().togglePause();
			updatePauseGUI();
		});
	}

	/**
	 * Updates the button to say pause or play at the GUI level.
	 */
	public void updatePauseGUI()
	{
		if (exp.getSolver().isPaused())
		{
			enableButton(resetButton);
			enableButton(stepButton);
			pauseButton.setText("Play");
		}
		else
		{
			disableButton(resetButton);
			disableButton(stepButton);
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
			exp.getSolver().nextStep();
		});
	}

	/**
	 * The helper method to set up the slider label.
	 */
	private void setupSliderLabel()
	{
		sliderLabel = new JLabel("Automatically step every "
				+ MazeSolver.pauseMillis + " milliseconds");
		sliderLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(sliderLabel);
	}

	/**
	 * Disables a JButton.
	 * 
	 * @param button the button to disable
	 */
	public void disableButton(JButton button)
	{
		if (button == null) return;
		button.setEnabled(false);
	}

	/**
	 * Enables a JButton.
	 * 
	 * @param button the button to enable
	 */
	public void enableButton(JButton button)
	{
		if (button == null) return;
		button.setEnabled(true);
	}

	/**
	 * Returns the step button.
	 * 
	 * @return the step button
	 */
	public JButton getStepButton()
	{
		return stepButton;
	}

	/**
	 * Returns the pause button.
	 * 
	 * @return the pause button
	 */
	public JButton getPauseButton()
	{
		return pauseButton;
	}

	/**
	 * Returns the reset button.
	 * 
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
		slider.setMinimum(MazeSolver.minWait);
		slider.setMaximum(MazeSolver.maxWait);
		slider.setValue(MazeSolver.pauseMillis);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(100);
		slider.addChangeListener(e -> {
			MazeSolver.pauseMillis = slider.getValue();
			sliderLabel.setText("Automatically step every "
					+ MazeSolver.pauseMillis + " milliseconds");
		});

		Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
		labelTable.put(1, new JLabel("1"));
		for (int i = 1; i <= 10; i++)
		{
			labelTable.put(i * 100, new JLabel((i * 100) + ""));
		}
		slider.setLabelTable(labelTable);
		add(slider);
	}
}
