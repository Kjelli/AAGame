package no.tobkje.aagame.batch;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Batch {
	private static SpriteBatch batch;

	public static SpriteBatch getBatch() {
		if (batch == null) {
			batch = new SpriteBatch();
		}
		return batch;
	}
}
