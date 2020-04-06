package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball 
{
    private int posX;
    private int posY;
    private int dirX;
    private int dirY;
    private Color myBallColor;
    
    private int length = 20;
    private int height = 20;
    private Color red = Color.RED;
    
    public Ball()
    {
    	posX = 240;
    	posY = 430;
    	dirX = 3;
    	dirY = -3;
    	myBallColor = red;
    }
    
  //returns top left X position used to draw the ball
    public int getX()
    {
    	return posX;
    }
    
    //return top left Y position used to draw ball
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
    
    public int getXdir()
    {
    	return dirX;
    }
    
    public int getYdir()
    {
    	return dirY;
    }
    
    public void setXdir(int newXdir)
    {
    	dirX = newXdir;
    }
    
    public void setYdir(int newYdir)
    {
    	dirY = newYdir;
    }
    
    public void updatePos()
    {
    	posX += dirX;
    	posY += dirY;
    }
    
    public void draw(Graphics g)
    {
    	g.setColor(myBallColor);
    	g.fillOval(posX, posY, length, height);
    }
}
