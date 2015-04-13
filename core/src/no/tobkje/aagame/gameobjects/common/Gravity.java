package no.tobkje.aagame.gameobjects.common;

import no.tobkje.aagame.gameobjects.GameObject;

public class Gravity {
	public static final float ACCELERATION = -600f;

	public static void fall(GameObject go, float delta) {
		go.getVelocity().y += ACCELERATION * delta;
	}
}
