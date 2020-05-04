package game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.Test;

public class PaddleTest {

	@Test
	public void changeColor()
	{
		Paddle paddle = new Paddle();
		Color originalColor = paddle.getColor();
		Color validColor = Color.GREEN;
		Color fallbackColor = Color.BLACK;
		
		Color newColor = paddle.changeColor(validColor);
		
		assertTrue(newColor == validColor);
		assertTrue(newColor == fallbackColor);
	}
	
	@Test
	public void managePaddleCollision()
	{
		Ball ball = new Ball();
		ball.yDirection = -3;
		int newDirection = -1*ball.yDirection;
		assertTrue(newDirection == 3);
	}
}
