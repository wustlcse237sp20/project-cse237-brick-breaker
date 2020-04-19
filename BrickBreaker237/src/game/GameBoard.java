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
	public PowerUpBrick powerUpBricks[][];
	Paddle userPaddle = new Paddle();
	Ball userBall = new Ball();

	private int brickHeight;
	private int brickWidth;
	private int brickRow;
	private int brickCol;
	private int boardDim;
	private boolean gameOver;

	private int posDirection = 3;
	private int negDirection = -3;

	public GameBoard(int boardDim, int brickRow, int brickCol) 
	{
//		addKeyListener(new KeyListener() 
//		{
//			   @Override
//			   public void keyTyped(KeyEvent e) 
//			   {
//				   //Not written yet
//			   }
//			   
//			   @Override
//			   public void keyReleased(KeyEvent e) 
//			   {
//				   //Not written yet
//			   }
//			   
//			   @Override
//			   public void keyPressed(KeyEvent e) 
//			   {
//			    	int key = e.getKeyCode();
//			    	if (key == KeyEvent.VK_LEFT) 
//			    	{
//						userPaddle.setX(userPaddle.getX() - 50);
//					}
//					if (key == KeyEvent.VK_RIGHT) 
//					{
//						userPaddle.setX(userPaddle.getX() + 50);
//					}
//			   }
//		});
		setFocusable(true);
		this.gameOver = false;
		this.brickRow = brickRow;
		this.brickCol = brickCol;
		this.boardDim = boardDim;
		this.brickHeight = boardDim / brickCol;
		this.brickWidth = brickHeight / 2;
		breakableBricks = initBricks(brickCol, brickRow);
		powerUpBricks = initPowerUpBricks(1,1);
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
					userBall.updatePos();
					ifHitWallBounce(userBall);
					ifHitBrickBounce(userBall);
					ifBallHitPaddleBounce(userBall, userPaddle);
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
	 * Checks the positions of the Ball and Paddle to see whether they hit each other. If so the ball's 
	 * y-direction is inverted
	 * @param myBall
	 * @param myPaddle
	 */
	public void ifBallHitPaddleBounce(Ball myBall, Paddle myPaddle)
	{
		if((myBall.getX()+ myBall.getLength() >= myPaddle.getX()) && (myBall.getX() <= myPaddle.getX() + myPaddle.getLength()) && 
			(myBall.getY() + myBall.getHeight() >= myPaddle.getY()) && (myBall.getY() <= myPaddle.getY() + myPaddle.getHeight()))
		{
			myBall.setYdir(-1*myBall.getYdir());
		}
	}
	
	/**
	 * Looks at the positions and size of the ball to determine if it will hit a wall and, if so,
	 * changes the X and Y directions appropriately
	 * @param myBall
	 */
	public void ifHitWallBounce(Ball myBall)
	{
		if(myBall.getX() + myBall.getLength() > boardDim)
		{
			myBall.setXdir(negDirection);
		}
		if(myBall.getY() + myBall.getHeight() > boardDim)
		{
			myBall.setYdir(negDirection);
		}
		if(myBall.getX() < 0)
		{
			myBall.setXdir(posDirection);
		}
		if(myBall.getY() < 0)
		{
			myBall.setYdir(posDirection);
		}
	}

	/**
	 * Looks at the positions and size of the ball to determine if it will hit a block and, if so,
	 * changes the X and Y directions appropriately and subtracts health from block
	 * @param myBall
	 */
	public boolean ifHitBrickBounce(Ball myBall)
	{
		for (int i = 0; i < brickCol; i++) {
			for (int j = 0; j < brickRow; j++) {
				//block hit left side
				int blockX = breakableBricks[i][j].getxCoordinate();
				int blockY = breakableBricks[i][j].getyCoordinate();
				int blockXDim = breakableBricks[i][j].getxDim();
				int blockYDim = breakableBricks[i][j].getyDim();

				if(breakableBricks[i][j].getHealth() > 0){
					//top side
					if((myBall.getX() + myBall.getLength() > blockX && myBall.getX() < blockX + blockXDim) 
							&& (myBall.getY() - myBall.getHeight() < blockY  && myBall.getY() > blockY - blockYDim))
					{
						myBall.setYdir(-1*myBall.getYdir());
						breakableBricks[i][j].damageBrick(myBall.damage);
						return true;
					}
					
					//right side
					if((myBall.getX() + myBall.getLength() > blockX && myBall.getX() < blockX + blockXDim) 
						&& (myBall.getY() - myBall.getHeight() < blockY  && myBall.getY() > blockY - blockYDim))
					{
						myBall.setXdir(-1*myBall.getXdir());
						breakableBricks[i][j].damageBrick(myBall.damage);
						return true;
					}

					//bottom side
					if((myBall.getX() > blockX && myBall.getX() < blockX + blockXDim) 
							&& (myBall.getY() < blockY  && myBall.getY() > blockY - blockYDim))
					{
						myBall.setYdir(-1*myBall.getYdir());
						breakableBricks[i][j].damageBrick(myBall.damage);
						return true;
					}

					//left side
					if((myBall.getX() > blockX && myBall.getX() < blockX + blockXDim) 
							&& (myBall.getY() < blockY  && myBall.getY() > blockY - blockYDim))
					{
						myBall.setXdir(-1*myBall.getXdir());
						breakableBricks[i][j].damageBrick(myBall.damage);
						return true;
					}
				}
			}
		}
		return false;
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
	
	public PowerUpBrick[][] initPowerUpBricks(int col, int row) {
		// TODO: Change location from hardcoded values
		PowerUpBrick powerUpBricks[][] = new PowerUpBrick[col][row];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				powerUpBricks[i][j] = new PowerUpBrick(brickWidth , brickHeight, 250, 250, PowerUpType.DAMAGE, 2);
			}
		}
		return powerUpBricks;
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
			for (int j = 0; j < powerUpBricks[0].length; j++) {
				PowerUpBrick powerUp = powerUpBricks[i][j];
				g.setColor(powerUp.getColor());
//				g.fillRect(powerUp.xCoordinate * brickHeight, powerUp.yCoordinate * brickWidth, brickHeight, brickWidth);
//				g.drawRect(powerUp.xCoordinate * brickHeight, powerUp.yCoordinate * brickWidth, brickHeight, brickWidth);
				g.fillRect(powerUp.xCoordinate, powerUp.yCoordinate, brickHeight, brickWidth);
				g.drawRect(powerUp.xCoordinate, powerUp.yCoordinate, brickHeight, brickWidth);
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
