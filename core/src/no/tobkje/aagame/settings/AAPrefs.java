package no.tobkje.aagame.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AAPrefs {

	static String name = "AAGAME";
	private static Preferences prefs;

	public static Preferences get() {
		if (prefs == null) {
			prefs = Gdx.app.getPreferences(name);
		}
		return prefs;
	}
}
