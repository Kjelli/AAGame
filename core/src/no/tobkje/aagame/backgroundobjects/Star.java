package no.tobkje.aagame.backgroundobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Star extends AbstractBackgroundObject {
	public static final float WIDTH = 48, HEIGHT = 48;

	public Star(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.saw, getPosition().x, getPosition().y, WIDTH, HEIGHT);
	}

	@Override
	public void update(float delta) {
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
	}
}
