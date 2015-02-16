package no.tobkje.aagame.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture spritesheet;

	public static TextureRegion sprite1;

	public static void load() {
		spritesheet = new Texture("pear.jpg");
		sprite1 = new TextureRegion(spritesheet, 0, 0, 236, 177);
	}

	public static void dispose() {
		spritesheet.dispose();
	}
}
