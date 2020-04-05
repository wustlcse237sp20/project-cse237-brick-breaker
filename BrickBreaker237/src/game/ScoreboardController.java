package game;

import javax.swing.DefaultListModel;

public class ScoreboardController {
	private Scoreboard scoreboard;
	
	public ScoreboardController() {
		scoreboard = new Scoreboard();
	}
	
	public DefaultListModel<Highscore> getHighscores() {
		DefaultListModel<Highscore> formattedForUI = new DefaultListModel<Highscore>();
		formattedForUI.addAll(scoreboard.getHighscores());
		return formattedForUI;	
	}
}
