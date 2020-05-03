package game;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameBoard extends JPanel //implements KeyListener
{
	private static final int FPS = 60;
	private static final int initalBrickHealth = 3;

	public BreakableBrick breakableBricks[][];
	public PowerUpBrick powerUpBricks[];
	Paddle userPaddle;
	Ball userBall;

	private int brickHeight;
	private int brickWidth;
	private int brickRow;
	private int brickCol;
	private int boardDim;
	private boolean gameOver;

	private int posDirection = 2;
	private int negDirection = -2;

	public GameBoard(int boardDim, int brickRow, int brickCol, Paddle myPaddle, Ball myBall) 
	{
		addKeyListener(new KeyListener() 
		{
			   @Override
			   public void keyTyped(KeyEvent e) 
			   {
				   //Unused
			   }
			   
			   @Override
			   public void keyReleased(KeyEvent e) 
			   {
				   //Unused
			   }
			   
			   @Override
			   public void keyPressed(KeyEvent e) 
			   {
			    	int key = e.getKeyCode();
			    	if (key == KeyEvent.VK_LEFT) 
			    	{
						userPaddle.setX(userPaddle.getX() - 50);
					}
					if (key == KeyEvent.VK_RIGHT) 
					{
						userPaddle.setX(userPaddle.getX() + 50);
					}
			   }
		});
		setFocusable(true);
		this.gameOver = false;
		this.brickRow = brickRow;
		this.brickCol = brickCol;
		this.boardDim = boardDim;
		this.brickHeight = boardDim / brickCol;
		this.brickWidth = brickHeight / 2;
		breakableBricks = initBricks(brickCol, brickRow);
		powerUpBricks = initPowerUpBricks(1);
		userPaddle = myPaddle;
		userBall = myBall;
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		setBackground(Color.white);
		drawBreakableBricks((Graphics2D) g);
		drawPowerUps((Graphics2D)g);
		drawPaddleAndBall(g);
	}

	/**
	 * Manages and updates game instance
	 */
	public void runGame() {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() 
			{
				if (!gameOver) {
					userBall.moveOneStep();
					userBall.manageWallCollision(boardDim, posDirection, negDirection);
					ifHitBrickBounce(userBall);
					ifHitPowerUpApply(userBall);
					userPaddle.managePaddleCollision(userBall);
					repaint();
				} else {
					// game over state
					
				}
			}
		}, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
	}
	
	public void drawPaddleAndBall(Graphics g)
	{
		userPaddle.draw(g);
		userBall.draw(g);
	}

	/**
	 * Looks at the positions and size of the ball to determine if it will hit a block and, if so,
	 * changes the X and Y directions appropriately and subtracts health from block
	 * @param myBall
	 */
	public void ifHitBrickBounce(Ball myBall)
	{
		for (int i = 0; i < brickCol; i++) {
			for (int j = 0; j < brickRow; j++) {
				//block hit left side
				BreakableBrick brick = breakableBricks[i][j];
				if(brick.monitorCollision(myBall)){
				}
			}
		}
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
	
	public PowerUpBrick[] initPowerUpBricks(int total) {
		// TODO: Change location from hardcoded values
		PowerUpBrick powerUpBricks[] = new PowerUpBrick[total];
		for (int i = 0; i < total; i++) {
			powerUpBricks[i] = new PowerUpBrick(brickWidth , brickHeight, 250, 250, PowerUpType.DAMAGE, 2);
			
		}
		return powerUpBricks;
	}

	/**
	 * Redraw breakable bricks
	 * 
	 * @param g
	 */
	public void drawBreakableBricks(Graphics2D g) {
		for (int i = 0; i < breakableBricks.length; i++) {
			for (int j = 0; j < breakableBricks[0].length; j++) {
				BreakableBrick brick = breakableBricks[i][j];
				int health= breakableBricks[i][j].getHealth();
				// if brick still has health, repaint it
				switch (health) {
				  case 0:
					g.setColor(Color.white);
					g.fillRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);
				    break;
				  case 1:
					g.setColor(Color.ORANGE);
					g.fillRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);
				    break;
				  case 2:
					  g.setColor(Color.YELLOW);
					  g.fillRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);
				    break;
				  case 3:
					g.setColor(Color.GREEN);
					g.fillRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);
				    break;
				}
				g.setColor(Color.BLACK);
				g.drawRect(i * brickHeight, j * brickWidth, brickHeight, brickWidth);
			}
		}
	}
	
	public void drawPowerUps(Graphics2D g) {
		for (int i = 0; i < powerUpBricks.length; i++) {
			PowerUpBrick powerUp = powerUpBricks[i];
			if (powerUp.health > 0) {
				g.setColor(powerUp.getColor());
				g.fillRect(powerUp.xCoordinate, powerUp.yCoordinate, brickHeight, brickWidth);
			}
			else {
				g.setColor(Color.white);
				g.fillRect(powerUp.xCoordinate, powerUp.yCoordinate, brickHeight, brickWidth);
			}
			
			g.drawRect(powerUp.xCoordinate, powerUp.yCoordinate, brickHeight, brickWidth);
		}
	}
	
	public void ifHitPowerUpApply(Ball ball) {
		for (int i = 0; i < powerUpBricks.length; i++) {
			PowerUpBrick powerUp = powerUpBricks[i];
			if (powerUp.health > 0) {
				boolean collision = powerUp.collisionDetected(ball.getX(), ball.getY());
				if (collision) {
					powerUp.health = 0;
					ball.applyPowerUp(powerUp);
				}
			}
		}
	}

	public BreakableBrick[][] getBreakableBricks() {
		return breakableBricks;
	}
	
	public Ball getBall() {
		return userBall;
	}
}
