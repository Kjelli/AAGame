package no.tobkje.aagame.gameobjects;

import com.badlogic.gdx.math.Vector2;

public abstract class AbstractGameObject implements GameObject {
	protected final Vector2 position;
	protected final Vector2 velocity;
	protected final Vector2 acceleration;

	protected float width;
	protected float height;

	public AbstractGameObject(float x, float y, float width, float height) {
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);

		this.width = width;
		this.height = height;
	}

	@Override
	public Vector2 getPosition() {
		return position;
	}

	@Override
	public Vector2 getVelocity() {
		return velocity;
	}

	@Override
	public Vector2 getAcceleration() {
		return acceleration;
	}

	@Override
	public float getWidth() {
		return width;
	}

	@Override
	public float getHeight() {
		return height;
	}

	@Override
	public void setWidth(float width) {
		this.width = width;
	}

	@Override
	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public boolean intersects(GameObject other) {
		return false;
	}

	@Override
	public boolean contains(float x, float y) {
		return (x >= position.x && x <= position.x + width && y >= position.y && y <= position.y
				+ height);
	}

	@Override
	public void move(float delta) {
		position.add(velocity.cpy().scl(delta));
		// TODO handle collisons?
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
