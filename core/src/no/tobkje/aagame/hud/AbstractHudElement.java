package no.tobkje.aagame.hud;

import no.tobkje.aagame.gameobjects.AbstractGameObject;
import no.tobkje.aagame.gameobjects.GameObject;

public abstract class AbstractHudElement extends AbstractGameObject implements
		HudElement {

	HudLayer parentLayer;

	public AbstractHudElement(HudLayer parentLayer, float x, float y,
			float width, float height) {
		super(x, y, width, height);
		this.parentLayer = parentLayer;
	}

	@Override
	public HudLayer getParentLayer() {
		return parentLayer;
	}

	@Override
	public void destroy() {
		parentLayer.removeHudElement(this);
	}

	public void bind(GameObject object) {
		System.err
				.println("You must override bind to actually have any hudelement-specific behaviour");
		return;
	}
}
