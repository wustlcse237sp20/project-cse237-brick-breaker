package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class Ball
{
    private int posX;
    private int posY;
    private int dirX;
    private int dirY;
    private Color myBallColor;
    public int damage;
    private int length;
    private int height;
    ArrayList<Color> possibleBallColors = new ArrayList<Color>( 
    	Arrays.asList(
    		Color.RED, 
    		Color.BLACK, 
    		Color.BLUE,
    		Color.CYAN, 
    		Color.GRAY, 
    		Color.GREEN, 
    		Color.MAGENTA, 
    		Color.ORANGE
    ));

    
    public Ball() {
        this.damage = 1;
        this.length = 20;
        this.height = 20;
        this.posX = 240;
        this.posY = 430;
        this.dirX = 3;
        this.dirY = -3;
        this.myBallColor = Color.RED;
    }
	
    public void changeColor(Color specificColor)
    {
	    if(possibleBallColors.contains(specificColor))
	    {
	    	myBallColor = specificColor;
	    }
	    else
	    {
	    	myBallColor = Color.BLACK;
	    }
    }
    
    public int getX() {
        return this.posX;
    }
    
    public int getY() {
        return this.posY;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public int getXdir() {
        return this.dirX;
    }
    
    public int getYdir() {
        return this.dirY;
    }
    
    public void setXdir(final int dirX) {
        this.dirX = dirX;
    }
    
    public void setYdir(final int dirY) {
        this.dirY = dirY;
    }
    
    public void moveOneStep() {
        this.posX += this.dirX;
        this.posY += this.dirY;
    }
    
    public void applyPowerUp(PowerUpBrick powerUp) {
    	PowerUpType type = powerUp.getType();
    	switch(type) {
	    	case DAMAGE: {
	    		damage = damage * powerUp.getMultiplier();
	    	}
	    	case SPEED: {
	    		//TODO: Add speed based powerup
	    		break;
	    	}
	    	case LIVES: {
	    		//TODO: Give extra life
	    	}
	    	default:
	    		break;
    	}

    }
    
    public void draw(final Graphics graphics) {
        graphics.setColor(this.myBallColor);
        graphics.fillOval(this.posX, this.posY, this.length, this.height);
    }
}
