package game;

public class BreakableBrick implements Brick {
	public int health;
	public int x;
	public int y;

	public BreakableBrick(int x, int y, int health){
		this.x=x;
		this.y=y;
		this.health=health;

	}

	@Override
	public void destroyBrick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void damageBrick() {
		health-=1;
		if(health<1){
			destroyBrick();
		}
		
	}

}
