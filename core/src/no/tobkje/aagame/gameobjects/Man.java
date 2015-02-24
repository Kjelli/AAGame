package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quad;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Man extends AbstractGameObject {

	// Height and Width of Man, specified.
	public static final float WIDTH = 47, HEIGHT = 64;
	private static final float JUMP_VELOCITY = 300;

	/**
	 * The runTime variable keeps track of what MAN to render at what time. Is
	 * incremented with delta, in the update method.
	 */
	private float runTime = 0;
	private boolean onGround = true;
	private boolean isDead = false;
	private ManCollisionListener mcl;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		mcl = new ManCollisionListener();

		setHitbox(new Hitbox(x, y, WIDTH / 2, 40, WIDTH / 8, 0));
		getOrigin().x = WIDTH / 2;
		getOrigin().y = HEIGHT / 4;
	}

	@Override
	public void update(float delta) {
		runTime += delta;
		move(delta);
		CollisionTest.simple(this, mcl);
		if (getPosition().y + getHeight() < 0) {
			getParentScreen().reset();
		}
	}

	public void jump() {
		if (onGround) {
			getVelocity().y = JUMP_VELOCITY;
			getAcceleration().y = -600; // TODO: Centralize gravity
			onGround = false;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		TextureRegion region;
		if (onGround) {
			region = Assets.mAnimation.getKeyFrame(runTime);
		} else {
			// When jumping it displays one frame.
			region = Assets.man_walk[3];
		}
		batch.draw(region, Math.round(getPosition().x),
				Math.round(getPosition().y), getOrigin().x, getOrigin().y,
				WIDTH, HEIGHT, 1.0f, 1.0f, getRotation());
	}

	public void die() {
		getVelocity().x = PlayScreen.getLevelVelocity();
		PlayScreen.setLevelVelocity(0);
		frontFlip();
		getVelocity().y = 200;
		getAcceleration().y = -300;
		isDead = true;
		onGround = false;
	}

	private void frontFlip() {
		Tween.to(this, GameObjectAccessor.ROTATION, 0).target(0)
				.start(getParentScreen().getTweenManager());
		Tween.to(this, GameObjectAccessor.ROTATION, 2f).target(-720)
				.ease(Quad.IN).start(getParentScreen().getTweenManager());
	}

	class ManCollisionListener implements CollisionListener {

		@Override
		public void onCollide(GameObject target) {
			if (target instanceof Ground && !isDead) {
				onGround = true;
				getVelocity().y = 0;
				getAcceleration().y = 0;

				// Nudge back over ground
				getPosition().y = (target.getPosition().y + target.getHeight() + 1);
				getHitbox().toRectangle().y = (target.getPosition().y
						+ target.getHeight() + 1);
			} else if (target instanceof HalfSaw && !isDead) {
				die();
			}
		}

	}

}
