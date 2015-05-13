package no.tobkje.aagame.screens;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.backgrounds.Background;
import no.tobkje.aagame.backgrounds.PlayBackground;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.hud.PlayHud;
import no.tobkje.aagame.input.PlayInput;
import no.tobkje.aagame.settings.AAPrefs;
import no.tobkje.aagame.settings.Settings;
import no.tobkje.aagame.spawners.SimpleSpawner;
import no.tobkje.aagame.spawners.Spawner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PlayScreen extends AbstractGameScreen {
	public static final float LEVEL_VELOCITY_INITIAL = 95.0f;

	public enum State {
		START, PLAYING, DEAD
	}

	private static float levelVelocity;
	public static State STATE;
	private Spawner spawner;

	private float runningdistance;

	private Man theMan;

	public PlayScreen() {
		super();

		Background background = new PlayBackground();
		setBackground(background);
		setHud(new PlayHud());

	}

	@Override
	public void show() {
		init();
	}

	@Override
	public void init() {
		initBackground();
		initHud();
		initGame();
		initInput();
	}

	private void initGame() {
		theMan = new Man(140, 60);
		spawner = new SimpleSpawner(this, AAGame.GAME_WIDTH + 30, 60);

		for (int i = 0; i <= AAGame.GAME_WIDTH + 2*Ground.WIDTH; i += Ground.WIDTH) {
			spawn(new Ground(i, -60));
		}

		spawn(theMan);

		((PlayHud) getHud()).energyBar.bind(theMan.getJetpack());
		((PlayHud) getHud()).scoreValue.bind(theMan);

		STATE = State.START;
		levelVelocity = 0;
		runningdistance = 0;
	}

	private void initInput() {
		Gdx.input.setInputProcessor(new PlayInput(theMan, this));
	}

	public void drawOnScreen(SpriteBatch batch) {
		switch (STATE) {
		case START:
			// TODO draw stuff
		default:
			break;

		}
	}

	public static float getLevelVelocity() {
		return levelVelocity;
	}

	public static void setLevelVelocity(float f) {
		levelVelocity = f;
	}

	static float spawnX = 550, spawnY = 68;

	@Override
	protected void updateScreen(float delta) {
		switch (STATE) {
		case START:
			break;
		case PLAYING:
			spawner.update(getLevelVelocity() * delta);
			levelVelocity += 0.03f;
			runningdistance += getLevelVelocity() * delta * 0.10f;
			break;
		case DEAD:
			break;
		default:
			break;

		}
	}

	public void play() {
		STATE = State.PLAYING;
		levelVelocity = LEVEL_VELOCITY_INITIAL;
	}

	public void stop() {
		PlayScreen.setLevelVelocity(0);
		postHighscore(theMan.getScoreValue().getValue(), getRunningDistance());
	}

	private void postHighscore(long hs, long hm) {
		System.out.println(AAPrefs.get() == null);
		if (AAPrefs.get().getLong("hs") < hs) {
			AAPrefs.get().putLong("hs", hs);
			AAPrefs.get().putLong("hm", hm);
			AAPrefs.get().flush();
		}
	}

	private long getRunningDistance() {
		return (long) runningdistance;
	}
}
