package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Man extends AbstractGameObject {

	// Height and Width of Man, specified.
	public static final float WIDTH = 47, HEIGHT = 64;
<<<<<<< HEAD
	private static final float JUMP_VELOCITY = 200;

=======
	
	/**
	 * The runTime variable keeps track of what MAN to render at what time.
	 * Is incremented with delta, in the update method.
	 */
>>>>>>> origin/gameObjects
	private float runTime = 0;
	private boolean onGround = true;
	private ManCollisionListener mcl;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
<<<<<<< HEAD
		mcl = new ManCollisionListener();
=======
>>>>>>> origin/gameObjects
	}

	@Override
	public void update(float delta) {
		runTime += delta;
		CollisionTest.simple(this, mcl);
		move(delta);
	}

	public void jump() {
		if (onGround) {
			getVelocity().y = JUMP_VELOCITY;
			getAcceleration().y = -200; //TODO: Centralize gravity
			onGround = false;
		}
	}

	@Override
<<<<<<< HEAD
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.mAnimation.getKeyFrame(runTime),
				Math.round(getPosition().x), Math.round(getPosition().y),
				WIDTH, HEIGHT);
		// TODO Auto-generated method stub

=======
	public void draw() {
		Batch.getBatch().draw(Assets.mAnimation.getKeyFrame(runTime),
				Math.round(getPosition().x), Math.round(getPosition().y), WIDTH, HEIGHT);
>>>>>>> origin/gameObjects
	}

	class ManCollisionListener implements CollisionListener {
		@Override
		public void onCollide(GameObject target) {
			if (target instanceof Ground) {
				onGround = true;
				getVelocity().y = 0;
				getAcceleration().y = 0;
				// Nudge back over ground
				getPosition().y = (target.getPosition().y + target.getHeight() + 1);
			}
		}

	}

}
