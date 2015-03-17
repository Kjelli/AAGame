package no.tobkje.aagame.tweens;

import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Quad;

public class GameObjectTweens {
	public static void frontFlip(GameObject go) {
		Tween.to(go, GameObjectAccessor.ROTATION, 0).target(0)
				.start(go.getParentScreen().getTweenManager());
		Tween.to(go, GameObjectAccessor.ROTATION, 2f).target(-1500)
				.ease(Quad.IN).start(go.getParentScreen().getTweenManager());
	}
}
