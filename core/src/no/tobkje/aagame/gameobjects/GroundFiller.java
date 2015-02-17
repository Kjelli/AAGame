package no.tobkje.aagame.gameobjects;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.batch.Batch;

public class GroundFiller extends AbstractGameObject {

	public GroundFiller(float y) {
		super(0, 0, AAGame.GAME_WIDTH, y);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		Batch.getBatch().draw(Assets.groundFiller, position.x, position.y, width, height);

	}
}
