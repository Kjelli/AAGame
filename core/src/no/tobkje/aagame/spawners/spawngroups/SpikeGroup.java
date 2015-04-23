package no.tobkje.aagame.spawners.spawngroups;

import no.tobkje.aagame.gameobjects.baddies.Baddie;
import no.tobkje.aagame.gameobjects.baddies.Spike;

public class SpikeGroup extends AbstractSpawnGroup {

	public SpikeGroup(int size) {
		super(size);
	}

	@Override
	public float getSpawnOffset(int index) {
		return Spike.WIDTH;
	}

	@Override
	protected Baddie newBaddie(int index) {
		return new Spike(-1, -1);
	}

}
