package no.tobkje.aagame.hud;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractHudLayer implements HudLayer {
	private final ArrayList<HudElement> elements;
	private final ArrayList<HudElement> addQueue;
	private final ArrayList<HudElement> removeQueue;

	public AbstractHudLayer() {
		elements = new ArrayList<HudElement>();
		addQueue = new ArrayList<HudElement>();
		removeQueue = new ArrayList<HudElement>();
	}

	@Override
	public void addHudElement(HudElement element) {
		addQueue.add(element);
	}

	@Override
	public void removeHudElement(HudElement element) {
		removeQueue.add(element);
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
		while (!addQueue.isEmpty()) {
			elements.add(addQueue.remove(0));
		}
		while (!removeQueue.isEmpty()) {
			elements.remove(removeQueue.remove(0));
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
