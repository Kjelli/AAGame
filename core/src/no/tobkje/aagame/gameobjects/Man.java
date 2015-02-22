package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;

public class Man extends AbstractGameObject {

	// Height and Width of Man, specified.
	public static final float WIDTH = 47, HEIGHT = 64;
	
	/**
	 * The runTime variable keeps track of what MAN to render at what time.
	 * Is incremented with delta, in the update method.
	 */
	private float runTime = 0;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void update(float delta) {
		runTime += delta;
		move(delta);
	}

	public void onClick() {
		velocity.y = 140;
	}

	@Override
	public void draw() {
		Batch.getBatch().draw(Assets.mAnimation.getKeyFrame(runTime),
				Math.round(getPosition().x), Math.round(getPosition().y), WIDTH, HEIGHT);
	}

}
