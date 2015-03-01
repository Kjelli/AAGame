package no.tobkje.aagame.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Assets {

	/**
	 * TextureRegion (0, 0) starts in TOP LEFT corner of the .png file.
	 */

	public static Texture tilesheet;
	public static Texture spacesheet;
	public static Texture starsheet;
	public static Texture manSheet;
	public static Texture sawSheet;
	public static Texture baddies;

	public static TextureRegion ground;

	public static TextureRegion space_bg;

	public static TextureRegion star;

	public static Animation mAnimation;
	public static TextureRegion[] man_walk;
	public static Animation flyAnimation;
	public static TextureRegion[] man_fly;
	public static TextureRegion man_fly_nofuel;

	public static TextureRegion halfSaw, saw;

	public static Animation baddie_blue_walk_animation, baddie_green_walk_animation ,baddie_spike_walk_animation;
	public static TextureRegion[] baddie_blue_walk, baddie_green_walk, baddie_spike_walk;
	public static TextureRegion baddie_blue_dead, baddie_green_dead, baddie_spike_dead;

	public static Texture fuel_sheet;
	public static TextureRegion hud_fuel_high, hud_fuel_medium, hud_fuel_low,
			hud_fuel_frame, hud_fuel_frame_left_edge, hud_fuel_frame_right_edge;

	public static BitmapFont font16;

	public static void load() {
		loadBackground();
		loadPlayer();
		loadGameObjects();
		loadHud();

		loadFont();
	}

	private static void loadFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("visitor1.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 16;
		font16 = generator.generateFont(parameter);
		generator.dispose();
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

	private static void loadPlayer() {
		manSheet = new Texture("player.png");
		man_walk = new TextureRegion[8];
		for (int i = 0; i < 8; i++) {
			man_walk[i] = loadAndFlip(manSheet, (i) * 16, 0, 16, 16);
		}
		mAnimation = new Animation(0.10f, man_walk);
		mAnimation.setPlayMode(Animation.PlayMode.LOOP);

		man_fly = new TextureRegion[3];
		for (int i = 0; i < 3; i++) {
			man_fly[i] = loadAndFlip(manSheet, (i) * 16, 16, 16, 16);
		}
		flyAnimation = new Animation(0.10f, man_fly);
		flyAnimation.setPlayMode(Animation.PlayMode.LOOP);
		man_fly_nofuel = loadAndFlip(manSheet, 48, 16, 16, 16);
	}

	private static void loadGameObjects() {
		// Dodgables
		sawSheet = new Texture("saw.png");
		halfSaw = loadAndFlip(sawSheet, 0, 200, 400, 200);
		halfSaw.flip(false, true);
		saw = loadAndFlip(sawSheet, 0, 0, 400, 400);

		// Baddies
		baddies = new Texture("baddies.png");
		baddie_blue_walk = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			baddie_blue_walk[i] = loadAndFlip(baddies, 0 + i * 16, 12, 16, 15);
		}
		baddie_blue_walk_animation = new Animation(0.15f, baddie_blue_walk);
		baddie_blue_walk_animation.setPlayMode(Animation.PlayMode.LOOP);

		baddie_blue_dead = loadAndFlip(baddies, 48, 0, 16, 15);

		baddie_spike_walk = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			baddie_spike_walk[i] = loadAndFlip(baddies, 0 + i * 16, 44, 16, 15);
		}
		baddie_spike_walk_animation = new Animation(0.15f, baddie_spike_walk);
		baddie_spike_walk_animation.setPlayMode(Animation.PlayMode.LOOP);
		
		baddie_green_walk = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			baddie_green_walk[i] = loadAndFlip(baddies, 0 + i * 16, 76, 16, 15);
		}
		baddie_green_walk_animation = new Animation(0.15f, baddie_green_walk);
		baddie_green_walk_animation.setPlayMode(Animation.PlayMode.LOOP);
		
		baddie_green_dead = loadAndFlip(baddies, 16, 60, 16, 15);
	}

	private static void loadHud() {
		fuel_sheet = new Texture("fuel.png");
		hud_fuel_high = loadAndFlip(fuel_sheet, 0, 0, 8, 8);
		hud_fuel_medium = loadAndFlip(fuel_sheet, 8, 0, 8, 8);
		hud_fuel_low = loadAndFlip(fuel_sheet, 16, 0, 8, 8);
		hud_fuel_frame = loadAndFlip(fuel_sheet, 24, 0, 8, 8);
		hud_fuel_frame_right_edge = loadAndFlip(fuel_sheet, 32, 0, 4, 8);
		hud_fuel_frame_left_edge = loadAndFlip(fuel_sheet, 36, 0, 4, 8);
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
		spacesheet.dispose();
		starsheet.dispose();
		manSheet.dispose();
		sawSheet.dispose();
		baddies.dispose();
		fuel_sheet.dispose();
	}
}
