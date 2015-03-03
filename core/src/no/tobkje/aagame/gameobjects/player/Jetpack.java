package no.tobkje.aagame.gameobjects.player;

import no.tobkje.aagame.gameobjects.particles.Smoke;

public class Jetpack {
	private static final float THRUST_INITIAL = 1000;
	private static final float ENERGY_INITIAL = 100;

	private boolean cooldown;
	private boolean isThrusting;
	private float energy;
	private float thrust;

	private Man man;

	public Jetpack(Man man) {
		this.man = man;
		energy = ENERGY_INITIAL;
		thrust = THRUST_INITIAL;
	}

	public float getThrust() {
		return thrust;
	}

	public void update(float delta) {
		if (cooldown)
			return;
		if (energy <= 0) {
			thrust = 0;
			cooldown = true;
		} else if (isThrusting) {
			thrust = THRUST_INITIAL;
			energy -= 40.0f * delta;
			man.getParentScreen().spawn(
					new Smoke((float)(man.getPosition().x + 2 + Math.random() * 8.0f), (float)(man
							.getPosition().y + 4 + Math.random() * 8.0f), -thrust / 10.0f));
		}
	}

	public void setThrusting(boolean isThrusting) {
		this.isThrusting = isThrusting;
	}

	public boolean isThrusting() {
		return isThrusting;
	}

	public void resetCooldown() {
		cooldown = false;
		energy = ENERGY_INITIAL;
	}

	public float getEnergy() {
		return energy;
	}

	public float getMaxEnergy() {
		return ENERGY_INITIAL;
	}

	public float getEnergyPercentage() {
		return energy / ENERGY_INITIAL;
	}

}
