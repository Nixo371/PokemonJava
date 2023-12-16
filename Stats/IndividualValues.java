package PokemonJava.Stats;

import java.util.Random;

public class IndividualValues extends Stats {

	public IndividualValues() {
		super(0, 0, 0, 0, 0, 0);
		Random rand = new Random();

		set_hp(rand.nextInt(16));
		set_attack(rand.nextInt(16));
		set_defense(rand.nextInt(16));
		set_sp_attack(rand.nextInt(16));
		set_sp_defense(rand.nextInt(16));
		set_speed(rand.nextInt(16));
	}

	public IndividualValues(int hp, int attack, int defense, int sp_attack, int sp_defense, int speed) {
		super(hp, attack, defense, sp_attack, sp_defense, speed);
	}

	
}
