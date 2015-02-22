package no.tobkje.aagame.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public interface GameScreen extends World, Screen {
	public OrthographicCamera getCamera();
}
