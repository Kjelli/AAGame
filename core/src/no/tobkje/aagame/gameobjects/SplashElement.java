package no.tobkje.aagame.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashElement extends AbstractGameObject {
	private Color color;
	public static final float scale = 0.5f;
	public static final float WIDTH = 320 * scale;
	public static final float HEIGHT = 440 * scale;

	public TextureRegion splashImage;

	public SplashElement(float x, float y, TextureRegion splashImage) {
		super(x, y, WIDTH, HEIGHT);
		this.splashImage = splashImage;
		color = new Color(1.0f, 1.0f, 1.0f, 0.0f);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.setColor(color);
		batch.draw(splashImage, getPosition().x, getPosition().y, getWidth(),
				getHeight());
		batch.setColor(Color.WHITE);
	}

	@Override
	public void update(float delta) {
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void onSpawn() {
	}

}
