package no.tobkje.aagame.hud;

import no.tobkje.aagame.AAGame;
import no.tobkje.aagame.assets.Assets;
import no.tobkje.aagame.screens.PlayScreen;
import no.tobkje.aagame.screens.PlayScreen.State;
import no.tobkje.aagame.settings.AAPrefs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class TapToBeginOverlay extends AbstractHudElement {
	BitmapFont font;

	public static final String START_STRING = "Tap to begin!";

	String best;

	Color overlayColor;

	float midX;
	float midY;

	float tapX, tapY;
	float bestX, bestY;

	public TapToBeginOverlay(HudLayer parentLayer) {
		super(parentLayer, 0, 0, AAGame.GAME_WIDTH, AAGame.GAME_HEIGHT);

		font = Assets.font30a;
		overlayColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);

		long bestScore = AAPrefs.get().getLong("hs");
		long bestMeters = AAPrefs.get().getLong("hm");
		System.out.println(bestScore);
		if (bestScore >= 0)
			best = String.format("BEST: %d (%d meters)", bestScore, bestMeters);

		midX = getWidth() / 2;
		midY = getHeight() / 2;

		tapX = midX - font.getBounds(START_STRING).width / 2;
		tapY = midY - font.getBounds(START_STRING).height / 2;

		if (best != null) {
			bestX = midX - font.getBounds(best).width / 2;
			bestY = midY - font.getBounds(best).height / 2 + 100;
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		Color defaultColor = batch.getColor();
		batch.setColor(overlayColor);
		batch.draw(Assets.white, 0, 0, getWidth(), getHeight());
		batch.setColor(defaultColor);
		if (best != null)
			font.draw(batch, best, bestX, bestY);
		font.draw(batch, START_STRING, tapX, tapY);

	}

	@Override
	public void onSpawn() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(float delta) {
		if (PlayScreen.STATE == State.START) {
			tapY = ((float) (midY + Math.sin(PlayScreen.getRuntime() / 1) * 20));
			overlayColor.g = overlayColor.b = overlayColor.r = (float) Math
					.sin(PlayScreen.getRuntime() / 1) * 0.25f + 0.75f;
			if (overlayColor.a > 0.4) {
				overlayColor.a *= 0.97;
			}
		} else {
			overlayColor.a *= 0.9;
			bestX -= 350f * delta;
			tapX -= 350f * delta;
		}
	}
}
