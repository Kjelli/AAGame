package no.tobkje.aagame.gameobjects.player;

import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.baddies.HalfSaw;

public class ManCollisionListener implements CollisionListener {

	private final Man man;

	public ManCollisionListener(Man man) {
		this.man = man;
	}

	@Override
	public void onCollide(GameObject target) {
		if (target instanceof Ground && !man.isDead()) {
			man.land();
			// Nudge back over ground
			man.getPosition().y = (target.getPosition().y + target.getHeight() + 1);
		} else if (target instanceof HalfSaw && !man.isDead()) {
			man.die();
		}
	}

}
