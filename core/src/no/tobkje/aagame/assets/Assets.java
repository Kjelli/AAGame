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

	public static Texture tileSheet;
	public static Texture spacesheet;
	public static Texture starSheet;
	public static Texture manSheet;
	public static Texture baddieSheet;
	public static Texture fuelSheet;
	public static Texture splashSheet;
	public static Texture particleSmokeSheet;

	public static TextureRegion splash;

	public static TextureRegion ground;
	public static TextureRegion space_bg;
	public static TextureRegion star;

	public static Animation mAnimation;
	public static TextureRegion[] man_walk;
	public static Animation flyAnimation;
	public static TextureRegion[] man_fly;
	public static TextureRegion man_fly_nofuel;

	public static TextureRegion spike;

	public static TextureRegion smoke;

	public static Animation baddie_blue_walk_animation,
			baddie_green_walk_animation, baddie_spike_walk_animation;
	public static TextureRegion[] baddie_blue_walk, baddie_green_walk,
			baddie_spike_walk;
	public static TextureRegion baddie_blue_dead, baddie_green_dead,
			baddie_spike_dead;

	public static TextureRegion hud_fuel_high, hud_fuel_medium, hud_fuel_low,
			hud_fuel_frame, hud_fuel_frame_left_edge,
			hud_fuel_frame_right_edge;

	public static BitmapFont font16, font20, font30;

	public static void load() {

		loadBackground();
		loadPlayer();
		loadGameObjects();
		loadParticles();

		loadHud();

		loadFont();
	}

	private static void loadParticles() {
		particleSmokeSheet = new Texture("smoke2.png");
		smoke = loadAndFlip(particleSmokeSheet, 0, 0, 16, 16);
	}

	public static void loadSplash() {
		splashSheet = new Texture("kjelli.png");
		splash = new TextureRegion(splashSheet, 0, 0, splashSheet.getWidth(),
				splashSheet.getHeight());
	}

	private static void loadFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("visitor1.ttf"));

		FreeTypeFontParameter size16 = new FreeTypeFontParameter();
		size16.size = 16;
		font16 = generator.generateFont(size16);

		FreeTypeFontParameter size20 = new FreeTypeFontParameter();
		size20.size = 20;
		font20 = generator.generateFont(size20);

		FreeTypeFontParameter size30 = new FreeTypeFontParameter();
		size30.size = 40;
		font30 = generator.generateFont(size30);

		generator.dispose();
	}

	private static void loadBackground() {
		tileSheet = new Texture("tiles_1.png");
		ground = loadAndFlip(tileSheet, 0, 160, 80, 160);

		spacesheet = new Texture("space-2.png");
		space_bg = loadAndFlip(spacesheet, 0, 0, spacesheet.getWidth(),
				spacesheet.getHeight());

		starSheet = new Texture("star.png");
		star = loadAndFlip(starSheet, 0, 0, starSheet.getWidth(),
				starSheet.getHeight());

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
		spike = loadAndFlip(tileSheet, 160, 0, 80, 80);

		// Baddies
		baddieSheet = new Texture("baddies.png");
		baddie_blue_walk = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			baddie_blue_walk[i] = loadAndFlip(baddieSheet, 0 + i * 16, 12, 16,
					15);
		}
		baddie_blue_walk_animation = new Animation(0.15f, baddie_blue_walk);
		baddie_blue_walk_animation.setPlayMode(Animation.PlayMode.LOOP);

		baddie_blue_dead = loadAndFlip(baddieSheet, 32, 0, 16, 15);

		baddie_spike_walk = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			baddie_spike_walk[i] = loadAndFlip(baddieSheet, 0 + i * 16, 44, 16,
					15);
		}
		baddie_spike_walk_animation = new Animation(0.15f, baddie_spike_walk);
		baddie_spike_walk_animation.setPlayMode(Animation.PlayMode.LOOP);

		baddie_green_walk = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			baddie_green_walk[i] = loadAndFlip(baddieSheet, 0 + i * 16, 76, 16,
					15);
		}
		baddie_green_walk_animation = new Animation(0.15f, baddie_green_walk);
		baddie_green_walk_animation.setPlayMode(Animation.PlayMode.LOOP);

		baddie_green_dead = loadAndFlip(baddieSheet, 32, 60, 16, 15);
	}

	private static void loadHud() {
		fuelSheet = new Texture("fuel.png");
		hud_fuel_high = loadAndFlip(fuelSheet, 0, 0, 8, 8);
		hud_fuel_medium = loadAndFlip(fuelSheet, 8, 0, 8, 8);
		hud_fuel_low = loadAndFlip(fuelSheet, 16, 0, 8, 8);
		hud_fuel_frame = loadAndFlip(fuelSheet, 24, 0, 8, 8);
		hud_fuel_frame_right_edge = loadAndFlip(fuelSheet, 32, 0, 4, 8);
		hud_fuel_frame_left_edge = loadAndFlip(fuelSheet, 36, 0, 4, 8);
	}

	private static TextureRegion loadAndFlip(Texture spritesheet, int x, int y,
			int width, int height) {
		TextureRegion temp = new TextureRegion(spritesheet, x, y, width, height);
		// temp.flip(false, false);
		return temp;
	}

	public static void dispose() {
		if (splashSheet != null) {
			splashSheet.dispose();
		}
		if (tileSheet != null)
			tileSheet.dispose();

		if (manSheet != null)
			manSheet.dispose();

		if (spacesheet != null)
			spacesheet.dispose();

		if (starSheet != null)
			starSheet.dispose();

		if (manSheet != null)
			manSheet.dispose();

		if (baddieSheet != null)
			baddieSheet.dispose();

		if (fuelSheet != null)
			fuelSheet.dispose();

		if (font16 != null)
			font16.dispose();

		if (font20 != null)
			font20.dispose();

	}
}
