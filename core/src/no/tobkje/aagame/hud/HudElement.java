package no.tobkje.aagame.hud;

import no.tobkje.aagame.gameobjects.GameObject;

public interface HudElement extends GameObject {
	HudLayer getParentLayer();

	/**
	 * Bind a specific gameobject to the hudelement. This is required when a
	 * hudelement is displaying information relative to a gameobject, for
	 * instance lives, fuel, score etc. </br> <b>Do not use this method without
	 * overriding it. If overriding, do not call super.bind(object)</b> Every
	 * different implementation of a HudElement would require different
	 * information from the gameobjects, depending on your implementation.
	 * 
	 * @param object
	 *            The object to bind to this HudElement
	 */
	void bind(GameObject object);
}
