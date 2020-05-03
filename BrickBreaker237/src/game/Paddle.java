package game;
import java.awt.*;
import java.util.*;

public class Paddle 
{
    private int posX;
    private int posY;
    private Color myPaddleColor;
    
    private int height = 20;
    private int length = 100;
    private static int initX = 200;
    private static int initY = 450;

    public Paddle()
    {
	    	posX = initX;
	    	posY = initY;
	    	myPaddleColor = Color.BLACK;
    }
    
    //If the player wants a specific color they will enter it when prompted and receive a paddle of that color
    public Color changeColor(Color specificColor)
    {
    	myPaddleColor = specificColor;
	    return myPaddleColor;
    }
    
    public int getX()
    {
    	return posX;
    }
    
    public int getY()
    {
    	return posY;
    }
    
    public int getHeight()
    {
    	return height;
    }
    
    public int getLength()
    {
    	return length;
    }
    
    public void setX(int newX)
    {
    	posX = newX;
    }
    
    public void setY(int newY)
    {
    	posY = newY;
    }
    
    public Color getColor() {
    	return myPaddleColor;
    }
    
    public void draw(Graphics g)
    {
    	g.setColor(myPaddleColor);
    	g.fillRect(posX, posY, length, height);
    }

	/**
	 * Checks the positions of the Ball and Paddle to see whether they hit each other. If so the ball's 
	 * y-direction is inverted
	 * @param myBall
	 */
    public void managePaddleCollision(Ball myBall)
    {
        if((myBall.getX()+ myBall.getLength() >= this.getX()) && (myBall.getX() <= this.getX() + this.getLength()) && 
            (myBall.getY() + myBall.getHeight() >= this.getY()) && (myBall.getY() <= this.getY() + this.getHeight()))
        {
            myBall.yDirection = -1*myBall.yDirection;
        }
    }
}
