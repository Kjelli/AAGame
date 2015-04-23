package no.tobkje.aagame.spawners.spawngroups;

import no.tobkje.aagame.gameobjects.GameObject;

public interface SpawnGroup {
	int getSize();

	GameObject get(int index);

	float getSpawnOffset(int index);
}
