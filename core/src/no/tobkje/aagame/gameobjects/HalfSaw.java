package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;
import no.tobkje.aagame.screens.GameScreen;

public class HalfSaw extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 24;

	public HalfSaw(float x, float y) {
		super(x, y, WIDTH, HEIGHT);

	}

	@Override
	public void update(float delta) {
		move(delta);
		velocity.x = -GameScreen.getLevelVelocity();

	}

	@Override
	public void draw() {
		Batch.getBatch().draw(Assets.halfSaw, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
