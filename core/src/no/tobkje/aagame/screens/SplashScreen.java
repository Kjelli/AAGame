package no.tobkje.aagame.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.backgrounds.SplashBackground;
import no.tobkje.aagame.gameobjects.Splash;
import no.tobkje.aagame.tweenaccessors.ColorAccessor;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;

public class SplashScreen extends AbstractGameScreen {
	public Splash splash;
	private Game game;

	public SplashScreen(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void show() {
		init();
		initBackground();
	}

	@Override
	protected void updateScreen(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {

		setBackground(new SplashBackground());
		splash = new Splash(AAGame.GAME_WIDTH / 4 - 40, AAGame.GAME_HEIGHT / 2
				- AAGame.GAME_WIDTH / 4, AAGame.GAME_WIDTH / 2,
				AAGame.GAME_WIDTH / 2);

		spawn(splash);
		Color color = splash.getColor();
		
		//TODO cleanup
		Timeline.createParallel()
				.push(Timeline
						.createSequence()
						.push(Tween.to(color, ColorAccessor.COLOR_RGBA, 2)
								.target(1.0f, 1.0f, 1.0f, 1.0f))
						.push(Tween.to(color, ColorAccessor.COLOR_RGBA, 2)
								.target(1f, 1f, 1f, 0f).delay(2))
						.setCallback(new TweenCallback() {

							@Override
							public void onEvent(int arg0, BaseTween<?> arg1) {
								game.setScreen(new PlayScreen());
							}
						}))
				.push(Tween.to(splash, GameObjectAccessor.POSITION_X, 6)
						.target(AAGame.GAME_WIDTH / 4 + 40))
				.start(getTweenManager());
	}

}
