package no.tobkje.aagame.hud;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractHudLayer implements HudLayer {
	private final ArrayList<HudElement> elements;

	public AbstractHudLayer() {
		elements = new ArrayList<HudElement>();
	}

	@Override
	public void addHudElement(HudElement element) {
		elements.add(element);
	}

	@Override
	public void removeHudElement(HudElement element) {
		elements.remove(element);
	}

	@Override
	public void clear() {
		for (HudElement element : elements) {
			element.destroy();
		}
		elements.clear();
	}

	@Override
	public void update(float delta) {
		for (HudElement element : elements) {
			element.update(delta);
		}

	}

	@Override
	public void render(SpriteBatch batch) {
		for (HudElement element : elements) {
			element.draw(batch);
		}
	}
	
	@Override
	public void reset() {
		clear();
		init();
	}
}
