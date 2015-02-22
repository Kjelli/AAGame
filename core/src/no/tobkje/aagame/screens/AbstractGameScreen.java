package no.tobkje.aagame.screens;

import java.util.ArrayList;

import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.settings.Settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class AbstractGameScreen implements GameScreen {

	private final ArrayList<GameObject> objects;
	private final OrthographicCamera camera;
	private final SpriteBatch batch;
	ShapeRenderer sr;

	public AbstractGameScreen() {
		float gameWidth = 520;
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameHeight = screenHeight / (screenWidth / gameWidth);

		objects = new ArrayList<GameObject>();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, gameWidth, gameHeight);
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		sr.setAutoShapeType(true);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public final void render(float delta) {
		if (Settings.get("slow", false))
			delta *= 0.1f;
		updateObjects(delta);
		draw(batch);
		if (Settings.get("debug", false)) {
			drawDebug(sr);
		}
	}

	private void drawDebug(ShapeRenderer sr) {
		sr.begin();
		for (GameObject o : objects) {
			o.drawDebug(sr);
		}
		sr.end();
	}

	private void draw(SpriteBatch batch) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		{
			camera.update();
			batch.setProjectionMatrix(camera.combined);
			for (GameObject o : objects) {
				o.draw(batch);
			}
		}
		batch.end();
	}

	private void updateObjects(float delta) {
		for (GameObject o : objects) {
			o.update(delta);
		}
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

	protected void spawn(GameObject go) {
		objects.add(go);
		go.setParentScreen(this);
	}

	@Override
	public final ArrayList<GameObject> getObjects() {
		return objects;
	}
	

	@Override
	public OrthographicCamera getCamera() {
		return camera;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
