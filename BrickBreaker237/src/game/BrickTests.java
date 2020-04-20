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

}
