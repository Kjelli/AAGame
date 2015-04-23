package no.tobkje.aagame.input;

import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.screens.PlayScreen.State;
import no.tobkje.aagame.settings.Settings;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PlayInput implements InputProcessor {
	Man theMan;
	PlayScreen screen;

	public PlayInput(Man theMan, PlayScreen screen) {
		this.theMan = theMan;
		this.screen = screen;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Input.Keys.SPACE:
			theMan.onClick();
			return true;
		case Input.Keys.D:
			if (Settings.get("debug_draw", false))
				Settings.put("debug_draw", false);
			else
				Settings.put("debug_draw", true);
			return true;
		case Input.Keys.S:
			if (Settings.get("slow", false))
				Settings.put("slow", false);
			else
				Settings.put("slow", true);
			return true;
		case Input.Keys.F:
			if (Settings.get("fast", false))
				Settings.put("fast", false);
			else
				Settings.put("fast", true);
			return true;
		case Input.Keys.R:
			theMan.getParentScreen().reset();
			return true;

		case Input.Keys.G:
			if (Settings.get("debug_nogravity", false))
				Settings.put("debug_nogravity", false);
			else
				Settings.put("debug_nogravity", true);
			return true;
		case Input.Keys.PLUS:
			theMan.score(10);
			return true;

		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Input.Keys.SPACE:
			theMan.jumpRelease();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (PlayScreen.STATE == State.START) {
			screen.play();
			return true;
		}
		theMan.onClick();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (PlayScreen.STATE == State.START) {
			return true;
		}
		theMan.jumpRelease();
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
