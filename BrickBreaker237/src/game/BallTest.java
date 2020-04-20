package game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class BallTest {
	
	@Test
	public void moveOneStep() {
		Ball ball = new Ball();
		
		int xDirection = ball.getXdir();
		int yDirection = ball.getYdir();
		int originalX = ball.getX();
		int originalY = ball.getY();
		
		ball.updatePos();
		int newX = ball.getX();
		int newY = ball.getY();
		int expectedX = originalX + xDirection;
		int expectedY = originalY + yDirection;
		
		assertTrue(newX == expectedX);
		assertTrue(newY == expectedY);
		
		
	}
	

}
