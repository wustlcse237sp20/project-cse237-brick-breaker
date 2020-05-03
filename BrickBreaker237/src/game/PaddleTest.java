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
		Color defaultColor = Color.BLACK;
		//tests all valid colors
		Color testColor = Color.RED;
		Color currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.BLACK;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.BLUE;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.CYAN;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.GRAY;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.GREEN;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.MAGENTA;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		testColor = Color.ORANGE;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor == testColor);
		//tests invalid colors
		testColor = Color.WHITE;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor != testColor);
		assertTrue(currentColor == defaultColor);
		testColor = Color.PINK;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor != testColor);
		assertTrue(currentColor == defaultColor);
		testColor = Color.YELLOW;
		currentColor = paddle.changeColor(testColor);
		assertTrue(currentColor != testColor);
		assertTrue(currentColor == defaultColor);
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
