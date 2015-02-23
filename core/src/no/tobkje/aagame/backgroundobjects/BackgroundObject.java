package no.tobkje.aagame.backgroundobjects;

import no.tobkje.aagame.backgrounds.Layer;
import no.tobkje.aagame.gameobjects.GameObject;

public interface BackgroundObject extends GameObject {
	Layer getParentLayer();

	void setParentLayer(Layer parentLayer);
}
