package no.tobkje.aagame.screens;

import java.util.ArrayList;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.backgrounds.Background;
import no.tobkje.aagame.gameobjects.AbstractGameObject;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.hud.HudLayer;
import no.tobkje.aagame.settings.Settings;
import no.tobkje.aagame.tweenaccessors.GameObjectAccessor;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class AbstractGameScreen implements GameScreen {
	private Background background;
	private HudLayer hud;
	private final ArrayList<GameObject> objects;
	private final ArrayList<GameObject> addQueue;
	private final ArrayList<GameObject> removeQueue;
	private final OrthographicCamera camera;
	private final SpriteBatch batch;
	ShapeRenderer sr;
	private final TweenManager manager;

	private static float runtime = 0;

	private boolean resetFlag = false;

	public AbstractGameScreen() {
		addQueue = new ArrayList<GameObject>();
		removeQueue = new ArrayList<GameObject>();
		objects = new ArrayList<GameObject>();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, AAGame.GAME_WIDTH, AAGame.GAME_HEIGHT);
		batch = new SpriteBatch();

		batch.enableBlending();
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		manager = new TweenManager();
		Tween.registerAccessor(AbstractGameObject.class,
				new GameObjectAccessor());
		sr = new ShapeRenderer();
		sr.setAutoShapeType(true);

	}

	@Override
	public final void render(float delta) {
		if (resetFlag) {
			resetLogic();
			return;
		}

		if (Settings.get("slow", false))
			delta *= 0.1f;
		else if (Settings.get("fast", false)) {
			delta *= 10f;
		}

		manager.update(delta);
		background.update(delta);
		updateScreen(delta);
		updateObjects(delta);
		hud.update(delta);
		draw(batch);

		runtime += delta;

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
		Gdx.gl.glClearColor(0, 0.0f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		{
			camera.update();
			batch.setProjectionMatrix(camera.combined);

			background.render(batch);

			for (GameObject o : objects) {
				o.draw(batch);
			}

			hud.render(batch);
		}
		batch.end();
	}

	protected abstract void updateScreen(float delta);

	private void updateObjects(float delta) {
		for (GameObject o : objects) {
			if (o.getPosition().x > -camera.viewportWidth / 2
					&& o.getPosition().x <= camera.position.x
							+ camera.viewportWidth * 1.5)
				o.update(delta);
		}

		while (!removeQueue.isEmpty()) {
			objects.remove(removeQueue.remove(0));
		}

		while (!addQueue.isEmpty()) {
			objects.add(addQueue.remove(0));
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

	public void spawn(GameObject go) {
		addQueue.add(go);
		go.setParentScreen(this);
	}

	public void despawn(GameObject go) {
		removeQueue.add(go);
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
	public void reset() {
		resetFlag = true;
	}

	private void resetLogic() {
		resetFlag = false;
		background.reset();
		hud.reset();
		objects.clear();
		init();
	}

	public abstract void init();

	protected void initBackground() {
		background.init();
	}

	protected void initHud() {
		hud.init();
	}

	public TweenManager getTweenManager() {
		return manager;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public void setHud(HudLayer hud) {
		this.hud = hud;
	}

	public HudLayer getHud() {
		return hud;
	}

	public static float getRuntime() {
		return runtime;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
