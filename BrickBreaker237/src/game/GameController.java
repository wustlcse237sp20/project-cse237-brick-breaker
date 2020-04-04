package game;
import javax.swing.JFrame;

public class GameController {
//init gameboard
//start and manage game 

    public static void main(String[] args) {
        JFrame gameView = new JFrame();
        GameBoard gameBoard = new GameBoard();

        gameView.setTitle("Brick Breaker");
        gameView.setBounds(0, 0, 500, 500);
		gameView.setResizable(false);
        gameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameView.add(gameBoard);

        gameView.setVisible(true);

    }
}
