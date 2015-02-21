package no.tobkje.aagame.screens;

import java.util.ArrayList;

import no.tobkje.aagame.batch.Batch;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.GroundFiller;
import no.tobkje.aagame.gameobjects.Man;
import no.tobkje.aagame.gameobjects.Sky;
import no.tobkje.aagame.input.ManInput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen {
	public static final Vector2 RESOLUTION = new Vector2(480, 320);

	public static final float LEVEL_VELOCITY_INITIAL = 35.0f;
	private static float levelVelocity = LEVEL_VELOCITY_INITIAL;

	ArrayList<GameObject> objects;

	Man theMan;
	OrthographicCamera camera;

	public GameScreen() {
	}

	@Override
	public void show() {
		initGame();
		initInput();
		initCamera();
	}

	private void initGame() {
		objects = new ArrayList<GameObject>();
		objects.add(new Sky());
		theMan = new Man(60, 95);

		for (int i = 0; i <= 10; i++) {
			objects.add(new Ground(Ground.WIDTH * i, 30));
		}

		objects.add(new GroundFiller(30));
		objects.add(theMan);
	}

	private void initInput() {
		Gdx.input.setInputProcessor(new ManInput(theMan));
	}

	private void initCamera() {
		camera = new OrthographicCamera(RESOLUTION.x, RESOLUTION.y);
		camera.translate(RESOLUTION.x / 2, RESOLUTION.y / 2);
	}

	@Override
	public void render(float delta) {
		levelVelocity += 0.05f;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Batch.getBatch().begin();
		{
			camera.update();
			Batch.getBatch().setProjectionMatrix(camera.combined);
			for (GameObject o : objects) {
				o.update(delta);
				o.draw();
			}
		}
		Batch.getBatch().end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public static float getLevelVelocity() {
		return levelVelocity;
	}
}
