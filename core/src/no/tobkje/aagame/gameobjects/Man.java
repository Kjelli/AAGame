package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

	TweenManager manager;

	public Man(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		mcl = new ManCollisionListener();

		setHitbox(new Hitbox(x, y, WIDTH / 2, 40, WIDTH / 8, 0));
		Tween.registerAccessor(AbstractGameObject.class,
				new GameObjectAccessor());
		manager = new TweenManager();
	}

	@Override
	public void update(float delta) {
		manager.update(delta);
		runTime += delta;
		move(delta);
		CollisionTest.simple(this, mcl);
		if(getPosition().y + getHeight() < 0){
			getParentScreen().reset();
			System.out.println("RESET");
		}
	}

	public void jump() {
		if (onGround) {
			getVelocity().y = JUMP_VELOCITY;
			getAcceleration().y = -600; // TODO: Centralize gravity
			onGround = false;
			Tween.to(this, GameObjectAccessor.ROTATION, 100).target(360)
					.start(manager);
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.mAnimation.getKeyFrame(runTime),
				Math.round(getPosition().x), Math.round(getPosition().y), 0, 0,
				WIDTH, HEIGHT, 1.0f, 1.0f, getRotation());
		System.out.println(getRotation());
	}

	public void die() {
		PlayScreen.setLevelVelocity(0);
		getVelocity().y = 200;
		getAcceleration().y = -300;
		isDead = true;
		onGround = false;
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
