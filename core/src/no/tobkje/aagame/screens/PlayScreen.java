package no.tobkje.aagame.screens;

import no.tobkje.aagame.backgrounds.PlayBackground;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.baddies.HalfSaw;
import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.input.ManInput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class PlayScreen extends AbstractGameScreen {

	public static final float LEVEL_VELOCITY_INITIAL = 105.0f;
	private static float levelVelocity;

	Man theMan;
	OrthographicCamera camera;

	public PlayScreen() {
		super();
		setBackground(new PlayBackground());
	}

	@Override
	public void show() {
		init();
	}

	@Override
	public void init() {
		initBackground();
		initGame();
		initInput();
	}

	private void initGame() {
		theMan = new Man(40, 68);

		for (int i = 0; i <= 10; i++) {
			spawn(new Ground(Ground.WIDTH * i, -60));
		}
		spawn(new HalfSaw(400));
		// spawn(new HalfSaw(520, -60 + Ground.HEIGHT));
		// spawn(new HalfSaw(640, -60 + Ground.HEIGHT));
		spawn(theMan);

		levelVelocity = LEVEL_VELOCITY_INITIAL;
	}

	private void initInput() {
		Gdx.input.setInputProcessor(new ManInput(theMan));
	}

	public void draw(float delta) {
		super.render(delta);
		levelVelocity += 0.05f;
	}

	public static float getLevelVelocity() {
		return levelVelocity;
	}

	public static void setLevelVelocity(float f) {
		levelVelocity = f;
	}
}
