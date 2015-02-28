package no.tobkje.aagame.collisions;

import java.util.ArrayList;

import no.tobkje.aagame.gameobjects.GameObject;

public class CollisionTest {
	public static final int UP = 1, RIGHT = 2, BELOW = 4, LEFT = 8;

	public static void simple(GameObject one, CollisionListener listener) {

		ArrayList<GameObject> others = one.getParentScreen().getObjects();
		for (GameObject other : others) {
			if (other == one)
				continue;
			if (one.intersects(other)) {
				int direction = determineDirection(one, other);
				listener.onCollide(other, direction);
			}
		}
	}
	/**
	 * Determine the angle between the objects relative from object <b>one</b>
	 * @param one - the first object
	 * @param other - the second object
	 * @return the angle between the two objects.
	 */
	public static int determineDirection(GameObject one, GameObject other) {
		double deltaX = one.getPosition().x - other.getPosition().x;
		double deltaY = other.getPosition().y - one.getPosition().y;
		double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
		return (int) angle;
	}

}
