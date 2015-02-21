package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;

public class Man extends AbstractGameObject {

	public static final float WIDTH = 47, HEIGHT = 64;

	private float runTime = 0;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);

		// TODO Auto-generated constructor stub
	}

	/*
	 * The meaning of runTime is to keep track of what MAN to render at what
	 * time, to draw the correct animation. Not sure if correct
	 * placement.(non-Javadoc)
	 * 
	 * @see no.tobkje.aagame.gameobjects.GameObject#update(float)
	 */
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
				Math.round(position.x), Math.round(position.y), WIDTH, HEIGHT);
		// TODO Auto-generated method stub

	}

}
