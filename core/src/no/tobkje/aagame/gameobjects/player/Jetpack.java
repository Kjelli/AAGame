package no.tobkje.aagame.gameobjects.player;

import no.tobkje.aagame.gameobjects.particles.Smoke;

public class Jetpack {
	private static final float THRUST_INITIAL = 1000;
	private static final float ENERGY_MAX = 100;

	private boolean isThrusting;
	private float energy;
	private float thrust;

	private Man man;

	public Jetpack(Man man) {
		this.man = man;
		energy = ENERGY_MAX;
		thrust = THRUST_INITIAL;
	}

	public float getThrust() {
		return thrust;
	}

	public void update(float delta) {
		if (energy <= 0) {
			thrust = 0;
		} else if (isThrusting) {
			thrust = THRUST_INITIAL;
			energy -= 40.0f * delta;
			man.getParentScreen()
					.spawn(new Smoke(
							(float) (man.getPosition().x + 2 + Math.random() * 8.0f),
							(float) (man.getPosition().y + 4 + Math.random() * 8.0f),
							-thrust / 10.0f));
		}
	}

	public void setThrusting(boolean isThrusting) {
		this.isThrusting = isThrusting;
	}

	public boolean isThrusting() {
		return isThrusting;
	}

	public float getEnergy() {
		return energy;
	}

	public float getMaxEnergy() {
		return ENERGY_MAX;
	}

	public float getEnergyPercentage() {
		return energy / ENERGY_MAX;
	}

	public void restoreEnergy(float f) {
		energy = Math.min(energy + ENERGY_MAX * f, ENERGY_MAX);
	}

}
