package game;

import java.awt.Color;

enum PowerUpType {
    DAMAGE,
    SPEED,
    LIVES
}
public class PowerUpBrick implements Brick {
	private PowerUpType type;
	private int multiplier;
	public int health = 1;
	public int xDim;
	public int yDim;
	public int xCoordinate;
	public int yCoordinate;
	
	public PowerUpBrick(int xDim, int yDim, int xCoordinate,int yCoordinate, PowerUpType type, int multiplier){
		this.xDim=xDim;
		this.yDim=yDim;
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.type = type;
		this.multiplier = multiplier;
	}

	@Override
	public int damageBrick(int damage) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public PowerUpType getType() {
		return type;
	}
	
	public Color getColor() {
		switch(type) {
			case DAMAGE:
				return Color.RED;
		default:
			return Color.BLACK;
		}
	}
	
	public int getMultiplier() {
		return multiplier;
	}

}
