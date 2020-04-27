package game;

import java.awt.Graphics;
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
    private int initX;
    private int initY;
    private int initDirX;
    private int initDirY;
    ArrayList<Color> possibleBallColors = new ArrayList<Color>( Arrays.asList(Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE));

    
    public Ball() {
        this.damage = 1;
        this.length = 20;
        this.height = 20;
        this.initX = 240;
        this.initY = 430;
        this.initDirX = 3;
        this.initDirY = -3;
        this.posX = this.initX;
        this.posY = this.initY;
        this.dirX = this.initDirX;
        this.dirY = -this.initDirY;
        this.color = Color.RED;
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
    
    public void updatePos() {
        this.posX += this.dirX;
        this.posY += this.dirY;
    }
    
    public void applyPowerUp(final PowerUpBrick powerUpBrick) {
        switch (Ball.Ball$1.$SwitchMap$game$PowerUpType[powerUpBrick.getType().ordinal()]) {
            case 1: {
                this.damage *= powerUpBrick.getMultiplier();
                break;
            }
        }
    }
    
    public void draw(final Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(this.posX, this.posY, this.length, this.height);
    }
}
