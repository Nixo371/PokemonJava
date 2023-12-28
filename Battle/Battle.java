package PokemonJava.Battle;

import PokemonJava.DamageCalculator;
import PokemonJava.Pokemon.Pokemon;
import PokemonJava.Trainer.Player;
import PokemonJava.Trainer.Trainer;

public class Battle {
	Player player;
	Trainer opponent;
	DamageCalculator dmg_calc;

	public Battle(Player player, Trainer trainer) {
		this.player = player;
		this.opponent = trainer;
		this.dmg_calc = new DamageCalculator();
	}

	public boolean is_battle_over(Trainer trainer1, Trainer trainer2) {
		return (trainer1.check_blackout() || trainer2.check_blackout());
	}

	public Trainer end_battle(Player player, Trainer opponent) {
		if (player.check_blackout()) {
			return (opponent);
		}
		else if (opponent.check_blackout()) {
			return (player);
		}
		else {
			return (null);
		}
	}

	private String center_string(String string, int line_size) {
		int space = ((line_size - string.length()) / 2) - 1;
		String centered_string = new String();
		centered_string = centered_string.concat("|");
		for (int i = 0; i < space; i++) {
			centered_string = centered_string.concat(" ");
		}
		centered_string = centered_string.concat(string);
		for (int i = 0; i < space; i++) {
			centered_string = centered_string.concat(" ");
		}
		while (centered_string.length() < line_size - 1) {
			centered_string = centered_string.concat(" ");
		}
		centered_string = centered_string.concat("|");
		return (centered_string);
	}

	public String get_battle_display(Pokemon player_pokemon, Pokemon trainer_pokemon) {
		String line = new String("------------------------------");
		String empty_line = new String("|                            |");
		String empty = new String("                ");

		StringBuilder sb = new StringBuilder();

		sb.append(line);
		sb.append(empty);
		sb.append(line);
		sb.append("\n");

		sb.append(empty_line);
		sb.append(empty);
		sb.append(empty_line);
		sb.append("\n");

		sb.append(center_string(String.format("%s Lv.%d", player_pokemon.get_name(), player_pokemon.get_level()), line.length()));
		sb.append(empty);
		sb.append(center_string(String.format("%s Lv.%d", trainer_pokemon.get_name(), trainer_pokemon.get_level()), line.length()));
		sb.append("\n");

		sb.append(center_string(String.format("%d / %d", player_pokemon.get_hp(), player_pokemon.get_max_hp()), line.length()));
		sb.append(empty);
		sb.append(center_string(String.format("%d / %d", trainer_pokemon.get_hp(), trainer_pokemon.get_max_hp()), line.length()));
		sb.append("\n");

		sb.append(empty_line);
		sb.append(empty);
		sb.append(empty_line);
		sb.append("\n");

		sb.append(line);
		sb.append(empty);
		sb.append(line);
		sb.append("\n");

		return (sb.toString());
	}

}
