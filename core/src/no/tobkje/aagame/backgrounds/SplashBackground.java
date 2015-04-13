package no.tobkje.aagame.backgrounds;

import com.badlogic.gdx.graphics.Color;

public class SplashBackground extends AbstractBackground {

	public SplashBackground() {
		super(0);
	}

	@Override
	public void init() {
		setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		System.out.println("inited");
	}

}
