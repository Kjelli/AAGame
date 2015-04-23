package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class FuelLabel extends AbstractHudElement {
	public static final BitmapFont font = Assets.font20;
	public static final String DRAW_STRING = "FUEL";
	public static final float WIDTH = font.getBounds(DRAW_STRING).width;
	public static final float HEIGHT = font.getCapHeight();

	public FuelLabel(HudLayer parentLayer, float x, float y) {
		super(parentLayer, x, y, WIDTH, HEIGHT);
	}

	@Override
	public void draw(SpriteBatch batch) {
		font.draw(batch, DRAW_STRING, getPosition().x, getPosition().y);
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

}
