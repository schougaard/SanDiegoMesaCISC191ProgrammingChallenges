/**
 * 
 */
package edu.sdmesa.cisc191.grader.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

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
		//inputPanel.setAlignmentX(LEFT_ALIGNMENT);
		inputPanel.setBorder(BorderFactory.createTitledBorder("Achievement Levels"));
		for (LearningOutcome outcome : grader.getLearningOutcomes())
		{
			LearningOutcomeComboBox box = new LearningOutcomeComboBox(this, outcome);
			inputPanel.add(box);
		}
		add(inputPanel);
		
		JPanel currentGradePanel = new JPanel();
		currentGradePanel.setBorder(BorderFactory.createTitledBorder("Current Grade"));
		currentGradePanel.add(new JLabel("Based on current submissions  "));
		currentGradeField = new JTextField(grader.calculateCurrentGrade(), 5); 
		currentGradeField.setHorizontalAlignment(JTextField.CENTER);
		currentGradeField.setEditable(false);
		currentGradeField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		currentGradePanel.add(currentGradeField);
		
		JPanel finalGradePanel = new JPanel();
		finalGradePanel.setBorder(BorderFactory.createTitledBorder("Final Grade"));
		finalGradePanel.add(new JLabel("Based on all LOs    "));
		finalGradeField = new JTextField(grader.calculateFinalGrade(), 5);
		finalGradeField.setHorizontalAlignment(JTextField.CENTER);
		finalGradeField.setEditable(false);
		finalGradeField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		finalGradePanel.add(finalGradeField);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS)); 
		outputPanel.add(currentGradePanel);
		outputPanel.add(finalGradePanel);
		add(outputPanel);
		pack();
		setMinimumSize(inputPanel.getSize());
		setVisible(true);
	}
	
	public void updateUI()
	{
		currentGradeField.setText(grader.calculateCurrentGrade());
		finalGradeField.setText(grader.calculateFinalGrade());
	}
}
