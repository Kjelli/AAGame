package no.tobkje.aagame.hud;

import no.tobkje.aagame.AAGame;

public class PlayHud extends AbstractHudLayer {
	public EnergyBar energyBar;

	@Override
	public void init() {
		energyBar = new EnergyBar(this, 40, AAGame.GAME_HEIGHT - 40);
		addHudElement(energyBar);
	}

}
