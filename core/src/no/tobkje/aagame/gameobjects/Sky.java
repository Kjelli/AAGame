package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sky extends AbstractGameObject {

	public Sky() {
		super(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void update(float delta) {
		// TODO
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.sky, getPosition().x, getPosition().y,
				getWidth(), getHeight());
	}

}
