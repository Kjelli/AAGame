package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.Batch;
import no.tobkje.aagame.assets.Assets;

public class Dummy extends AbstractGameObject {
	public static final float WIDTH = 64, HEIGHT = 64;

	public Dummy(float x, float y) {
		super(x, y, WIDTH, HEIGHT);

	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void draw() {
		Batch.getBatch().draw(Assets.sprite1, position.x, position.y);
	}

}
