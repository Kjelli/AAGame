package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Spike extends AbstractBaddie {

	public static final float WIDTH = 32, HEIGHT = 32;

	public Spike(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		setHitbox(new Hitbox(x, y, WIDTH - 10, HEIGHT - 15, 5, 0));
	}

	@Override
	public void update(float delta) {
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.spike, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

}
