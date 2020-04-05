package game;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;

public class ScoreboardView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScoreboardView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JList list = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list, 70, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, list, -358, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, list, -54, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, list, -65, SpringLayout.EAST, this);
		add(list);
		
		JLabel lblHighScores = new JLabel("High Scores ");
		springLayout.putConstraint(SpringLayout.NORTH, lblHighScores, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblHighScores, -182, SpringLayout.EAST, this);
		add(lblHighScores);

	}

}
