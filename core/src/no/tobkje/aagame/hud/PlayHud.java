package no.tobkje.aagame.hud;

import no.tobkje.aagame.AAGame;

public class PlayHud extends AbstractHudLayer {
	public EnergyBar energyBar;
	public ScoreLabel scoreLabel;
	public ScoreValue scoreValue;

	@Override
	public void init() {
		energyBar = new EnergyBar(this, 40, AAGame.GAME_HEIGHT - 40);
		scoreLabel = new ScoreLabel(this, AAGame.GAME_WIDTH / 2
				- ScoreLabel.WIDTH / 2, AAGame.GAME_HEIGHT - 24
				+ ScoreLabel.HEIGHT);
		scoreValue = new ScoreValue(this, AAGame.GAME_WIDTH / 2,
				AAGame.GAME_HEIGHT - 40 + ScoreValue.HEIGHT);

		addHudElement(energyBar);
		//addHudElement(scoreLabel);
		addHudElement(scoreValue);
	}
}
