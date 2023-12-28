package PokemonJava.Pokemon;

import java.util.Random;

public class IndividualValues extends Stats {

	public IndividualValues() {
		super(0, 0, 0, 0, 0);
		Random rand = new Random();

		set_hp(rand.nextInt(16));
		set_attack(rand.nextInt(16));
		set_defense(rand.nextInt(16));
		set_speed(rand.nextInt(16));
		set_special(rand.nextInt(16));
	}

	public IndividualValues(int hp, int attack, int defense, int speed, int special) {
		super(hp, attack, defense, speed, special);
	}
}
