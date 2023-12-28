package PokemonJava;

import PokemonJava.Pokemon.Move;
import PokemonJava.Pokemon.Pokemon;

public class DamageCalculator {

	public DamageCalculator() {

	}

	public int calculate_damage(Pokemon attacker, Pokemon defender, Move move) {
		float level = attacker.get_level();
		float critical = 1;
		if (move == null)
			return (-1);
		float power = move.get_power();
		float attack = attacker.get_stats().get_attack();
		float defense = defender.get_stats().get_defense();
		float stab = 1;
		float type1 = 1;
		float type2 = 1;
		float modifier = 1;
		if (move.get_attack_type() == 1) {
			attack = attacker.get_stats().get_special();
			defense = defender.get_stats().get_special();
		}
		if (move.get_type() == attacker.get_type1() || move.get_type() == attacker.get_type2()) {
			stab = 1.5f;
		}
		float damage1 = ((2 * level * critical) / 5) + 2;
		float damage2 = (attack / defense) * power;
		float damage3 = (stab * type1 * type2 * modifier);
		float final_damage = (((damage1 * damage2) / 50) + 2) * damage3;
		
		return (Math.round(final_damage));
	}
}
