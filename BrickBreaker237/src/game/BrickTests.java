package game;

import org.junit.Test;

public class BrickTests {
	
	@Test
	public void damageBreakableBrick() {
		int initialHealth = 3;
		int damageToDeal = 2;
		BreakableBrick brick = new BreakableBrick(0, 0, 1, 1, 0, 0, initialHealth);
		
		assert(initialHealth == brick.health);
		
		brick.damageBrick(damageToDeal);
		int newHealth = brick.health;
		int expectedHealth = initialHealth - damageToDeal;
		assert(newHealth == expectedHealth);
		
		int overkillDamage = brick.health + 1;
		int minimumHealth = 0;
		brick.damageBrick(overkillDamage);
		newHealth = brick.health;
		assert(newHealth == minimumHealth);
	}
	
	@Test
	public void detectCollision() {
		int ballX = 2;
		int ballY = 2;
		PowerUpBrick powerUp = new PowerUpBrick(3, 3, 0, 0, PowerUpType.DAMAGE, 2);
		boolean detected = powerUp.collisionDetected(ballX, ballY);
		
		assert(detected);
		
		ballX = 7;
		ballY = 7;
		detected = powerUp.collisionDetected(ballX, ballY);
		
		assert(!detected);
		
	}

	@Test
	void testBallCollidesAndBouncesOffBricks() {
		int screenDim=500;
		int brickRow=20;
		int brickCol=8;
		Paddle paddle = new Paddle();
		Ball ball = new Ball();
		
        GameBoard gameBoard = new GameBoard(screenDim, brickRow, brickCol, paddle, ball);
        
        int cols = gameBoard.getBreakableBricks().length;
        int rows = gameBoard.getBreakableBricks()[0].length;

		assertTrue(gameBoard.ifHitBrickBounce(gameBoard.getBall()));
		
	}

	@Test
	void testMonitorBrickCollision() {
		int screenDim=500;
		int brickRow=1;
		int brickCol=1;
		Paddle paddle = new Paddle();
		Ball ball = new Ball();
		
        GameBoard gameBoard = new GameBoard(screenDim, brickRow, brickCol, paddle, ball);
        
        int cols = gameBoard.getBreakableBricks().length;
        int rows = gameBoard.getBreakableBricks()[0].length;
		
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				assertFalse(getBreakableBricks()[i][j].monitorCollision(ball));
			}
		}
	}

}
