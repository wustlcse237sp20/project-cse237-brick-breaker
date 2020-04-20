package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball 
{
    private int posX;
    private int posY;
    private int dirX;
    private int dirY;
    public Color color;
    public int damage = 1;
    
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
	    	color = Color.RED;
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
    
    public void applyPowerUp(PowerUpBrick powerUp) {
    	PowerUpType type = powerUp.getType();
    	switch(type) {
	    	case DAMAGE: {
	    		damage = damage * powerUp.getMultiplier();
	    	}
		default:
			break;
    	}
    	
    }
    
    public void draw(Graphics g)
    {
    		g.setColor(color);
    		g.fillOval(posX, posY, length, height);
    }
}
