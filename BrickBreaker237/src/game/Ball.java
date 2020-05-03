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
    
    public Ball() {
        this.damage = 1;
        this.length = 20;
        this.height = 20;
        this.xPosition = 240;
        this.yPosition = 430;
        this.xDirection = 2;
        this.yDirection = -2;
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
	    myBallColor = specificColor;
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

    /**
	 * Looks at the positions and size of the ball to determine if it will hit a wall and, if so,
	 * changes the X and Y directions appropriately
	 * @param boardDim dimensions of board
     * @param posDirection magnitude of ball forward direction
     * @param negDirection magnitude of ball reverse direction
	 */
    public void manageWallCollision(int boardDim, int posDirection, int negDirection){
        if(this.getX() + this.getLength() > boardDim)
        {
            this.xDirection = negDirection;
        }
        if(this.getY() + this.getHeight() > boardDim)
        {
            this.yDirection = negDirection;
        }
        if(this.getX() < 0)
        {
            this.xDirection = posDirection;
        }
        if(this.getY() < 0)
        {
            this.yDirection = posDirection;
        }
    }
}
