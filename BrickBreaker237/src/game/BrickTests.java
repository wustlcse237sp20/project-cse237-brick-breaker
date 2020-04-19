package game;

import org.junit.Test;

public class BrickTests {
	
	@Test
	public void damageBreakableBrick() {
		int initialHealth = 3;
		int damageToDeal = 2;
		BreakableBrick brick = new BreakableBrick(0, 0, 1, 1, 0, 0, initialHealth);
		
		assert(initialHealth == brick.health);
		
		brick.damageBrick(damageToDeal);
		int newHealth = brick.health;
		int expectedHealth = initialHealth - damageToDeal;
		assert(newHealth == expectedHealth);
		
		int overkillDamage = brick.health + 1;
		int minimumHealth = 0;
		brick.damageBrick(overkillDamage);
		newHealth = brick.health;
		assert(newHealth == minimumHealth);
	}

}
