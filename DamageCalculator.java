package PokemonJava;

public class DamageCalculator {

	public DamageCalculator() {

	}

	public int calculate_damage(Pokemon attacker, Pokemon defender, Move move) {
		float damage_section_one = (2f * (float)attacker.get_level() / 5f) + 2f;
		float final_damage = damage_section_one * move.get_power() * attacker.get_stat("attack") / defender.get_stat("defense");

		return (Math.round(final_damage / 50) + 2);
	}
}
