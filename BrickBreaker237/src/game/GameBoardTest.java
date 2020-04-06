package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameBoardTest {

	@Test
	void testCheckBricksAreCreatedAfterBoardCreation() {
		int screenDim=500;
		int brickRow=10;
		int brickCol=10;
		
        GameBoard gameBoard = new GameBoard(screenDim, brickRow, brickCol);
        
        int cols = gameBoard.getBreakableBricks().length;
        int rows = gameBoard.getBreakableBricks()[0].length;

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				assertNotNull(gameBoard.getBreakableBricks()[i][j]);
			}
		}
	}

}
