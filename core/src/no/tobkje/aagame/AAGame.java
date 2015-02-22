package no.tobkje.aagame;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.Game;

public class AAGame extends Game {
	static public final int GAME_WIDTH = 540;
	final static public int GAME_HEIGHT = 320;

	@Override
	public void create() {
		Assets.load();
		setScreen(new PlayScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
	}
}
