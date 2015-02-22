package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
		getPosition().add(getVelocity().cpy().scl(delta));

		if (getPosition().x + getWidth() < 0) {
			getPosition().x += Gdx.graphics.getWidth() + getWidth();
			tx = determineTexture();
		}

		getVelocity().x = -PlayScreen.getLevelVelocity();
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(tx, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
