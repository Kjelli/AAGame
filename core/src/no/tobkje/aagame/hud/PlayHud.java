package no.tobkje.aagame.hud;

import no.tobkje.aagame.AAGame;

public class PlayHud extends AbstractHudLayer {
	public FuelLabel fuelLabel;
	public FuelBar energyBar;

	public ScoreLabel scoreLabel;
	public ScoreValue scoreValue;

	public DistanceLabel distanceLabel;
	public DistanceValue distanceValue;

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
				AAGame.GAME_HEIGHT - 75 + ScoreValue.HEIGHT);
		distanceLabel = new DistanceLabel(this, AAGame.GAME_WIDTH * 15 / 20,
				AAGame.GAME_HEIGHT - 20 + DistanceLabel.HEIGHT);
		distanceValue = new DistanceValue(this, AAGame.GAME_WIDTH * 20 / 20,
				AAGame.GAME_HEIGHT - 75 + DistanceValue.HEIGHT);

		addHudElement(fuelLabel);
		addHudElement(energyBar);
		addHudElement(scoreLabel);
		addHudElement(scoreValue);
		addHudElement(distanceLabel);
		addHudElement(distanceValue);
	}
}
