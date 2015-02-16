package no.tobkje.aagame.gameobjects;

import com.badlogic.gdx.math.Vector2;

public interface GameObject {

	public Vector2 getPosition();

	public Vector2 getVelocity();

	public Vector2 getAcceleration();

	public float getWidth();

	public float getHeight();

	public void setWidth(float width);

	public void setHeight(float height);

	public boolean intersects(GameObject other);

	public boolean contains(float x, float y);

	public void move(float delta);

	public void update(float delta);

	public void draw();

	public void destroy();
}
