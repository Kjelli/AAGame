package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ground extends AbstractGameObject {
	public static final float WIDTH = 64, HEIGHT = 120;

	public Ground(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void update(float delta) {

		if (getPosition().x + getWidth() < 0) {
			setX(getPosition().x += AAGame.GAME_WIDTH + 2 * getWidth());
		}

		getVelocity().x = -PlayScreen.getLevelVelocity();

		move(delta);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.ground, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

}
