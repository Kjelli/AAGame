package no.tobkje.aagame.screens;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public interface GameScreen extends World, Screen {
	public OrthographicCamera getCamera();
	public TweenManager getTweenManager();
	public void init();
	public void reset();
}
