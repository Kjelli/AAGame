package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.GameScreen;
import no.tobkje.aagame.tweens.GameObjectTweens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractGameObject implements GameObject {
	private final Vector2 position;
	private final Vector2 velocity;
	private final Vector2 acceleration;
	private final Vector2 origin;
	private Hitbox hitbox;

	private float width;
	private float height;
	private float rotation;

	private GameScreen parentScreen;

	private boolean onGround = false;
	private boolean isDead = false;

	public AbstractGameObject(float x, float y, float width, float height) {
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);

		this.width = width;
		this.height = height;

		origin = new Vector2(width / 2, height / 2);
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
	public Vector2 getOrigin() {
		return origin;
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
		return (x >= position.x && x <= position.x + width && y >= position.y && y <= position.y
				+ height);
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

	public boolean isOnGround() {
		return onGround;
	}

	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

	public void die() {
		if (isDead)
			return;
		GameObjectTweens.frontFlip(this);
		getVelocity().y = 200;
		getAcceleration().y = -300;
		setDead(true);
		setOnGround(false);
	}

	public void land(GameObject target) {
		setOnGround(true);
		getVelocity().y = 0;
		getAcceleration().y = 0;
		// Nudge back over ground
		getPosition().y = (target.getHitbox().getY()
				+ target.getHitbox().getHeight() + 1);
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	@Override
	public void destroy() {
		getParentScreen().despawn(this);
	}

	private static float LINE_LENGTH = 2;

	@Override
	public void drawDebug(ShapeRenderer sr) {
		Color defaultColor = sr.getColor();

		Rectangle r = hitbox.toRectangle();
		sr.rect(r.x, r.y, origin.x, origin.y, r.width, r.height, 1.0f, 1.0f,
				rotation);
		
		// Actual positions
		sr.setColor(Color.BLUE);
		sr.line(getPosition().x - LINE_LENGTH, getPosition().y - LINE_LENGTH,
				getPosition().x + LINE_LENGTH, getPosition().y + LINE_LENGTH);
		sr.line(getPosition().x - LINE_LENGTH, getPosition().y + LINE_LENGTH,
				getPosition().x + LINE_LENGTH, getPosition().y - LINE_LENGTH);

		// Positions relative to origin
		sr.setColor(Color.YELLOW);
		sr.line((getPosition().x + getOrigin().x) - LINE_LENGTH,
				(getPosition().y + getOrigin().y) - LINE_LENGTH,
				(getPosition().x + getOrigin().x) + LINE_LENGTH,
				(getPosition().y + getOrigin().y) + LINE_LENGTH);
		sr.line((getPosition().x + getOrigin().x) - LINE_LENGTH,
				(getPosition().y + getOrigin().y) + LINE_LENGTH,
				(getPosition().x + getOrigin().x) + LINE_LENGTH,
				(getPosition().y + getOrigin().y) - LINE_LENGTH);
		
		sr.setColor(defaultColor);
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
