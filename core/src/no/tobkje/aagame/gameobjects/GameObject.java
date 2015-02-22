package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface GameObject {

	/**
	 * Retrieve the GameObject's position as a 2-dimensional vector
	 * 
	 * @return 2-dimensional vector (x position, y position)
	 */
	public Vector2 getPosition();

	/**
	 * Retrieve the GameObject's velocity as a 2-dimensional vector
	 * 
	 * @return 2-dimensional vector (x velocity, y velocity)
	 */
	public Vector2 getVelocity();

	/**
	 * Retrieve the GameObject's position as a 2-dimensional vector
	 * 
	 * @return 2-dimensional vector (x acceleration, y acceleration)
	 */
	public Vector2 getAcceleration();

	/**
	 * Retrieve the GameObject's width as a float
	 * 
	 * @return width of the GameObject
	 */
	public float getWidth();

	/**
	 * Retrieve the GameObject's height as a float
	 * 
	 * @return height of the GameObject
	 */
	public float getHeight();

	/**
	 * Set the width of the GameObject
	 * 
	 * @param width
	 *            - the new width for the GameObject
	 */
	public void setWidth(float width);

	/**
	 * Set the height of the GameObject
	 * 
	 * @param height
	 *            - the new height for the GameObject
	 */
	public void setHeight(float height);

	/**
	 * Retrieve the bounds (hitbox) of the GameObject
	 * 
	 * @return The rectangle object representing the GameObject's hitbox
	 */
	public Rectangle getHitbox();

	/**
	 * Check for collision with another GameObject
	 * 
	 * @return A boolean indicating intersection (true = overlapping, false =
	 *         not overlapping)
	 */
	public boolean intersects(GameObject other);

	/**
	 * Check if the given GameObject contains the specified x,y coordinates
	 * 
	 * @param x
	 *            - the x value of the coordinate to check
	 * @param y
	 *            - the y value of the coordinate to check
	 * @return boolean indicating containment (true = contains, false = doesn't
	 *         contain)
	 */
	public boolean contains(float x, float y);

	/**
	 * Move the GameObject by updating velocity and positional vectors
	 * 
	 * @param delta
	 *            - The elapsed time from last iteration. Used for
	 *            interpolation, causing framerate-independent movement.
	 */
	public void move(float delta);

	/**
	 * Perform arbitrary updates on the GameObject
	 * 
	 * @param delta
	 *            - The elapsed time from last iteration. Used for
	 *            interpolation, causing framerate-independent updating.
	 */
	public void update(float delta);

	/**
	 * Draw the GameObject using arbitrary assets
	 * @param batch - The SpriteBatch responsible for drawing the GameObject
	 */
	public void draw(SpriteBatch batch);

	/**
	 * Destroy the object TODO: game-logic dependent stuff?
	 */
	public void destroy();

	/**
	 * Retrieve the GameObject's parentscreen
	 * 
	 * @return Screen object containing this GameObject
	 */
	public GameScreen getParentScreen();

	/**
	 * Set the GameObject's parentscreen. Used for collision-detection.
	 * 
	 * @param gameScreen
	 *            - The screen to contain the GameObject
	 */
	public void setParentScreen(GameScreen gameScreen);
}
