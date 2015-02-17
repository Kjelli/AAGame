package no.tobkje.aagame.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture spritesheet;

	public static TextureRegion groundTop, groundTop2, groundFiller, sky;

	public static void load() {
		spritesheet = new Texture("sprites1.png");
		groundTop = new TextureRegion(spritesheet, 0, 0, 16, 16);
		groundTop2 = new TextureRegion(spritesheet, 16, 0, 16, 16);
		groundFiller = new TextureRegion(spritesheet, 0, 16, 16, 16);
		sky = new TextureRegion(spritesheet, 16, 16, 16, 16);
	}

	public static void dispose() {
		spritesheet.dispose();
	}
}
