package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Man extends AbstractGameObject {

	public static final float WIDTH = 47, HEIGHT = 64;
	private static final float JUMP_VELOCITY = 200;

	private float runTime = 0;
	private boolean onGround = true;
	private ManCollisionListener mcl;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		mcl = new ManCollisionListener();
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
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.mAnimation.getKeyFrame(runTime),
				Math.round(getPosition().x), Math.round(getPosition().y),
				WIDTH, HEIGHT);
		// TODO Auto-generated method stub

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
