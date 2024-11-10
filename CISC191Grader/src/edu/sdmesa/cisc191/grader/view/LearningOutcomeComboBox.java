/**
 * 
 */
package edu.sdmesa.cisc191.grader.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import edu.sdmesa.cisc191.grader.model.Achievement;
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
* Presents a learning outcome with a level of achievement for the user to select.
* Automatically updates the rest of the GUI.
*/
public class LearningOutcomeComboBox extends JPanel
{
	
	public LearningOutcomeComboBox(GradeView gradeView, LearningOutcome learningOutcome)
	{
		String labelString = learningOutcome.toString() + ": " + learningOutcome.getTitle();
		JLabel label = new JLabel(labelString);
		
		final JComboBox<Achievement> comboBox = new JComboBox<Achievement>(Achievement.values());
		label.setLabelFor(comboBox);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(label);
		add(new JSeparator());
		add(comboBox);
		comboBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				learningOutcome.setAchievement((Achievement)comboBox.getSelectedItem());
				gradeView.updateUI();
			}
		});	
	}

}
