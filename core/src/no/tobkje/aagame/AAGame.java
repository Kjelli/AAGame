package no.tobkje.aagame;

import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;

import com.badlogic.gdx.Game;

public class AAGame extends Game {

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
