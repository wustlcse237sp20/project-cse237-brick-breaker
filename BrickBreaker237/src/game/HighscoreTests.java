package game;

import org.junit.Test;

public class HighscoreTests {
	
	@Test
	public void convertToCSV() {
		String expectedOutput = "name,100";
		Highscore highscore = new Highscore("name", 100);
		String csvOutput = highscore.toCSV();
		assert(expectedOutput.equals(csvOutput));
		
	}
	
	@Test
	public void convertToDisplayString() {
		String expectedOutput = "name : 100";
		Highscore highscore = new Highscore("name", 100);
		String displayOutput = highscore.toString();
		assert(expectedOutput.equals(displayOutput));
	}

}
