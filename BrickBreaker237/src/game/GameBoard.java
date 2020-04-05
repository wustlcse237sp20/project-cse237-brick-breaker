package game;

import javax.swing.JPanel;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameBoard extends JPanel {

	private static final int FPS = 60;
	public BreakableBrick breakableBricks[][];
	public int initalBrickHealth = 3;
	public int brickHeight;
	public int brickWidth;
	public int brickRow;
	public int brickCol;
	public int boardDim;
	public boolean gameOver = false;

	public GameBoard(int boardDim, int brickRow, int brickCol) {
		this.brickRow = brickRow;
		this.brickCol = brickCol;
		this.boardDim = boardDim;
		this.brickHeight = boardDim / brickCol;
		this.brickWidth = brickHeight / 2;
		breakableBricks = initBricks(brickCol, brickRow);
	}

	protected void paintComponent(Graphics g) {
		setBackground(Color.black);
		drawBreakableBricks((Graphics2D) g);
	}

	/**
	 * Manages and updates game instance
	 */
	public void runGame() {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				// update game here

				// repaint refreshes graphics
				repaint();
			}
		}, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
	}

	public BreakableBrick[][] initBricks(int col, int row) {
		BreakableBrick brickArray[][] = new BreakableBrick[col][row];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				brickArray[i][j] = new BreakableBrick(i, j, brickWidth , brickHeight, i * brickHeight, j * brickWidth,initalBrickHealth);
			}
		}
		return brickArray;
	}

	/**
	 * Redraw/update graphics for breakable bricks
	 * 
	 * @param g
	 */
	public void drawBreakableBricks(Graphics2D g) {
		for (int i = 0; i < breakableBricks.length; i++) {
			for (int j = 0; j < breakableBricks[0].length; j++) {
				BreakableBrick brick = breakableBricks[i][j];
				// if brick still has health, repaint it
				if (breakableBricks[i][j].getHealth() > 0) {
					g.setColor(Color.green);
					g.drawRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);
				}
			}
		}
	}

}
