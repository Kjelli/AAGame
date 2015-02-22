package no.tobkje.aagame.collisions;

import java.util.ArrayList;

import no.tobkje.aagame.gameobjects.GameObject;

public class CollisionTest {
	public static void simple(GameObject one, CollisionListener listener) {

		ArrayList<GameObject> others = one.getParentScreen().getObjects();
		for (GameObject other : others) {
			if (other == one)
				continue;
			if (one.intersects(other)) {
				listener.onCollide(other);
			}
		}
	}
}
