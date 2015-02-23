package no.tobkje.aagame.backgroundobjects;

import no.tobkje.aagame.backgrounds.Layer;
import no.tobkje.aagame.gameobjects.AbstractGameObject;

public abstract class AbstractBackgroundObject extends AbstractGameObject
		implements BackgroundObject {

	private Layer parentLayer;

	public AbstractBackgroundObject(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void setParentLayer(Layer layer) {
		this.parentLayer = layer;
	}

	@Override
	public void move(float delta) {
		super.move(delta * parentLayer.getRelative_velocity());
	}
	

	@Override
	public Layer getParentLayer() {
		return parentLayer;
	}

}
