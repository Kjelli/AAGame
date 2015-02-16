package no.tobkje.aagame.tweenaccessors;

import no.tobkje.aagame.gameobjects.GameObject;
import aurelienribon.tweenengine.TweenAccessor;

public class GameObjectAccessor implements TweenAccessor<GameObject> {
	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;
	public static final int POSITION_XY = 3;

	@Override
	public int getValues(GameObject target, int type, float[] returnVal) {
		switch (type) {
		case POSITION_X:
			returnVal[0] = target.getPosition().x;
			return 1;
		case POSITION_Y:
			returnVal[0] = target.getPosition().y;
			return 1;
		case POSITION_XY:
			returnVal[0] = target.getPosition().x;
			returnVal[1] = target.getPosition().y;
			return 2;
		default:
			return 0;
		}
	}

	@Override
	public void setValues(GameObject target, int type, float[] newVal) {
		switch (type) {
		case POSITION_X:
			target.getPosition().x = newVal[0];
			break;
		case POSITION_Y:
			target.getPosition().y = newVal[0];
			break;
		case POSITION_XY:
			target.getPosition().x = newVal[0];
			target.getPosition().y = newVal[1];
			break;
		}
	}

}
