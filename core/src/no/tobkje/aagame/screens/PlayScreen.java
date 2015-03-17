package no.tobkje.aagame.screens;

import no.tobkje.aagame.backgrounds.Background;
import no.tobkje.aagame.backgrounds.PlayBackground;
import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.Ground;
import no.tobkje.aagame.gameobjects.baddies.Baddie;
import no.tobkje.aagame.gameobjects.baddies.MiniManBlue;
import no.tobkje.aagame.gameobjects.baddies.MiniManGreen;
import no.tobkje.aagame.gameobjects.baddies.MiniManSpike;
import no.tobkje.aagame.gameobjects.baddies.Spike;
import no.tobkje.aagame.gameobjects.player.Man;
import no.tobkje.aagame.hud.HudLayer;
import no.tobkje.aagame.hud.PlayHud;
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

		Background background = new PlayBackground();
		setBackground(background);
		HudLayer playHud = new PlayHud();
		setHud(playHud);
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
		theMan = new Man(140, 68);

		for (int i = 0; i <= 10; i++) {
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
		levelVelocity += 0.05f;
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

		Baddie newb = null;
		if (Math.random() < 0.005f)
			newb = new MiniManBlue(spawnX, spawnY);
		else if (Math.random() < 0.005f)
			newb = new MiniManSpike(spawnX, spawnY);
		else if (Math.random() < 0.005f)
			newb = new MiniManGreen(spawnX, spawnY);
		else if (Math.random() < 0.005f)
			newb = new Spike(spawnX, spawnY);

		if (newb != null)
			spawn((GameObject) newb);
	}
}
