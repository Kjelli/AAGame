package no.tobkje.aagame.backgrounds;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import no.tobkje.aagame.backgroundobjects.BackgroundObject;

public class Layer {
	private final ArrayList<BackgroundObject> objects;
	private float relative_velocity;
	private final Background parentBackground;

	public Layer(Background parentBackground, float relative_velocity) {
		this.parentBackground = parentBackground;
		setRelative_velocity(relative_velocity);
		objects = new ArrayList<BackgroundObject>();
	}

	public void update(float delta) {
		for (BackgroundObject o : objects) {
			o.update(delta);
		}
	}

	public float getRelative_velocity() {
		return relative_velocity;
	}

	public void setRelative_velocity(float relative_velocity) {
		this.relative_velocity = relative_velocity;
	}

	public void spawn(BackgroundObject bo) {
		objects.add(bo);
		bo.setParentLayer(this);
	}

	public Background getParentBackground() {
		return parentBackground;
	}

	public void render(SpriteBatch batch) {
		for(BackgroundObject bo : objects){
			bo.draw(batch);
		}
	}

	public void clear() {
		objects.clear();
	}
}
