package PokemonJava;

import java.util.Scanner;

public class Battle {
	Player player;
	Trainer opponent;
	Scanner scanner;

	public Battle(Player player, Trainer trainer, Scanner scanner) {
		this.player = player;
		this.opponent = trainer;
		this.scanner = scanner;
	}

	public Trainer start_battle() {
		Pokemon player_pokemon = send_out_lead(player);
		Pokemon trainer_pokemon = send_out_lead(opponent);

		int selected_move_slot;
		while (true) {
			System.out.print(get_battle_display(player_pokemon, trainer_pokemon));
			System.out.print(player_pokemon.print_move_selection());

			selected_move_slot = Integer.parseInt(this.scanner.nextLine());

			battle_turn(player_pokemon, trainer_pokemon, selected_move_slot);
			if (is_battle_over(player, opponent)) {
				return(end_battle(player, opponent));
			}

			battle_turn(trainer_pokemon, player_pokemon, 1);
			if (is_battle_over(player, opponent)) {
				return(end_battle(player, opponent));
			}
		}

	}

	private Pokemon send_out_lead(Trainer trainer) {
		Pokemon lead_pokemon = trainer.get_lead();
		System.out.println(String.format("%s has sent out %s!", trainer.name, lead_pokemon.get_name()));

		return (lead_pokemon);
	}

	private void battle_turn(Pokemon attacker, Pokemon defender, int move_slot) {
		int damage_dealt = attacker.use_move(move_slot);
		System.out.println(String.format("%s used %s!", attacker.get_name(), attacker.get_move(move_slot).get_name()));
		defender.hit(damage_dealt);
		System.out.println(String.format("%s was hit for %d damage!", defender.get_name(), damage_dealt));
	}

	private boolean is_battle_over(Trainer trainer1, Trainer trainer2) {
		return (trainer1.check_blackout() || trainer2.check_blackout());
	}

	private Trainer end_battle(Player player, Trainer opponent) {
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

	private String get_battle_display(Pokemon player_pokemon, Pokemon trainer_pokemon) {
		String line = new String("------------------------------");
		String empty_line = new String("|                            |");
		String empty = new String("                ");

		String battle_display = new String();

		battle_display = battle_display.concat(line);
		battle_display = battle_display.concat(empty);
		battle_display = battle_display.concat(line);
		battle_display = battle_display.concat("\n");

		battle_display = battle_display.concat(empty_line);
		battle_display = battle_display.concat(empty);
		battle_display = battle_display.concat(empty_line);
		battle_display = battle_display.concat("\n");

		battle_display = battle_display.concat(center_string(String.format("%s Lv.%d", player_pokemon.get_name(), player_pokemon.get_level()), line.length()));
		battle_display = battle_display.concat(empty);
		battle_display = battle_display.concat(center_string(String.format("%s Lv.%d", trainer_pokemon.get_name(), trainer_pokemon.get_level()), line.length()));
		battle_display = battle_display.concat("\n");

		battle_display = battle_display.concat(center_string(String.format("%d / %d", player_pokemon.get_hp(), player_pokemon.get_max_hp()), line.length()));
		battle_display = battle_display.concat(empty);
		battle_display = battle_display.concat(center_string(String.format("%d / %d", trainer_pokemon.get_hp(), trainer_pokemon.get_max_hp()), line.length()));
		battle_display = battle_display.concat("\n");

		battle_display = battle_display.concat(empty_line);
		battle_display = battle_display.concat(empty);
		battle_display = battle_display.concat(empty_line);
		battle_display = battle_display.concat("\n");

		battle_display = battle_display.concat(line);
		battle_display = battle_display.concat(empty);
		battle_display = battle_display.concat(line);
		battle_display = battle_display.concat("\n");

		return (battle_display);
	}

}
