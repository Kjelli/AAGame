package no.tobkje.aagame.screens;

import java.util.ArrayList;

import no.tobkje.aagame.batch.Batch;
import no.tobkje.aagame.gameobjects.GameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class AbstractGameScreen implements Screen {

	protected final ArrayList<GameObject> objects;
	protected final OrthographicCamera camera;

	public AbstractGameScreen() {
		objects = new ArrayList<GameObject>();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
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

}
