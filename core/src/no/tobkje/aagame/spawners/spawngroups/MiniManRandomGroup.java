package no.tobkje.aagame.spawners.spawngroups;

import no.tobkje.aagame.gameobjects.baddies.Baddie;
import no.tobkje.aagame.gameobjects.baddies.MiniManBlue;
import no.tobkje.aagame.gameobjects.baddies.MiniManGreen;
import no.tobkje.aagame.gameobjects.baddies.MiniManSpike;

public class MiniManRandomGroup extends AbstractSpawnGroup {

	public MiniManRandomGroup(int size) {
		super(size);
	}

	@Override
	protected Baddie newBaddie(int index) {
		double determinant = Math.random();
		if (determinant < 0.33) {
			return new MiniManBlue(-1, -1);
		} else if (determinant < 0.66) {
			return new MiniManGreen(-1, -1);
		} else {
			return new MiniManSpike(-1, -1);
		}
	}

	@Override
	public float getSpawnOffset(int index) {
		return 50f;
	}

}
