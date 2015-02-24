package no.tobkje.aagame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import no.tobkje.aagame.AAGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 520;
		config.height = 320;
		new LwjglApplication(new AAGame(), config);
	}
}
