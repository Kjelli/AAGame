package no.tobkje.aagame.backgrounds;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractBackground implements Background {
	private final Layer[] layers;

	public AbstractBackground(int layers) {
		this.layers = new Layer[layers];
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
	
	public void render(SpriteBatch batch){
		for(Layer l : layers){
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
	public void reset() {
		for(Layer l : layers){
			l.reset();
		}
	}

}
