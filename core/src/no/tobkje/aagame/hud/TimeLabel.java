package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TimeLabel extends AbstractHudElement {
	public static String DRAW_STRING = "TIME";
	public static BitmapFont font = Assets.font20;
	public static float WIDTH = font.getBounds(DRAW_STRING).width;
	public static float HEIGHT = font.getCapHeight();

	public TimeLabel(HudLayer parentLayer, float x, float y) {
		super(parentLayer, x, y, WIDTH, HEIGHT);
	}

	@Override
	public void draw(SpriteBatch batch) {
		font.draw(batch, DRAW_STRING, getPosition().x, getPosition().y);
	}

	@Override
	public void onSpawn() {

	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

}
