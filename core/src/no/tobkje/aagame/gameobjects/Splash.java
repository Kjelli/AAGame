package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash extends AbstractGameObject {
	private Color color;

	public Splash(float x, float y, float width, float height) {
		super(x, y, width, height);
		color = new Color(1.0f, 1.0f, 1.0f, 0.0f);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.setColor(color);
		batch.draw(Assets.splash, getPosition().x, getPosition().y, getWidth(),
				getHeight());
		batch.setColor(Color.WHITE);
	}

	@Override
	public void update(float delta) {
	}
	
	public Color getColor(){
		return color;
	}

	@Override
	public void onSpawn() {
	}

}
