package no.tobkje.aagame.screens;

import no.tobkje.aagame.backgrounds.Background;
import no.tobkje.aagame.backgrounds.PlayBackground;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.hud.HudLayer;
import no.tobkje.aagame.hud.PlayHud;
import no.tobkje.aagame.input.ManInput;
import no.tobkje.aagame.spawners.SimpleSpawner;
import no.tobkje.aagame.spawners.Spawner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class PlayScreen extends AbstractGameScreen {

	public static final float LEVEL_VELOCITY_INITIAL = 65.0f;
	private static float levelVelocity;

	Spawner spawner;

	Man theMan;
	OrthographicCamera camera;

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
		theMan = new Man(140, 240);
		spawner = new SimpleSpawner(this, 550, 60);

		for (int i = 0; i <= 11; i++) {
			spawn(new Ground(Ground.WIDTH * i, -60));
		}

		spawn(theMan);

		((PlayHud) getHud()).energyBar.bind(theMan.getJetpack());
		((PlayHud) getHud()).scoreValue.bind(theMan);

		levelVelocity = LEVEL_VELOCITY_INITIAL;
	}

	private void initInput() {
		Gdx.input.setInputProcessor(new ManInput(theMan));
	}

	public void draw(float delta) {
		super.render(delta);
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
		spawner.update(getLevelVelocity() * delta);
		levelVelocity += 0.01f;
	}
}
