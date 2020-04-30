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

	public int getxDim() {
		return xDim;
	}

	public int getyDim() {
		return yDim;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}
	
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	public boolean monitorCollision(Ball myBall, BreakableBrick brick)
	{

		int blockX = brick.getxCoordinate();
		int blockY = brick.getyCoordinate();
		int blockXDim = brick.getxDim();
		int blockYDim = brick.getyDim();

		if(brick.getHealth() > 0){
			//top side
			if((myBall.getX() + myBall.getLength() > blockX && myBall.getX() < blockX + blockXDim) 
					&& (myBall.getY() - myBall.getHeight() < blockY  && myBall.getY() > blockY - blockYDim))
			{
				myBall.yDirection = -1*myBall.yDirection;
				brick.damageBrick(myBall.damage);
				return true;
			}
			
			//right side
			if((myBall.getX() + myBall.getLength() > blockX && myBall.getX() < blockX + blockXDim) 
				&& (myBall.getY() - myBall.getHeight() < blockY  && myBall.getY() > blockY - blockYDim))
			{
				myBall.xDirection = -1*myBall.xDirection;
				brick.damageBrick(myBall.damage);
				return true;
			}

			//bottom side
			if((myBall.getX() > blockX && myBall.getX() < blockX + blockXDim) 
					&& (myBall.getY() < blockY  && myBall.getY() > blockY - blockYDim))
			{
				myBall.yDirection = -1*myBall.yDirection;
				brick.damageBrick(myBall.damage);
				return true;
			}

			//left side
			if((myBall.getX() > blockX && myBall.getX() < blockX + blockXDim) 
					&& (myBall.getY() < blockY  && myBall.getY() > blockY - blockYDim))
			{
				myBall.xDirection = -1*myBall.xDirection;
				brick.damageBrick(myBall.damage);
				return true;
			}
		}

		return false;
	}
}
