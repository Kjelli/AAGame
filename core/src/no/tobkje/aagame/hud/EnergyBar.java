package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.gameobjects.player.Jetpack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnergyBar extends AbstractHudElement {
	private Jetpack jetpack;
	private static final float MAX_WIDTH = 100;

	public EnergyBar(float x, float y) {
		super(x, y, MAX_WIDTH, 16);
	}

	@Override
	public void draw(SpriteBatch batch) {
		if (jetpack == null)
			return;
		TextureRegion tx;
		if (jetpack.getEnergy() >= jetpack.getMaxEnergy() * 0.66f)
			tx = Assets.hud_fuel_high;
		else if (jetpack.getEnergy() >= jetpack.getMaxEnergy() * 0.33f)
			tx = Assets.hud_fuel_medium;
		else
			tx = Assets.hud_fuel_low;

		batch.enableBlending();
		batch.draw(Assets.hud_fuel_frame, getPosition().x, getPosition().y,
				MAX_WIDTH, getHeight());
		batch.draw(tx, getPosition().x, getPosition().y, getWidth(),
				getHeight());

		// TODO better place:
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public void update(float delta) {
		if (jetpack != null)
			setWidth(Math.max(jetpack.getEnergy() / jetpack.getMaxEnergy()
					* MAX_WIDTH, 0));
	}

	public void bind(Jetpack jetpack) {
		this.jetpack = jetpack;
	}

}
