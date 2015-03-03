package no.tobkje.aagame.tweenaccessors;

import com.badlogic.gdx.graphics.Color;

import no.tobkje.aagame.gameobjects.GameObject;
import aurelienribon.tweenengine.TweenAccessor;

public class ColorAccessor implements TweenAccessor<Color> {
	public static final int COLOR_RGBA = 1;

	@Override
	public int getValues(Color target, int type, float[] returnVal) {
		switch (type) {
		case COLOR_RGBA:
			returnVal[0] = target.r;
			returnVal[1] = target.g;
			returnVal[2] = target.b;
			returnVal[3] = target.a;
			return 4;
		default:
			return 0;
		}
	}

	@Override
	public void setValues(Color target, int type, float[] newVal) {
		switch (type) {
		case COLOR_RGBA:
			target.r = newVal[0];
			target.g = newVal[1];
			target.b = newVal[2];
			target.a = newVal[3];
		}
	}

}
