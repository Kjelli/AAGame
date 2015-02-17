package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;

public class Sky extends AbstractGameObject {

	public Sky() {
		super(0, 0, AAGame.GAME_WIDTH, AAGame.GAME_HEIGHT);
	}

	@Override
	public void update(float delta) {
		//TODO
	}

	@Override
	public void draw() {
		Batch.getBatch()
				.draw(Assets.sky, position.x, position.y, width, height);
	}

}
