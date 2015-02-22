package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;
import no.tobkje.aagame.screens.GameScreen;

public class Saw extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 48;

	public Saw(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		velocity.y = -200;
	}

	@Override
	public void update(float delta) {
		move(delta);
		fallingSaw();
	}

	public void fallingSaw() {
		velocity.x = -GameScreen.getLevelVelocity();
	}

	@Override
	public void draw() {
		Batch.getBatch().draw(Assets.saw, Math.round(getPosition().x),
				Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
