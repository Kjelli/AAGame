package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HalfSaw extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 24;

	public HalfSaw(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		setHitbox(new Hitbox(x, y, WIDTH - 10, 16, 5, 0));
	}

	@Override
	public void update(float delta) {
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.halfSaw, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
