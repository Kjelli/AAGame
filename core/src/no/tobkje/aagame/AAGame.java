package no.tobkje.aagame;

import no.tobkje.aagame.screens.SplashScreen;

import no.tobkje.aagame.assets.Assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class AAGame extends Game {
	public static float GAME_WIDTH;
	public static float SCREEN_WIDTH;
	public static float SCREEN_HEIGHT;
	public static float GAME_HEIGHT;

	@Override
	public void create() {
		GAME_WIDTH = 520;
		SCREEN_WIDTH = Gdx.graphics.getWidth();
		SCREEN_HEIGHT = Gdx.graphics.getHeight();
		GAME_HEIGHT = SCREEN_HEIGHT / (SCREEN_WIDTH / GAME_WIDTH);
		Assets.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
	}
}
