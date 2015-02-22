package no.tobkje.aagame.gameobjects;

import com.badlogic.gdx.Gdx;
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
	public final Vector2 getPosition() {
		return position;
	}

	@Override
	public final Vector2 getVelocity() {
		return velocity;
	}

	@Override
	public final Vector2 getAcceleration() {
		return acceleration;
	}

	@Override
	public final float getWidth() {
		return width;
	}

	@Override
	public final float getHeight() {
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

	/*
	 * Since OpenGL actually has the lower left corner as 0,0, and the gdx uses
	 * upper left as 0,0 we flip the given y with respect to the height of the
	 * display
	 * 
	 * (non-Javadoc)
	 * 
	 * @see no.tobkje.aagame.gameobjects.GameObject#contains(float, float)
	 */
	@Override
	public final boolean contains(float x, float y) {
		return (x >= position.x && x <= position.x + width
				&& Gdx.graphics.getHeight() - y >= position.y && Gdx.graphics
				.getHeight() - y <= position.y + height);
	}

	@Override
	public abstract void update(float delta);

	@Override
	public void move(float delta) {
		velocity.add(acceleration.cpy().scl(delta));
		position.add(velocity.cpy().scl(delta));

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
