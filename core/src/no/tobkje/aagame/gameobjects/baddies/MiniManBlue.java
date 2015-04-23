package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MiniManBlue extends AbstractMiniMan implements JumpDefeatable {

	public MiniManBlue(float x, float y) {
		super(x, y);
	}

	public MiniManBlue(float x, float y, float scale) {
		super(x, y, scale);
	}

	@Override
	public void draw(SpriteBatch batch) {
		TextureRegion tx;
		if (isDead())
			tx = Assets.baddie_blue_dead;
		else
			tx = Assets.baddie_blue_walk_animation
					.getKeyFrame((float) (PlayScreen.getRuntime() * (3 / getScale())));
		batch.draw(tx, getPosition().x, getPosition().y, getOrigin().x,
				getOrigin().y, getWidth(), getHeight(), 1.0f, 1.0f,
				getRotation());
	}

	@Override
	public void defeat() {
		die();
	}

}
