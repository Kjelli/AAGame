package no.tobkje.aagame.hud;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TimeValue extends AbstractHudElement {

	public static final BitmapFont font = Assets.font30;
	public static final float WIDTH = font.getBounds("00:00:00").width;
	public static final float HEIGHT = font.getCapHeight();

	public float runtime = 0;

	public TimeValue(HudLayer parentLayer, float x, float y) {
		super(parentLayer, x, y, WIDTH, HEIGHT);

	}

	@Override
	public void draw(SpriteBatch batch) {
		font.draw(batch, toString(), getPosition().x, getPosition().y);
		System.out.println(toString());
	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float delta) {
		runtime += delta;
	}

	@Override
	public String toString() {
		System.out.println(runtime);
		int millis = (int) (runtime * 100) % 100;
		int seconds = (int) (runtime) % 60;
		int minutes = (int) (runtime / 60) % 60;
		String millis_s = (millis < 10) ? ("0" + millis) : ("" + millis);
		String seconds_s = (seconds < 10) ? ("0" + seconds) : ("" + seconds);
		String minutes_s = (minutes < 10) ? ("0" + minutes) : ("" + minutes);
		return minutes_s + ":" + seconds_s + ":" + millis_s;
	}

}
