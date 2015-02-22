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
		// Tryna make man appear / run (Y)
		manSheet = new Texture("rock-running-3.png");
		manStart = loadAndFlip(manSheet, 14, 0, 121, 160);
		manMiddle = loadAndFlip(manSheet, 185, 0, 121, 160);
		manEnd = loadAndFlip(manSheet, 330, 0, 121, 160);

		TextureRegion[] men = { manStart, manMiddle, manEnd };
		mAnimation = new Animation(0.15f, men);
		mAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
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
	}
}
