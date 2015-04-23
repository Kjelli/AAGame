package no.tobkje.aagame.gameobjects.baddies;

import no.tobkje.aagame.gameobjects.GameObject;
import no.tobkje.aagame.gameobjects.player.Man;

public interface Baddie extends GameObject {
	void hurt(Man man);
}
