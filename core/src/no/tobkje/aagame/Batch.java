package no.tobkje.aagame;

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
