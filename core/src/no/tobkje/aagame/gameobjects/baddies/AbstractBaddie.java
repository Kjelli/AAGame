package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.gameobjects.AbstractGameObject;
import no.tobkje.aagame.gameobjects.player.Man;

public abstract class AbstractBaddie extends AbstractGameObject implements
		Baddie {

	public AbstractBaddie(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void hurt(Man man) {
		man.die();
	}
}
