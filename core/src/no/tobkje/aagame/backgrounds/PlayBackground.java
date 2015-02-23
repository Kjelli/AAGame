package no.tobkje.aagame.backgrounds;

import no.tobkje.aagame.backgroundobjects.Star;
import no.tobkje.aagame.screens.GameScreen;

public class PlayBackground extends AbstractBackground {
	public static final int LAYER_COUNT = 4;

	GameScreen parentScreen;

	Layer backestest;
	Layer backest;
	Layer backer;
	Layer back;

	public PlayBackground() {
		super(LAYER_COUNT);

		backestest = new Layer(this, 0.0f);
		backest = new Layer(this, 0.2f);
		backer = new Layer(this, 0.4f);
		back = new Layer(this, 0.8f);

		setLayer(0, backestest);
		setLayer(1, backest);
		setLayer(2, backer);
		setLayer(3, back);
	}

	@Override
	public void init() {
		backestest.spawn(new Star(400, 200));
		backest.spawn(new Star(400, 200));
		backer.spawn(new Star(400, 200));
		back.spawn(new Star(400, 200));
	}

	@Override
	public GameScreen getParentScreen() {
		return parentScreen;
	}
}
