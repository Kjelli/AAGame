package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.common.Gravity;
import no.tobkje.aagame.screens.PlayScreen;

public abstract class AbstractMiniMan extends AbstractBaddie implements MiniMan {
	public static final float WIDTH = 32, HEIGHT = 32;
	private CollisionListener minimanlistener;
	private float scale;

	public AbstractMiniMan(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		setScale((float) (Math.random() * 2f + 1));
		setWidth((float) (WIDTH * getScale()));
		setHeight((float) (HEIGHT * getScale()));
		getOrigin().x = getWidth() / 2;
		getOrigin().y = getHeight() / 4;
		minimanlistener = new MiniManCollisionListener();
		setHitbox(new Hitbox(x + getWidth() / 2, y + getHeight() / 4,
				getWidth() / 2, getHeight() / 2, getWidth() / 4,
				getHeight() / 8));
	}

	@Override
	public void update(float delta) {
		getVelocity().x = (float) (-PlayScreen.getLevelVelocity() - (50.0f / getScale()));
		move(delta);
		CollisionTest.simple(this, minimanlistener);
		if (!isOnGround()) {
			Gravity.fall(this, delta);
		}

		if (getPosition().x + getWidth() < 0
				|| getPosition().y + getHeight() < 0)
			getParentScreen().despawn(this);
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float random) {
		this.scale = random;
	}

	class MiniManCollisionListener implements CollisionListener {

		@Override
		public void onCollide(GameObject target, int direction) {
			if (isDead())
				return;
			if (target instanceof Ground) {
				land(target);
			}
		}

	}

	@Override
	public void onSpawn() {
		// TODO
	}
}
