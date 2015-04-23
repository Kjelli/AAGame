package no.tobkje.aagame.spawners.spawngroups;

import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.baddies.Baddie;

public abstract class AbstractSpawnGroup implements SpawnGroup {
	Baddie[] group;

	protected AbstractSpawnGroup(int size) {
		size = (int) ((Math.random() * 0.5 + 0.5) * size);
		group = new Baddie[size];
		for (int i = 0; i < size; i++) {
			group[i] = newBaddie(i);
		}
	}

	protected abstract Baddie newBaddie(int index);

	@Override
	public int getSize() {
		return group.length;
	}

	@Override
	public GameObject get(int index) {
		return group[index];
	}
}
