package no.tobkje.aagame.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface HudLayer {
	void init();

	void update(float delta);

	void addHudElement(HudElement element);

	void removeHudElement(HudElement element);

	void clear();

	void render(SpriteBatch batch);

	void reset();

}
