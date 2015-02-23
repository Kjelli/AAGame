package no.tobkje.aagame.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	/**
	 * TextureRegion (0, 0) starts in TOP LEFT corner of the .png file.
	 */

	public static Texture spritesheet;
	public static TextureRegion ground;

	public static Texture manSheet;
	public static Animation mAnimation;
	public static TextureRegion[] man_walk;

	public static Texture sawSheet;
	public static TextureRegion halfSaw, saw;

	public static void load() {
		loadBackground();
		loadGameObjects();
	}

	private static void loadBackground() {
		spritesheet = new Texture("tiles_2.png");
		ground = loadAndFlip(spritesheet, 0, 160, 80, 160);
	}

	private static void loadGameObjects() {
		manSheet = new Texture("player.png");
		man_walk = new TextureRegion[8];
		for (int i = 0; i < 8; i++) {
			man_walk[i] = loadAndFlip(manSheet, (i) * 16, 0, 16, 16);
		}
		mAnimation = new Animation(0.10f, man_walk);
		mAnimation.setPlayMode(Animation.PlayMode.LOOP);

		sawSheet = new Texture("saw.png");
		halfSaw = loadAndFlip(sawSheet, 0, 200, 400, 200);
		halfSaw.flip(false, true);
		saw = loadAndFlip(sawSheet, 0, 0, 400, 400);
	}

	private static TextureRegion loadAndFlip(Texture spritesheet, int x, int y,
			int width, int height) {
		TextureRegion temp = new TextureRegion(spritesheet, x, y, width, height);
		// temp.flip(false, false);
		return temp;
	}

	public static void dispose() {
		spritesheet.dispose();
		manSheet.dispose();
		sawSheet.dispose();
	}
}
