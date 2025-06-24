/**
 * 
 */
package edu.sdmesa.cisc191.grader.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

import edu.sdmesa.cisc191.grader.model.Achievement;
import edu.sdmesa.cisc191.grader.model.Grader;
import edu.sdmesa.cisc191.grader.model.LearningOutcome;

/**
* Lead Author(s):
* @author Allan Schougaard 
* 
* Other contributors:
* None
* 
* References:
* Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
* 
* Version/date: 2024-11
* 
* Responsibilities of class:
* Presents a GUI for users to enter levels of achievements and see the corresponding grade.
*/
public class GradeView extends JFrame
{
	private final Grader grader;
	
	private final LinkedList<LearningOutcomeComboBox> learningOutcomeComboBoxes = new LinkedList<>();
	
	private final JTextField currentGradeField;
	private final JTextField finalGradeField;
	
	public GradeView(Grader initialGrader)
	{
		super("San Diego Mesa College CISC 191 Grade Calculator");
		
		grader = initialGrader;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setLayout(new GridLayout(1, 2));
		setLayout(new FlowLayout());
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(grader.getLearningOutcomes().length, 1));
		inputPanel.setBorder(BorderFactory.createTitledBorder("Achievement Levels"));
		for (LearningOutcome outcome : grader.getLearningOutcomes())
		{
			LearningOutcomeComboBox box = new LearningOutcomeComboBox(this, outcome);
			learningOutcomeComboBoxes.add(box);
			inputPanel.add(box);
		}
		add(inputPanel);
				
		JPanel currentGradePanel = new JPanel();
		currentGradePanel.setBorder(BorderFactory.createTitledBorder("Current Grade"));
		currentGradePanel.add(new JLabel("Based on submissions so far "));
		currentGradeField = new JTextField(grader.calculateCurrentGrade(), 5); 
		currentGradeField.setHorizontalAlignment(JTextField.CENTER);
		currentGradeField.setEditable(false);
		currentGradeField.setFont(new Font("Dialog", Font.BOLD, 16));
		currentGradePanel.add(currentGradeField);
		
		JPanel finalGradePanel = new JPanel();
		//finalGradePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		finalGradePanel.setBorder(BorderFactory.createTitledBorder("Final Grade"));
		finalGradePanel.add(new JLabel("Based on all LOs "));
		finalGradeField = new JTextField(grader.calculateFinalGrade(), 5);
		finalGradeField.setHorizontalAlignment(JTextField.CENTER);
		finalGradeField.setEditable(false);
		finalGradeField.setFont(new Font("Dialog", Font.BOLD, 16));
		finalGradeField.setToolTipText("Grade based on ...");
		finalGradePanel.add(finalGradeField);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (LearningOutcomeComboBox box : learningOutcomeComboBoxes)
				{
					box.reset();
				}
				updateUI();
			}
		});
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new GridLayout(3, 1, 0, 5));
		outputPanel.add(currentGradePanel);
		outputPanel.add(finalGradePanel);
		outputPanel.add(resetButton);
		add(outputPanel);
		pack();
		// Apparently not necessary
		//validate();
		// Stop window from becoming too small (sorta)
		setMinimumSize(inputPanel.getSize());
		setVisible(true);
	}
	
	public void updateUI()
	{
		currentGradeField.setText(grader.calculateCurrentGrade());
		finalGradeField.setText(grader.calculateFinalGrade());
	}
}
