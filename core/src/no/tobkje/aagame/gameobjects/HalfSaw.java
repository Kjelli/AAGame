package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HalfSaw extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 24;
	public static final float y = -60 + Ground.HEIGHT;

	public HalfSaw(float x) {
		super(x, y, WIDTH, HEIGHT);
		setHitbox(new Hitbox(x, y, WIDTH - 10, 16, 5, 0));
		
	}

	@Override
	public void update(float delta) {
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
		moveHalfSaw();
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.halfSaw, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

	// Kjelli wouldn't like :(
	public void moveHalfSaw() {
		if (getPosition().x + getWidth() < 0) {
			getPosition().x += ((getParentScreen().getCamera().viewportWidth + getWidth()) * (Math
					.random() + 1));
		}
	}

}
