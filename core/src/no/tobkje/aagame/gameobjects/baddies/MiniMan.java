package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.collisions.CollisionListener;
import no.tobkje.aagame.collisions.CollisionTest;
import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.common.Gravity;
import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MiniMan extends AbstractBaddie implements JumpDefeatable {
	public static final float WIDTH = 32, HEIGHT = 32;
	private CollisionListener minimanlistener;
	private double random;

	public MiniMan(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		random = Math.random() + 1;
		setWidth((float) (WIDTH * random));
		setHeight((float) (HEIGHT * random));
		minimanlistener = new MiniManCollisionListener();
		setHitbox(new Hitbox(x + getWidth() / 2, y + getHeight() / 4,
				getWidth() / 2, getHeight() / 2, getWidth() / 4,
				getHeight() / 8));
	}

	@Override
	public void draw(SpriteBatch batch) {
		TextureRegion tx;
		if (isDead())
			tx = Assets.baddie_blue_dead;
		else
			tx = Assets.baddie_blue_walk_animation.getKeyFrame(PlayScreen
					.getRuntime());
		batch.draw(tx, getPosition().x, getPosition().y, getOrigin().x,
				getOrigin().y, getWidth(), getHeight(), 1.0f, 1.0f,
				getRotation());
	}

	@Override
	public void update(float delta) {
		getVelocity().x = (float) (-PlayScreen.getLevelVelocity() - (50.0f * random));
		move(delta);
		CollisionTest.simple(this, minimanlistener);
		if (!isOnGround()) {
			Gravity.fall(this, delta);
		}

		if (getPosition().x + getWidth() < 0 || getPosition().y < 0)
			getParentScreen().despawn(this);
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
	public void defeat() {
		die();
	}

}
