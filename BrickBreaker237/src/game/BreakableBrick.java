package game;

public class BreakableBrick implements Brick {
	
	public int health;
	public int row;
	public int col;
	public int xDim;
	public int yDim;
	public int xCoordinate;
	public int yCoordinate;

	public BreakableBrick(int row, int col, int xDim, int yDim, int xCoordinate,int yCoordinate, int health){
		this.row=row;
		this.col=col;
		this.health=health;
		this.xDim=xDim;
		this.yDim=yDim;
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
	}

	@Override
	public void destroyBrick() {
		// TODO Auto-generated method stub
	}

	@Override
	public int damageBrick(int damage) {
		if(health >= damage){
			health -= damage;
		}
		else {
			health = 0;
		}
		
		return health;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getxDim() {
		return xDim;
	}

	public void setxDim(int xDim) {
		this.xDim = xDim;
	}

	public int getyDim() {
		return yDim;
	}

	public void setyDim(int yDim) {
		this.yDim = yDim;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
