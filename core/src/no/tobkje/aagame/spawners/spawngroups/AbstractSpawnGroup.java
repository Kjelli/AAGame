package no.tobkje.aagame.spawners.spawngroups;

import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.baddies.Baddie;

public abstract class AbstractSpawnGroup implements SpawnGroup {
	protected final Baddie[] group;

	protected AbstractSpawnGroup(int size) {
		size = (int) ((Math.random() * 0.5 + 0.5) * size);
		group = new Baddie[size];

	}

	protected abstract Baddie newBaddie(int index);

	@Override
	public int getSize() {
		return group.length;
	}

	@Override
	public GameObject get(int index) {
		if (group[0] == null) {
			for (int i = 0; i < getSize(); i++) {
				group[i] = newBaddie(i);
			}
		}
		return group[index];
	}
}
