package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreLabel extends AbstractHudElement {
	public static String DRAW_STRING = "SCORE";
	public static float WIDTH = Assets.font20.getBounds(DRAW_STRING).width;
	public static float HEIGHT = Assets.font20.getCapHeight();

	public ScoreLabel(HudLayer parentLayer, float x, float y) {
		super(parentLayer, x, y, 10,10);
	}

	@Override
	public void draw(SpriteBatch batch) {
		Assets.font20.draw(batch, DRAW_STRING, getPosition().x, getPosition().y);
	}

	@Override
	public void onSpawn() {
		
	}

	@Override
	public void update(float delta) {
		
	}

}
