package no.tobkje.aagame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import no.tobkje.aagame.AAGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = AAGame.GAME_WIDTH;
		config.height = AAGame.GAME_HEIGHT;
		new LwjglApplication(new AAGame(), config);
	}
}
