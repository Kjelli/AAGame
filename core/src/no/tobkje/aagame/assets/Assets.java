package no.tobkje.aagame.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	/**
	 * TextureRegion (0, 0) starts in TOP LEFT corner of the .png file.
	 */

	public static Texture tilesheet;
	public static TextureRegion ground;

	public static Texture spacesheet;
	public static TextureRegion space_bg;

	public static Texture starsheet;
	public static TextureRegion star;

	public static Texture manSheet;
	public static Animation mAnimation;
	public static TextureRegion[] man_walk;

	public static Texture flyingSheet;
	public static Animation flyAnimation;
	public static TextureRegion[] man_fly;

	public static Texture sawSheet;
	public static TextureRegion halfSaw, saw;

	public static void load() {
		loadBackground();
		loadGameObjects();
	}

	private static void loadBackground() {
		tilesheet = new Texture("tiles_1.png");
		ground = loadAndFlip(tilesheet, 0, 160, 80, 160);

		spacesheet = new Texture("space-1.png");
		space_bg = loadAndFlip(spacesheet, 0, 0, spacesheet.getWidth(),
				spacesheet.getHeight());

		starsheet = new Texture("star.png");
		star = loadAndFlip(starsheet, 0, 0, starsheet.getWidth(),
				starsheet.getHeight());

	}

	private static void loadGameObjects() {
		manSheet = new Texture("player.png");
		man_walk = new TextureRegion[8];
		for (int i = 0; i < 8; i++) {
			man_walk[i] = loadAndFlip(manSheet, (i) * 16, 0, 16, 16);
		}
		mAnimation = new Animation(0.10f, man_walk);
		mAnimation.setPlayMode(Animation.PlayMode.LOOP);
		
		flyingSheet = new Texture("playerFly.png");
		man_fly = new TextureRegion[3];
		for (int i = 0; i < 8; i++) {
			man_fly[i] = loadAndFlip(flyingSheet, i * 16, 0, 16, 16);
		}
		flyAnimation = new Animation(0.10f, man_fly);
		flyAnimation.setPlayMode(Animation.PlayMode.LOOP);

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
		tilesheet.dispose();
		manSheet.dispose();
		sawSheet.dispose();
	}
}
