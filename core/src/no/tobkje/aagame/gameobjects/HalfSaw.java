package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HalfSaw extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 24;

	public HalfSaw(float x, float y) {
		super(x, y, WIDTH, HEIGHT);

	}

	@Override
	public void update(float delta) {
		move(delta);
		getVelocity().x = -PlayScreen.getLevelVelocity();

	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.halfSaw, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
