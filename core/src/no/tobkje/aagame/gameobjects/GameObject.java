package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.collisions.Hitbox;
import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public interface GameObject {

	/**
	 * Retrieve the GameObject's position as a 2-dimensional vector
	 * 
	 * @return 2-dimensional vector (x position, y position)
	 */
	Vector2 getPosition();

	/**
	 * Modify the x position of the gameobject's 2-dimensional position vector
	 * 
	 * @param x
	 */
	void setX(float x);

	/**
	 * Modify the y position of the gameobject's 2-dimensional position vector
	 * 
	 * @param y
	 */
	void setY(float y);

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
	 * Get the origin of the object. This is the point of which the object will
	 * rotate around.
	 * 
	 * @return Vector2 containing the origin x,y of the object.
	 */

	public Vector2 getOrigin();

	/**
	 * Set the height of the GameObject
	 * 
	 * @param height
	 *            - the new height for the GameObject
	 */
	public void setHeight(float height);

	public float getRotation();

	public void setRotation(float rotation);

	/**
	 * Retrieve the bounds (hitbox) of the GameObject
	 * 
	 * @return The Hitbox object representing the GameObject's hitbox
	 */
	public Hitbox getHitbox();

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
	 * 
	 * @param batch
	 *            - The SpriteBatch responsible for drawing the GameObject
	 * @param sr 
	 */
	public void draw(SpriteBatch batch);

	/**
	 * Draw the hitbox of the object
	 * 
	 * @param sr
	 *            - ShapeRenderer object used to draw debug-sensitive
	 *            information
	 */
	public void drawDebug(ShapeRenderer sr);

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

	/**
	 * Destroy the object TODO: game-logic dependent stuff?
	 */
	public void destroy();

	/**
	 * Determine if the given object is dead
	 * 
	 * @return boolean indicating death
	 */
	public boolean isDead();

	/**
	 * Method run when object is added to the gameworld. Somewhat like a
	 * constructor.
	 */
	public void onSpawn();
}
