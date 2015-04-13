package no.tobkje.aagame.collisions;

import no.tobkje.aagame.gameobjects.GameObject;

public interface CollisionListener {
	void onCollide(GameObject target, int direction);
}
