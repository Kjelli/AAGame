package no.tobkje.aagame.spawners.spawngroups;

import no.tobkje.aagame.gameobjects.baddies.Baddie;
import no.tobkje.aagame.gameobjects.baddies.MiniManBlue;
import no.tobkje.aagame.gameobjects.baddies.MiniManGreen;
import no.tobkje.aagame.gameobjects.baddies.MiniManSpike;

public class MiniManMonoGroup extends AbstractSpawnGroup {
	private int color;

	public MiniManMonoGroup(int size) {
		super(size);
	}

	@Override
	public float getSpawnOffset(int index) {
		return 50f;
	}

	@Override
	protected Baddie newBaddie(int index) {
		if (color == 0) {
			color = (int) (Math.random() * 3);
		}
		switch (color) {
		case 0:
			return new MiniManBlue(-1, -1, 0.2f);
		case 1:
			return new MiniManGreen(-1, -1, 0.2f);
		case 2:
			return new MiniManSpike(-1, -1, 0.2f);
		default:
			return null;
		}
	}
}
