package no.tobkje.aagame.hud;

import no.tobkje.aagame.AAGame;

public class PlayHud extends AbstractHudLayer {
	public FuelLabel fuelLabel;
	public FuelBar energyBar;

	public ScoreLabel scoreLabel;
	public ScoreValue scoreValue;

	public TimeLabel timeLabel;
	public TimeValue timeValue;

	@Override
	public void init() {
		fuelLabel = new FuelLabel(this, AAGame.GAME_WIDTH / 10,
				AAGame.GAME_HEIGHT - 20 + FuelLabel.HEIGHT);
		energyBar = new FuelBar(this, AAGame.GAME_WIDTH / 10,
				AAGame.GAME_HEIGHT - 50);
		scoreLabel = new ScoreLabel(this, AAGame.GAME_WIDTH / 2
				- ScoreLabel.WIDTH / 2, AAGame.GAME_HEIGHT - 20
				+ ScoreLabel.HEIGHT);
		scoreValue = new ScoreValue(this, AAGame.GAME_WIDTH / 2,
				AAGame.GAME_HEIGHT - 50 + ScoreValue.HEIGHT);
		timeLabel = new TimeLabel(this, AAGame.GAME_WIDTH * 8 / 10,
				AAGame.GAME_HEIGHT - 20 + TimeLabel.HEIGHT);
		timeValue = new TimeValue(this, AAGame.GAME_WIDTH * 13 / 20,
				AAGame.GAME_HEIGHT - 50 + TimeValue.HEIGHT);

		addHudElement(fuelLabel);
		addHudElement(energyBar);
		addHudElement(scoreLabel);
		addHudElement(scoreValue);
		addHudElement(timeLabel);
		addHudElement(timeValue);
	}
}
