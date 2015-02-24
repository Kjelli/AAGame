package no.tobkje.aagame.input;

import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.settings.Settings;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class ManInput implements InputProcessor {
	Man theMan;

	public ManInput(Man theMan) {
		this.theMan = theMan;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Input.Keys.SPACE:
			theMan.jump();
			return true;
		case Input.Keys.D:
			if (Settings.get("debug", false))
				Settings.put("debug", false);
			else
				Settings.put("debug", true);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		theMan.jump();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		theMan.jumpRelease();
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
