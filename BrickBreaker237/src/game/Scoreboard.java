package game;

import java.io.File;
import java.util.ArrayList;

public class Scoreboard {
	static String defaultFilePath = "highscores.txt";
	static ArrayList<Highscore> initialHighscores = new ArrayList<Highscore>() { 
		{
			add( new Highscore("The_Breaker", 100));
			add( new Highscore("AAA", 50));
			add( new Highscore("BrickNoob", 10));
		}	
	};
			
	private String fileLocation;
	private File permanentStorage;
	private ArrayList<Highscore> highscores;
	
	public Scoreboard() {
		// TODO: Either read or initialize default highscore file
	}
	
	public ArrayList<Highscore> getHighscores() {
		return highscores;
	}
	
	
}
