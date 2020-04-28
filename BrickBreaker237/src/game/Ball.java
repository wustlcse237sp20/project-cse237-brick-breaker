package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class Ball
{
    private int xPosition;
    private int yPosition;
    public int xDirection;
    public int yDirection;
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
        this.xPosition = 240;
        this.yPosition = 430;
        this.xDirection = 3;
        this.yDirection = -3;
        this.myBallColor = Color.RED;
    }
    
    public int getX() {
        return this.xPosition;
    }
    
    public int getY() {
        return this.yPosition;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public Color getColor() {
    	return this.myBallColor;
    }
    
    public Color changeColor(Color specificColor)
    {
	    if(possibleBallColors.contains(specificColor))
	    {
	    	myBallColor = specificColor;
	    }
	    else
	    {
	    	myBallColor = Color.BLACK;
	    }
	    
	    return myBallColor;
    }
    
    public void moveOneStep() {
        this.xPosition += this.xDirection;
        this.yPosition += this.yDirection;
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
        graphics.fillOval(this.xPosition, this.yPosition, this.length, this.height);
    }
}
