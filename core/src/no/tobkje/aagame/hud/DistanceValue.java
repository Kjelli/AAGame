package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DistanceValue extends AbstractHudElement {

	public static final BitmapFont font = Assets.font30;
	public static final float WIDTH = font.getBounds("0").width;
	public static final float HEIGHT = font.getCapHeight();

	public float distance;
	public float initialX;
	private String drawString;

	public DistanceValue(HudLayer parentLayer, float x, float y) {
		super(parentLayer, x, y, WIDTH, HEIGHT);
		drawString = toString();
		initialX = x;
	}

	@Override
	public void draw(SpriteBatch batch) {
		font.draw(batch, drawString, getPosition().x, getPosition().y);
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float delta) {
		this.distance += delta * PlayScreen.getLevelVelocity() * 0.10f;
		drawString = toString();
		setWidth(font.getBounds(drawString).width);
		setX(initialX - getWidth());
	}

	@Override
	public String toString() {
		if (distance < 10)
			return "00000" + (int) distance + "m";
		else if (distance < 100)
			return "0000" + (int) distance + "m";
		else if (distance < 1000)
			return "000" + (int) distance + "m";
		else if (distance < 10000)
			return "00" + (int) distance + "m";
		else if (distance < 100000)
			return "0" + (int) distance + "m";
		else
			return (int) distance + "m";
	}
}
