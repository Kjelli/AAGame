package no.tobkje.aagame.screens;

import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.GroundFiller;
import no.tobkje.aagame.gameobjects.HalfSaw;
import no.tobkje.aagame.gameobjects.Man;
import no.tobkje.aagame.gameobjects.Sky;
import no.tobkje.aagame.input.ManInput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen extends AbstractGameScreen {

	public static final float LEVEL_VELOCITY_INITIAL = 65.0f;
	private static float levelVelocity = LEVEL_VELOCITY_INITIAL;

	Man theMan;
	OrthographicCamera camera;

	public GameScreen() {
		super();
	}

	@Override
	public void show() {
		super.show();
		initGame();
		initInput();
	}

	private void initGame() {
		objects.add(new Sky());
		theMan = new Man(60, 95);

		for (int i = 0; i <= 10; i++) {
			objects.add(new Ground(Ground.WIDTH * i, 30));
		}

		objects.add(new GroundFiller(30));
		//objects.add(new Saw(400, 300));
		objects.add(new HalfSaw(400, 90));
		objects.add(theMan);
	}

	private void initInput() {
		Gdx.input.setInputProcessor(new ManInput(theMan));
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		levelVelocity += 0.05f;
	}

	public static float getLevelVelocity() {
		return levelVelocity;
	}
}
