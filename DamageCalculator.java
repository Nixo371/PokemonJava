package PokemonJava;

public class DamageCalculator {

	public DamageCalculator() {

	}

	public int calculate_damage(int attack, int defense, int power) {
		float damage_modifier = (float)power / 50f;
		damage_modifier += (0.02 * (attack - defense));

		int final_damage = Math.round(attack * damage_modifier);
		if (final_damage < 1) {
			final_damage = 1;
		}

		return (final_damage);
	}
}
