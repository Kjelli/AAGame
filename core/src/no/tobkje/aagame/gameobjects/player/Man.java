package no.tobkje.aagame.gameobjects.player;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionTest;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.gameobjects.AbstractGameObject;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.common.Gravity;
import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Quad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Man extends AbstractGameObject {

	public static final float WIDTH = 48, HEIGHT = 64;
	private static final float JUMP_VELOCITY = 300;

	private float runTime = 0;

	private Jetpack jetpack;
	private ManCollisionListener mcl;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		mcl = new ManCollisionListener(this);

		setHitbox(new Hitbox(x, y, WIDTH / 2, 40, WIDTH / 4, 0));
		getOrigin().x = WIDTH / 2;
		getOrigin().y = HEIGHT / 4;

		jetpack = new Jetpack();
	}

	@Override
	public void update(float delta) {
		runTime += delta;

		movementLogic(delta);

	}

	private void movementLogic(float delta) {

		jetpack.update(delta);
		if (jetpack.isThrusting()) {
			getAcceleration().y = jetpack.getThrust();
		}

		move(delta);
		if (!isOnGround()) {
			Gravity.fall(this, delta);
		}
		CollisionTest.simple(this, mcl);

		if (getPosition().y + getHeight() >= AAGame.GAME_HEIGHT) {
			getPosition().y = AAGame.GAME_HEIGHT - getHeight();
			getVelocity().y = -1;

		}

		if (getPosition().y + getHeight() < 0) {
			getParentScreen().reset();
		}
	}

	public void jetpack() {
		// Small burst for first jetpack-thrust
		if (jetpack.getEnergy() == jetpack.getMaxEnergy()) {
			getVelocity().y += 200;
		}
		jetpack.setThrusting(true);
		if (getPosition().y - getHeight() < AAGame.GAME_HEIGHT)
			getAcceleration().y = jetpack.getThrust();
	}

	public void jump() {
		getVelocity().y = JUMP_VELOCITY;
		setOnGround(false);

	}

	public void jumpRelease() {
		if (jetpack.isThrusting()) {
			jetpack.setThrusting(false);
			getAcceleration().y = 0;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		TextureRegion region;
		if (isOnGround()) {
			region = Assets.mAnimation.getKeyFrame(runTime);
		} else {
			// When jumping it displays one frame.
			if (jetpack.isThrusting()) {
				if (jetpack.getEnergy() > 0) {
					region = Assets.flyAnimation.getKeyFrame(runTime);
				} else {
					region = Assets.man_fly_nofuel;
				}
			} else {
				region = Assets.man_fly_nofuel;
			}

		}
		batch.draw(region, Math.round(getPosition().x),
				Math.round(getPosition().y), getOrigin().x, getOrigin().y,
				WIDTH, HEIGHT, 1.0f, 1.0f, getRotation());
	}

	@Override
	public void die() {
		super.die();
		if (!isOnGround())
			jumpRelease();
		getVelocity().x = PlayScreen.getLevelVelocity();
		PlayScreen.setLevelVelocity(0);
	}

	@Override
	public void land(GameObject target) {
		super.land(target);
		jetpack.setThrusting(false);
		jetpack.resetCooldown();
	}

	public void onClick() {
		if(isDead())
			return;
		if (isOnGround()) {
			jump();
		} else {
			jetpack();
		}

	}
}
