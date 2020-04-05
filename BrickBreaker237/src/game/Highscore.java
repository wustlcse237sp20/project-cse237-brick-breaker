package game;

public class Highscore {
	String name;
	Integer score;
	
	public Highscore(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public String toCSV() {
		String csvFormatted = name + "," + score;
		return csvFormatted;
	}
	
}
