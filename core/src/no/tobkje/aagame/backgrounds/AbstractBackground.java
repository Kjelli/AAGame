package no.tobkje.aagame.backgrounds;

import no.tobkje.aagame.screens.GameScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractBackground implements Background {
	private final Layer[] layers;
	GameScreen parentScreen;
	private Color color;

	public AbstractBackground(int layers) {
		this.layers = new Layer[layers];
		color = new Color(0, 0, 0, 1f);
	}

	public Layer[] getLayers() {
		return layers;
	}

	public void setLayer(int index, Layer layer) {
		if (index < 0 || index > layers.length) {
			throw new ArrayIndexOutOfBoundsException("Layer " + index
					+ " does not exist!");
		}

		layers[index] = layer;
	}

	public void render(SpriteBatch batch) {
		for (Layer l : layers) {
			l.render(batch);
		}
	}

	@Override
	public void update(float delta) {
		for (Layer l : layers) {
			l.update(delta);
		}
	}

	@Override
	public GameScreen getParentScreen() {
		return parentScreen;
	}

	@Override
	public void clear() {
		for (Layer l : layers) {
			l.clear();
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

}
