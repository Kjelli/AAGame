package no.tobkje.aagame.backgroundobjects;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceImage extends AbstractBackgroundObject {
	public static final float WIDTH = AAGame.GAME_WIDTH * 2,
			HEIGHT = AAGame.GAME_HEIGHT * 2;

	public SpaceImage() {
		super(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.space_bg, getPosition().x, getPosition().y, WIDTH,
				HEIGHT);
	}

	@Override
	public void update(float delta) {
		getVelocity().x = -PlayScreen.getLevelVelocity();
		move(delta);
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

}
