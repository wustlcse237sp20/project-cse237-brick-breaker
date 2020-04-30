package game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.Test;

public class BallTest {
	
	@Test
	public void moveOneStep() {
		Ball ball = new Ball();
		
		int xDirection = ball.xDirection;
		int yDirection = ball.yDirection;
		int originalX = ball.getX();
		int originalY = ball.getY();
		
		ball.moveOneStep();
		int newX = ball.getX();
		int newY = ball.getY();
		int expectedX = originalX + xDirection;
		int expectedY = originalY + yDirection;
		
		assertTrue(newX == expectedX);
		assertTrue(newY == expectedY);
		
		
	}
	
	@Test
	public void changeColor() {
		Ball ball = new Ball();
		Color originalColor = ball.getColor();
		Color validColor = Color.GREEN;
		Color invalidColor = Color.WHITE;
		Color fallbackColor = Color.BLACK;
		
		Color newColor = ball.changeColor(validColor);
		
		assertTrue(newColor == validColor);
		newColor = ball.changeColor(invalidColor);
		assertTrue(newColor != invalidColor);
		assertTrue(newColor == fallbackColor);
		
	}
	
	@Test
	public void applyDamagePowerup() {
		Ball ball = new Ball();
		int multiplier = 3;
		int originalDamage = ball.damage;
		PowerUpBrick damagePowerUp = new PowerUpBrick(5, 5, 0, 0, PowerUpType.DAMAGE, multiplier);
		
		ball.applyPowerUp(damagePowerUp);
		int newDamage = ball.damage;
		int expectedDamage = originalDamage * multiplier;
		
		assertTrue(newDamage == expectedDamage);
		
	}
	

}
