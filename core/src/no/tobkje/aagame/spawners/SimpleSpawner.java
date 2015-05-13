package no.tobkje.aagame.spawners;

import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.spawners.spawngroups.MiniManMonoGroup;
import no.tobkje.aagame.spawners.spawngroups.MiniManRandomGroup;
import no.tobkje.aagame.spawners.spawngroups.SpawnGroup;
import no.tobkje.aagame.spawners.spawngroups.SpikeGroup;

public class SimpleSpawner implements Spawner {
	private float x, y;
	private float spawnIntervalDistanceMin = 200.0f;
	private float spawnIntervalDistanceMax = 1000f;
	private float countdown = spawnIntervalDistanceMin;

	private PlayScreen parent;

	// TODO
	private SpawnGroup group;
	private int spawnIndex;

	/**
	 * Creates a simple spawner for spawning groups of enemies
	 * 
	 * @param parent
	 *            The parent instance of PlayScreen, which will contain the
	 *            spawned enemies
	 * 
	 * @param x
	 *            The x position to spawn the new enemies
	 * @param y
	 *            The y position to spawn the new enemies
	 */
	public SimpleSpawner(PlayScreen parent, float x, float y) {
		this.parent = parent;
		this.x = x;
		this.y = y;

		group = newGroup();
	}

	@Override
	public void update(float distance) {
		if ((countdown -= distance) > 0) {
			return;
		}

		if (spawnIndex < group.getSize() - 1) {
			spawn(countdown);
			countdown += group.getSpawnOffset(spawnIndex);
		} else {
			spawn(countdown);
			group = newGroup();
			spawnIndex = 0;
			countdown += Math.random()
					* (spawnIntervalDistanceMax - spawnIntervalDistanceMin)
					+ spawnIntervalDistanceMin;
		}

	}

	private void spawn(float xOffset) {
		if (group.get(spawnIndex) != null) {
			parent.spawn(group.get(spawnIndex), x + xOffset, y);
		}
		spawnIndex++;
	}

	private SpawnGroup newGroup() {
		double determinant = Math.random();
		if (determinant < 0.33) {
			return new MiniManMonoGroup(5);
		} else if (determinant < 0.66) {
			return new MiniManRandomGroup(5);
		} else {
			return new SpikeGroup(8);
		}
	}
}
