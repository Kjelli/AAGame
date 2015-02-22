package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;
import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ground extends AbstractGameObject {
	public static final float WIDTH = 64, HEIGHT = 64;

	private TextureRegion tx;

	public Ground(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		tx = determineTexture();
	}

	private TextureRegion determineTexture() {
		return (Math.random() > 0.5f ? Assets.groundTop : Assets.groundTop2);
	}

	@Override
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));

		if (position.x + width < 0) {
			position.x += Gdx.graphics.getWidth() + width;
			tx = determineTexture();
		}

		velocity.x = -GameScreen.getLevelVelocity();
	}

	@Override
	public void draw() {
		Batch.getBatch().draw(tx, Math.round(position.x),
				Math.round(position.y), WIDTH, HEIGHT);
	}

}
