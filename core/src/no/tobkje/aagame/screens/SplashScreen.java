package no.tobkje.aagame.screens;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.backgrounds.SplashBackground;
import no.tobkje.aagame.gameobjects.Splash;
import no.tobkje.aagame.settings.Settings;
import no.tobkje.aagame.tweenaccessors.ColorAccessor;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;

public class SplashScreen extends AbstractGameScreen {
	public Splash splash;
	private Game game;
	private TweenCallback splashDone = new TweenCallback() {

		@Override
		public void onEvent(int arg0, BaseTween<?> arg1) {
			if (arg0 == TweenCallback.COMPLETE) {
				Assets.load();
				game.setScreen(new PlayScreen());
			}
		}
	};

	public SplashScreen(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void show() {
		if (Settings.get("debug", false)) {
			splashDone.onEvent(TweenCallback.COMPLETE, null);
		} else {
			init();
			initBackground();
		}
	}

	@Override
	protected void updateScreen(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		Assets.loadSplash();
		setBackground(new SplashBackground());
		splash = new Splash(AAGame.GAME_WIDTH / 4, AAGame.GAME_HEIGHT / 2
				- AAGame.GAME_WIDTH / 4, AAGame.GAME_WIDTH / 2,
				AAGame.GAME_WIDTH / 2);

		spawn(splash);
		Color color = splash.getColor();

		// TODO cleanup
		Timeline.createParallel()
				.push(Timeline
						.createSequence()
						.push(Tween.to(color, ColorAccessor.COLOR_RGBA, 2)
								.target(1.0f, 1.0f, 1.0f, 1.0f))
						.push(Tween.to(color, ColorAccessor.COLOR_RGBA, 2)
								.target(1f, 1f, 1f, 0f).delay(2))
						.setCallback(splashDone)).start(getTweenManager());
	}

}
