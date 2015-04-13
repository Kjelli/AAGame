package no.tobkje.aagame.gameobjects.player;

import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.baddies.Baddie;
import no.tobkje.aagame.gameobjects.baddies.JumpDefeatable;

public class ManCollisionListener implements CollisionListener {

	private final Man man;

	public ManCollisionListener(Man man) {
		this.man = man;
	}

	@Override
	public void onCollide(GameObject target, int direction) {
		if (man.isDead())
			return;
		if (target instanceof Ground) {
			man.land(target);
		} else if (target instanceof Baddie && !target.isDead()) {
			if (target instanceof JumpDefeatable) {
				System.out.println(direction);
				boolean defeats = (direction < -40 && direction > -120);
				if (defeats) {
					((JumpDefeatable) target).defeat();
					man.getJetpack().restoreEnergy(0.2f);
					man.land(target);
					man.score(1);
					man.jump();
				} else
					((Baddie) target).hurt(man);
			} else {
				((Baddie) target).hurt(man);
			}
		}
	}
}
