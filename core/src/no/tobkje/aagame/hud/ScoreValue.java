package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.player.Man;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreValue extends AbstractHudElement {
	public static final BitmapFont font = Assets.font30;
	public static final float WIDTH = font.getBounds("0").width;
	public static final float HEIGHT = font.getCapHeight();

	private Man theMan;

	private int score = 0;

	public ScoreValue(HudLayer parentLayer, float x, float y) {
		super(parentLayer, x, y, WIDTH, HEIGHT);
	}

	@Override
	public void draw(SpriteBatch batch) {
		font.draw(batch, score + "", getPosition().x - getWidth()/2, getPosition().y);
	}

	@Override
	public void onSpawn() {
		setWidth(WIDTH);
	}

	@Override
	public void bind(GameObject object) {
		if (object instanceof Man) {
			theMan = (Man) object;
			theMan.bindScoreValue(this);
		} else {
			System.err.println("Cannot bind object to "
					+ this.getClass().getName()
					+ ", it is meant for binding to " + Man.class.getName());
		}
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	public void add(int i) {
		score += i;
		setWidth(font.getBounds(score + "").width);
	}

}
