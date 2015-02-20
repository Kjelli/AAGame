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
		spritesheet = new Texture("sprites1.png");
		groundTop = new TextureRegion(spritesheet, 0, 0, 16, 16);
		groundTop2 = new TextureRegion(spritesheet, 16, 0, 16, 16);
		groundFiller = new TextureRegion(spritesheet, 0, 16, 16, 16);
		sky = new TextureRegion(spritesheet, 16, 16, 16, 16);
		
		
		// Tryna make man appear / run (Y)
		manSheet = new Texture("rock-running-3.png");
		manStart = new TextureRegion(manSheet, 14, 0, 121, 160);
		manMiddle = new TextureRegion(manSheet,185, 0, 121, 160 );
		manEnd = new TextureRegion(manSheet, 330, 0, 121, 160);
		
		TextureRegion[] men = {manStart, manMiddle, manEnd};
		mAnimation = new Animation (0.25f, men);
		mAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	public static void dispose() {
		spritesheet.dispose();
		manSheet.dispose();
	}
}
