package no.tobkje.aagame.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture spritesheet;
	public static TextureRegion groundTop, groundTop2, groundFiller, sky;

	public static Texture manSheet;
	public static Animation mAnimation;
	public static TextureRegion manStart, manMiddle, manEnd;

	public static Texture sawSheet;
	public static TextureRegion halfSaw, saw;

	public static void load() {
		loadBackground();
		loadGameObjects();
	}

	private static void loadBackground() {
		spritesheet = new Texture("sprites1.png");
		groundTop = loadAndFlip(spritesheet, 0, 0, 16, 16);
		groundTop2 = loadAndFlip(spritesheet, 16, 0, 16, 16);
		groundFiller = loadAndFlip(spritesheet, 0, 16, 16, 16);
		sky = loadAndFlip(spritesheet, 16, 16, 16, 16);
	}

	private static void loadGameObjects() {
		manSheet = new Texture("rock-running-3.png");
		manStart = loadAndFlip(manSheet, 14, 0, 121, 160);
		manMiddle = loadAndFlip(manSheet, 185, 0, 121, 160);
		manEnd = loadAndFlip(manSheet, 330, 0, 121, 160);

		TextureRegion[] men = { manStart, manMiddle, manEnd };
		mAnimation = new Animation(0.15f, men);
		mAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

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
