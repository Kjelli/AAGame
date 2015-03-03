package no.tobkje.aagame.backgrounds;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.backgroundobjects.SpaceImage;
import no.tobkje.aagame.backgroundobjects.Star;

public class PlayBackground extends AbstractBackground {
	public static final int LAYER_COUNT = 4;

	Layer backestest;
	Layer backest;
	Layer backer;
	Layer back;

	public PlayBackground() {
		super(LAYER_COUNT);

		backestest = new Layer(this, 0.01f);
		backest = new Layer(this, 0.03f);
		backer = new Layer(this, 0.06f);
		back = new Layer(this, 0.08f);

		setLayer(0, backestest);
		setLayer(1, backest);
		setLayer(2, backer);
		setLayer(3, back);
	}

	@Override
	public void init() {
		backestest.spawn(new SpaceImage());
		for (int i = 0; i < 200; i++) {
			int layerIndex = (int) (Math.random() * (getLayers().length - 1)) + 1;
			Layer l = getLayers()[layerIndex];
			l.spawn(new Star((float) Math.random() * AAGame.GAME_WIDTH,
					(float) Math.random() * AAGame.GAME_HEIGHT));
		}
	}
}
