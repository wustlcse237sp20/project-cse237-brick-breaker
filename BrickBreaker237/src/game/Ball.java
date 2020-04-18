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

    private int initX = 240;
    private int initY = 430;
    private int initDirX = 3;
    private int initDirY = -3;

    public Ball()
    {
	    	posX = initX;
	    	posY = initY;
	    	dirX = initDirX;
	    	dirY = -initDirY;
	    	myBallColor = Color.RED;
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
