package no.tobkje.aagame.backgrounds;

import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Background {
	Layer[] getLayers();

	void init();

	void update(float delta);

	void render(SpriteBatch batch);

	GameScreen getParentScreen();

	Color getColor();

	void clear();
}
