package no.tobkje.aagame.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.tobkje.aagame.gameobjects.AbstractGameObject;

public abstract class AbstractHudElement extends AbstractGameObject implements
		HudElement {

	public AbstractHudElement(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

}
