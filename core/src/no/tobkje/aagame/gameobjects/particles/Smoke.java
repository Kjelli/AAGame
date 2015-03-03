package no.tobkje.aagame.gameobjects.particles;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Smoke extends AbstractParticle {
	public static final float WIDTH = 8, HEIGHT = 8;
	public static final float TIME_TO_LIVE = 1f;

	public Smoke(float x, float y, float velY) {
		super(x, y, WIDTH, HEIGHT, TIME_TO_LIVE);
		getVelocity().y = velY;
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.setColor(1.0f, 1.0f, 1.0f, 0.4f);
		batch.draw(Assets.smoke, getPosition().x, getPosition().y, getWidth(),
				getHeight());

		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	protected void updateParticle(float delta) {
		setWidth(getTimeToLive() / getMaximumTimeToLive() * WIDTH);
		setHeight(getTimeToLive() / getMaximumTimeToLive() * HEIGHT);
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

}
