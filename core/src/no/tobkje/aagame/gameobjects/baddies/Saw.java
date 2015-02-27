package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.gameobjects.AbstractGameObject;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Saw extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 48;

	public Saw(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		getVelocity().y = -200;
	}

	@Override
	public void update(float delta) {
		move(delta);
		fallingSaw();
	}

	public void fallingSaw() {
		getVelocity().x = -PlayScreen.getLevelVelocity();
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.saw, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
