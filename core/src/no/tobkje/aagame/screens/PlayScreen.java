package no.tobkje.aagame.screens;

import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.GroundFiller;
import no.tobkje.aagame.gameobjects.HalfSaw;
import no.tobkje.aagame.gameobjects.Man;
import no.tobkje.aagame.gameobjects.Sky;
import no.tobkje.aagame.input.ManInput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class PlayScreen extends AbstractGameScreen {

	public static final float LEVEL_VELOCITY_INITIAL = 105.0f;
	private static float levelVelocity = LEVEL_VELOCITY_INITIAL;

	Man theMan;
	OrthographicCamera camera;

	public PlayScreen() {
		super();
	}

	@Override
	public void show() {
		super.show();
		initGame();
		initInput();
	}

	private void initGame() {
		getObjects().add(new Sky());
		theMan = new Man(60, 95);

		for (int i = 0; i <= 10; i++) {
			spawn(new Ground(Ground.WIDTH * i, 30));
		}
		spawn(new HalfSaw(400, 30 + Ground.HEIGHT));
		spawn(new HalfSaw(520, 30 + Ground.HEIGHT));
		spawn(new HalfSaw(640, 30 + Ground.HEIGHT));
		spawn(new GroundFiller(30));
		spawn(theMan);
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
