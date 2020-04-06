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
    
    ArrayList<Color> possiblePaddleColors = new ArrayList<Color>( Arrays.asList(Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE));
    
    public Paddle()
    {
	    	posX = 200;
	    	posY = 450;
	    	myPaddleColor = Color.BLACK;
    }
    
    //If the player wants a specific color they will enter it when prompted and receive a paddle of that color
    //TODO: Proper implementation of this in the Main View
    public Paddle(Color specificColor)
    {
	    	posX = 200;
	    	posY = 100;
	    	if(possiblePaddleColors.contains(specificColor))
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
    
    public void draw(Graphics g)
    {
    	g.setColor(myPaddleColor);
    	g.fillRect(posX, posY, length, height);
    }
}
