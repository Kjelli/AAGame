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

public class MiniManSpike extends AbstractMiniMan {
	public MiniManSpike(float x, float y) {
		super(x, y);
	}

	@Override
	public void draw(SpriteBatch batch) {
		TextureRegion tx;
		if (isDead())
			tx = Assets.baddie_spike_dead;
		else
			tx = Assets.baddie_spike_walk_animation
					.getKeyFrame((float) (PlayScreen.getRuntime() * (3 / getScale())));
		batch.draw(tx, getPosition().x, getPosition().y, getOrigin().x,
				getOrigin().y, getWidth(), getHeight(), 1.0f, 1.0f,
				getRotation());
	}

}
