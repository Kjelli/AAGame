package no.tobkje.aagame;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.Game;

public class AAGame extends Game {
	@Override
	public void create() {
		Assets.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
	}
}
