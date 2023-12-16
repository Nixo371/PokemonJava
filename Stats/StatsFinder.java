package PokemonJava.Pokemon;

public class StatsFinder {
	
	public StatsFinder() {

	}

	// Note that this function will return
	// the base stats of a pokemon at level 1
	public BaseStats get_base_stats_from_id(int id) {
		int h, a, d;
		
		switch (id) {
			case 1: // Bulbasaur
				h = 45;
				a = 49;
				d = 49;
				break;

			case 4: // Charmander
				h = 39;
				a = 52;
				d = 43;
				break;

			case 7: // Squirtle
				h = 44;
				a = 48;
				d = 65;
				break;
		
			default:
				h = 0;
				a = 0;
				d = 0;
				break;
		}
		BaseStats base_stats = new BaseStats(h, a, d);
		return (base_stats);
	}

	public BaseStats scale_stats_by_level(BaseStats base_stats, int level) {
		int scaled_health = (int)Math.round(base_stats.get_health() * (1 + (level * 0.05)));
		int scaled_attack = (int)Math.round(base_stats.get_attack() * (1 + (level * 0.05)));
		int scaled_defense = (int)Math.round(base_stats.get_defense() * (1 + (level * 0.05)));
	
		base_stats.set_health(scaled_health);
		base_stats.set_attack(scaled_attack);
		base_stats.set_defense(scaled_defense);

		return (base_stats);
	}
}
