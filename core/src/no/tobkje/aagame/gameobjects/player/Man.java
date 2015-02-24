package no.tobkje.aagame.gameobjects.player;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.gameobjects.AbstractGameObject;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.HalfSaw;
import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quad;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Man extends AbstractGameObject {

	public static final float WIDTH = 47, HEIGHT = 64;
	private static final float JUMP_VELOCITY = 300;
	public static final float GRAVITY = -600; // TODO: Centralize gravity

	private float runTime = 0;
	private boolean jetpacking = false;
	private boolean onGround = true;
	private boolean isDead = false;

	private Jetpack jetpack;
	private ManCollisionListener mcl;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		mcl = new ManCollisionListener(this);

		setHitbox(new Hitbox(x, y, WIDTH / 2, 40, WIDTH / 8, 0));
		getOrigin().x = WIDTH / 2;
		getOrigin().y = HEIGHT / 4;

		jetpack = new Jetpack(this);
	}

	@Override
	public void update(float delta) {
		runTime += delta;

		movementLogic(delta);

	}

	private void movementLogic(float delta) {

		jetpack.update(delta);
		if (jetpacking) {
			getAcceleration().y = jetpack.getThrust();
		}

		move(delta);

		CollisionTest.simple(this, mcl);
		
		if(getPosition().y + getHeight() > AAGame.GAME_HEIGHT){
			getPosition().y = AAGame.GAME_HEIGHT - getHeight();
			getVelocity().y = 0;
		}
		
		if (getPosition().y + getHeight() < 0) {
			getParentScreen().reset();
		}
	}

	public void jump() {
		if (isOnGround()) {
			getVelocity().y = JUMP_VELOCITY;
			getAcceleration().y = GRAVITY; // TODO: Centralize gravity
			setOnGround(false);
		} else {
			jetpacking = true;
			jetpack.setThrusting(true);
			if (getPosition().y - getHeight() < AAGame.GAME_HEIGHT)
				getAcceleration().y = jetpack.getThrust();
			else
				getAcceleration().y = GRAVITY;
		}
	}

	public void jumpRelease() {
		if (jetpacking) {
			getAcceleration().y = GRAVITY;
			jetpack.setThrusting(false);
			jetpacking = false;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		TextureRegion region;
		if (isOnGround()) {
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
		setDead(true);
		setOnGround(false);
	}

	private void frontFlip() {
		Tween.to(this, GameObjectAccessor.ROTATION, 0).target(0)
				.start(getParentScreen().getTweenManager());
		Tween.to(this, GameObjectAccessor.ROTATION, 2f).target(-720)
				.ease(Quad.IN).start(getParentScreen().getTweenManager());
	}

	public boolean isOnGround() {
		return onGround;
	}

	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void land() {
		jetpack.setThrusting(false);
		jetpacking = false;
		jetpack.resetCooldown();
		setOnGround(true);
		getVelocity().y = 0;
		getAcceleration().y = 0;
	}

}
