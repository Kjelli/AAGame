package no.tobkje.aagame.backgroundobjects;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Star extends AbstractBackgroundObject {
	public static final float WIDTH = 4, HEIGHT = 4;

	public Star(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		float determinant = (float) Math.random() * 0.5f + 0.2f;
		setWidth(WIDTH * determinant);
		setHeight(HEIGHT * determinant);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.star, getPosition().x, getPosition().y, getWidth(),
				getHeight());
	}

	@Override
	public void update(float delta) {
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
		if (getPosition().x + getWidth() < 0)
			getPosition().x = AAGame.GAME_WIDTH + getWidth();
	}
}
