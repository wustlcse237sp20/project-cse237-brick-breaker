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
    
    ArrayList<Color> paddleColors = new ArrayList<Color>( Arrays.asList(Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE));
    
    public Paddle()
    {
    	posX = 200;
    	posY = 450;
    	myPaddleColor = Color.BLACK;
    }
    
    //If the player wants a specific color they will enter it when prompted and receive a paddle of that color
    public Paddle(Color specificColor)
    {
    	posX = 200;
    	posY = 100;
    	if(paddleColors.contains(specificColor))
    	{
    		myPaddleColor = specificColor;
    	}
    	else
    	{
    		myPaddleColor = Color.BLACK;
    	}
    }
    
    public int getX()
    {
    	return posX;
    }
    
    public int getY()
    {
    	return posY;
    }
    
    public void setX(int newX)
    {
    	posX = newX;
    }
    
    public void setY(int newY)
    {
    	posY = newY;
    }
    
    //checks whether the ball is at the same X and Y that the paddle should be at
    public boolean hitBall(int ballX, int ballY, int ballHeight, int ballLength)
    {
    	if((ballX + ballLength >= posX) && (ballX <= posX + length) && (ballY + ballHeight >= posY) && (ballY <= posY + height))
    	{
    		return true;
    	}
    	return false;
    }
    
    public void draw(Graphics g)
    {
    	g.setColor(myPaddleColor);
    	g.fillRect(posX, posY, length, height);
    }
}
