package no.tobkje.aagame.screens;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.backgrounds.SplashBackground;
import no.tobkje.aagame.gameobjects.SplashElement;
import no.tobkje.aagame.settings.Settings;
import no.tobkje.aagame.tweenaccessors.ColorAccessor;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;

public class SplashScreen extends AbstractGameScreen {
	public SplashElement splashT, splashK;

	public final float fadeIn = 1.0f, decay = 2.0f, fadeOut = 1.0f;

	private Game game;
	private TweenCallback splashDone = new TweenCallback() {

		@Override
		public void onEvent(int event, BaseTween<?> arg1) {
			if (event == TweenCallback.COMPLETE) {
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
			initInput();
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
		splashT = new SplashElement((AAGame.GAME_WIDTH - SplashElement.WIDTH)
				/ 2 - SplashElement.WIDTH, AAGame.GAME_HEIGHT / 2
				- AAGame.GAME_WIDTH / 4, Assets.splash_t);

		splashK = new SplashElement((AAGame.GAME_WIDTH - SplashElement.WIDTH)
				/ 2 + SplashElement.WIDTH, AAGame.GAME_HEIGHT / 2
				- AAGame.GAME_WIDTH / 4, Assets.splash_k);

		spawn(splashT);
		spawn(splashK);
		Color color = splashT.getColor();
		Color color2 = splashK.getColor();
		// TODO cleanup
		Timeline.createParallel()
				.push(Timeline
						.createSequence()
						.push(Tween.to(color, ColorAccessor.COLOR_RGBA, fadeIn)
								.target(1.0f, 1.0f, 1.0f, 1.0f))
						.push(Tween
								.to(color, ColorAccessor.COLOR_RGBA, fadeOut)
								.target(1f, 1f, 1f, 0f).delay(decay))
						.setCallback(splashDone))
				.push(Timeline
						.createSequence()
						.push(Tween
								.to(color2, ColorAccessor.COLOR_RGBA, fadeIn)
								.target(1.0f, 1.0f, 1.0f, 1.0f))
						.push(Tween
								.to(color2, ColorAccessor.COLOR_RGBA, fadeOut)
								.target(1.0f, 1.0f, 1.0f, 0.0f).delay(decay)))
				.start(getTweenManager());
	}

	private void initInput() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				splashDone.onEvent(TweenCallback.COMPLETE, null);
				return true;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean keyDown(int keycode) {
				splashDone.onEvent(TweenCallback.COMPLETE, null);
				return true;
			}
		});
	}

}
