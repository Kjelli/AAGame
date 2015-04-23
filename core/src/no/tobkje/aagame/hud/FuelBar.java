package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.gameobjects.player.Jetpack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class FuelBar extends AbstractHudElement {
	private Jetpack jetpack;
	private static final float MAX_WIDTH = 120;

	private float drawWidth = MAX_WIDTH;

	public FuelBar(HudLayer hudLayer, float x, float y) {
		super(hudLayer, x, y, MAX_WIDTH, 20);
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
		batch.draw(tx, getPosition().x, getPosition().y, drawWidth, getHeight());
		batch.draw(Assets.hud_fuel_frame, getPosition().x, getPosition().y,
				getWidth(), getHeight());
		batch.draw(Assets.hud_fuel_frame_left_edge, getPosition().x - 8,
				getPosition().y, 8, getHeight());
		batch.draw(Assets.hud_fuel_frame_right_edge, getPosition().x
				+ getWidth(), getPosition().y, 8, getHeight());
	}

	@Override
	public void update(float delta) {
		if (jetpack == null)
			return;
		float targetX = Math.max(jetpack.getEnergy() / jetpack.getMaxEnergy()
				* getWidth(), 0);
		drawWidth = (drawWidth * 8.5f + targetX * 1.5f) / 10;
	}

	public void bind(Jetpack jetpack) {
		this.jetpack = jetpack;
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

}
