package no.tobkje.aagame.gameobjects.player;

public class Jetpack {
	private static final float THRUST_INITIAL = 400;
	private static final float ENERGY_INITIAL = 100;

	private boolean cooldown;
	private boolean isThrusting;
	private float energy;
	private float thrust;

	public Jetpack() {
		energy = ENERGY_INITIAL;
		thrust = THRUST_INITIAL;
	}

	public float getThrust() {
		return thrust;
	}

	public void update(float delta) {
		System.out.println(energy);
		if (cooldown)
			return;
		if (energy <= 0) {
			thrust = Man.GRAVITY;
			cooldown = true;
		} else if (isThrusting) {
			thrust = THRUST_INITIAL * (energy / ENERGY_INITIAL);
			energy -= 40.0f * delta;
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

}
