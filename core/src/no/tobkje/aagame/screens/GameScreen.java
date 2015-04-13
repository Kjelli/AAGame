package no.tobkje.aagame.screens;

import no.tobkje.aagame.gameobjects.GameObject;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public interface GameScreen extends World, Screen {
	public OrthographicCamera getCamera();

	public TweenManager getTweenManager();

	public void init();

	public void spawn(GameObject go);

	public void despawn(GameObject go);

	public void reset();
}
