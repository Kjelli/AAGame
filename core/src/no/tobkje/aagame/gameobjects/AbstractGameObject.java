package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractGameObject implements GameObject {
	private final Vector2 position;
	private final Vector2 velocity;
	private final Vector2 acceleration;
	private Hitbox hitbox;

	private float width;
	private float height;
	private float rotation;

	private GameScreen parentScreen;

	public AbstractGameObject(float x, float y, float width, float height) {
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);

		this.width = width;
		this.height = height;

		hitbox = new Hitbox(x, y, width, height);
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
		return this.getHitbox().overlaps(other.getHitbox());
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
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
		hitbox.update(position);

	}

	@Override
	public GameScreen getParentScreen() {
		return parentScreen;
	}

	@Override
	public void setParentScreen(GameScreen gameScreen) {
		this.parentScreen = gameScreen;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawDebug(ShapeRenderer sr) {
		Rectangle r = getHitbox().toRectangle();
		sr.rect(r.x, r.y, 0, 0, r.width, r.height, 1.0f, 1.0f, rotation);
	}

	@Override
	public float getRotation() {
		return rotation;
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
}
