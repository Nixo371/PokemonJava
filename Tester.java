package PokemonJava;

public class Tester {
	public static void main(String[] args) {
		//damage_calculator_test();
		stats_finder_test();
	}

	private static void damage_calculator_test() {
		damage_calculator_calculate_damage_test();
	}

	private static void damage_calculator_calculate_damage_test() {
		Move tackle = new Move("Tackle", 1, 40, 35);
		DamageCalculator dmg_calc = new DamageCalculator();

		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.println(String.format("Tackle (%d -> %d): %d damage!", i * 10, j * 10, dmg_calc.calculate_damage(i * 10, j * 10, tackle.get_power())));
			}
		}
	}

	private static void stats_finder_test() {
		StatsFinder stats_finder = new StatsFinder();
		stats_finder_get_base_test(stats_finder);
		//stats_finder_scale_stats_test(stats_finder);
	}

	private static void stats_finder_get_base_test(StatsFinder stats_finder) {
		for (int i = 0; i < 151; i++) {
			BaseStats test_stats = stats_finder.get_base_stats_from_id(i);
			if (i == 1 && 
			test_stats.get_health() == 15 && 
			test_stats.get_attack() == 12 && 
			test_stats.get_defense() == 16) {
				System.out.println("Test 1 passed!");
			}
			else if (i == 4 && 
			test_stats.get_health() == 15 && 
			test_stats.get_attack() == 15 && 
			test_stats.get_defense() == 13) {
				System.out.println("Test 4 passed!");
			}
			else if (i == 7 && 
			test_stats.get_health() == 15 && 
			test_stats.get_attack() == 14 && 
			test_stats.get_defense() == 14) {
				System.out.println("Test 7 passed!");
			}
			else if ((i != 1 || i != 4 || i != 7) && 
			test_stats.get_health() == 0 && 
			test_stats.get_attack() == 0 && 
			test_stats.get_defense() == 0) {
				System.out.println(String.format("Test %d passed!", i));
			}
			else {
				System.out.println(String.format("Test %d failed!", i));
			}
		}
	}

	private static void stats_finder_scale_stats_test(StatsFinder stats_finder) {

	}
}
