package no.tobkje.aagame.collisions;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hitbox {
	final Rectangle r;
	final float offsetX, offsetY;

	public Hitbox(float x, float y, float width, float height) {
		this(x, y, width, height, 0f, 0f);
	}

	public Hitbox(float x, float y, float width, float height, float offsetX,
			float offsetY) {
		r = new Rectangle(x + offsetX, y + offsetY, width, height);
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}

	public boolean overlaps(Hitbox other) {
		return this.r.overlaps(other.r);
	}

	public Rectangle toRectangle() {
		return r;
	}

	public void update(Vector2 newPos) {
		r.x = newPos.x + offsetX;
		r.y = newPos.y + offsetY;
	}

	public float getOffsetX() {
		return offsetX;
	}

	public float getOffsetY() {
		return offsetY;
	}

	public float getX() {
		return r.x;
	}

	public float getY() {
		return r.y;
	}
	
	public float getWidth() {
		return r.width;
	}

	public float getHeight() {
		return r.height;
	}
}
