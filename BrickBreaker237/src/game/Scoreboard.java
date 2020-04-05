package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scoreboard {
	static String defaultFilePath = "highscores.txt";
	static ArrayList<Highscore> initialHighscores = new ArrayList<Highscore>() { 
		{
			add( new Highscore("The_Breaker", 100));
			add( new Highscore("AAA", 50));
			add( new Highscore("BrickNoob", 10));
		}	
	};
			
	private String filePath;
	private File permanentStorage;
	private ArrayList<Highscore> highscores;
	
	public Scoreboard() {
		filePath = defaultFilePath;
		permanentStorage = new File(filePath);
		highscores = initialHighscores;
	}
	
	public ArrayList<Highscore> getHighscores() {
		return highscores;
	}
	
	public Boolean addHighscore(Highscore newHighscore) {
		return highscores.add(newHighscore);
	}
	
	public Boolean loadHighscoresFromDisk() {
		try {
			Scanner fileReader = new Scanner(permanentStorage);
			while (fileReader.hasNextLine()) {
				String rawHighScore = fileReader.nextLine();
				String[] splitHighScore = rawHighScore.split(",");
				String name = splitHighScore[0];
				Integer score = Integer.parseInt(splitHighScore[1]);
				Highscore highscore = new Highscore(name, score);
				highscores.add(highscore);
			};
			fileReader.close();
		
			
			return true;
		}
		catch (IOException ioException) {
			// TODO: Either log or print
			return false;
		}
		catch (Exception exception) {
			// TODO: Either log or print
			return false;
		}
	}
	
	public Boolean saveHighscoresToDisk() {
		try {
			permanentStorage.createNewFile();
			FileWriter scoreboardWriter = new FileWriter(permanentStorage);
			for(Highscore highscore: highscores) {
				String newCSVRow = highscore.toCSV();
				scoreboardWriter.write(newCSVRow);
			}
			scoreboardWriter.close();
			return true;
		}
		catch (IOException ioException) {
			// TODO: Either log or print
			return false;
		}
		catch (Exception exception) {
			// TODO: Either log or print
			return false;
		}
	}
	
	
}
