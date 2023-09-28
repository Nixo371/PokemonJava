package PokemonJava;

import java.util.Random;

public class IndividualValues extends Stats {

	public IndividualValues() {
		Random rand = new Random();

		set_health(rand.nextInt(16));
		set_attack(rand.nextInt(16));
		set_defense(rand.nextInt(16));
	}

	
}
