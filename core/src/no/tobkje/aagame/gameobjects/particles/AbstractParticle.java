package no.tobkje.aagame.gameobjects.particles;

import no.tobkje.aagame.gameobjects.AbstractGameObject;

public abstract class AbstractParticle extends AbstractGameObject implements
		Particle {

	final float maximumTimeToLive;

	float timeToLive;

	/**
	 * Creates a particle with the specified dimension at the specified
	 * coordinate with a time to live equal to ttl
	 * 
	 * @param x
	 *            - the specified x coordinate
	 * @param y
	 *            - the specified y coordinate
	 * @param width
	 *            - the specified width
	 * @param height
	 *            - the specified height
	 * @param ttl
	 *            - the time for the particle to live (in seconds)
	 */
	public AbstractParticle(float x, float y, float width, float height,
			float timeToLive) {
		super(x, y, width, height);
		maximumTimeToLive = this.timeToLive = timeToLive;
	}

	@Override
	public final void update(float delta) {
		timeToLive -= delta;
		if (timeToLive <= 0)
			destroy();

		updateParticle(delta);
	}

	public float getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(float timeToLive) {
		this.timeToLive = timeToLive;
	}

	public float getMaximumTimeToLive() {
		return maximumTimeToLive;
	}

	protected abstract void updateParticle(float delta);

}
