package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GroundFiller extends AbstractGameObject {

	public GroundFiller(float y) {
		super(0, 0, Gdx.graphics.getWidth(), y);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.groundFiller, getPosition().x, getPosition().y,
				getWidth(), getHeight());

	}
}
