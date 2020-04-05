package game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ScoreboardTest {
	
	@Test
	void testDefaultInitialization() {
		String filePath = Scoreboard.defaultFilePath;
		Scoreboard scoreboard = new Scoreboard();
		try {
			File scoreboardDatabase = new File(filePath);
			Scanner fileReader = new Scanner(scoreboardDatabase);
			assertNotNull(fileReader);
			
		}
		catch (FileNotFoundException fileNotFoundException) {
			fail("Scoreboard file not found");
		}
		catch (Exception exception) {
			String cause = exception.getLocalizedMessage();
			fail("Failed to due: " + cause );
		}
	}


	@Test
	void testGetAllHighscores() {
		Scoreboard scoreboard = new Scoreboard();
		ArrayList<Highscore> initialHighscores = Scoreboard.initialHighscores;
		Integer minimumScoreCount = initialHighscores.size();
		ArrayList<Highscore> highscores = scoreboard.getHighscores();
		Integer scoreCount = highscores.size();
		
		// If developers have played the game,
		// the file might contain more than the initial scores
		assertTrue(scoreCount >= minimumScoreCount);
		
		for (Highscore score: initialHighscores) {
			assertTrue(highscores.contains(score));
		}

	}
	
	@Test
	void testAddNewHighscore() {
		Scoreboard scoreboard = new Scoreboard();
		
		ArrayList<Highscore> originalScores = scoreboard.getHighscores();
		Integer originalScoreCount = originalScores.size();
		
		Highscore newHighscore = new Highscore("Test", 10);
		scoreboard.addHighscore(newHighscore);
		ArrayList<Highscore> updatedScores =  scoreboard.getHighscores();
		Integer updatedScoreCount = updatedScores.size();
		
		assertEquals(originalScoreCount + 1, updatedScoreCount);
		assertTrue(updatedScores.contains(newHighscore));
		assertFalse(originalScores.contains(newHighscore));
		
	}
}
