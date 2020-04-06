package game;

import javax.swing.JPanel;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameBoard extends JPanel {

	private static final int FPS = 60;
	private BreakableBrick breakableBricks[][];
	private int initalBrickHealth = 3;
	private int brickHeight;
	private int brickWidth;
	private int brickRow;
	private int brickCol;
	private int boardDim;
	private boolean gameOver = false;

	public GameBoard(int boardDim, int brickRow, int brickCol) {
		this.brickRow = brickRow;
		this.brickCol = brickCol;
		this.boardDim = boardDim;
		this.brickHeight = boardDim / brickCol;
		this.brickWidth = brickHeight / 2;
		breakableBricks = initBricks(brickCol, brickRow);
	}

	/**
	 * Manage refreshing graphics, called with repaint()
	 */
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
				if (!gameOver) {
					// update game here

					// repaint refreshes graphics
					repaint();
				} else {
					// game over state
					
				}
			}
		}, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
	}

	/**
	 * init game board of bricks
	 * 
	 * @param col column brick is in
	 * @param row row brick is in
	 * @return
	 */
	public BreakableBrick[][] initBricks(int col, int row) {
		BreakableBrick brickArray[][] = new BreakableBrick[col][row];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				brickArray[i][j] = new BreakableBrick(i, j, brickWidth, brickHeight, i * brickHeight, j * brickWidth,
						initalBrickHealth);
			}
		}
		return brickArray;
	}

	/**
	 * Redraw/update graphics for breakable bricks
	 * 
	 * @param g Graphics2D component
	 */
	public void drawBreakableBricks(Graphics2D g) {
		for (int i = 0; i < breakableBricks.length; i++) {
			for (int j = 0; j < breakableBricks[0].length; j++) {
				BreakableBrick brick = breakableBricks[i][j];
				int health = breakableBricks[i][j].getHealth();
				// if brick still has health, repaint it
				switch (health) {
				case 0:
					g.setColor(Color.BLACK);
					break;
				case 1:
					g.setColor(Color.YELLOW);
					break;
				case 2:
					g.setColor(Color.ORANGE);
					break;
				case 3:
					g.setColor(Color.GREEN);
					break;
				}
				g.fillRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);

				// draw outline
				g.setColor(Color.BLACK);
				g.drawRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);

			}
		}
	}

	public BreakableBrick[][] getBreakableBricks() {
		return breakableBricks;
	}

}
