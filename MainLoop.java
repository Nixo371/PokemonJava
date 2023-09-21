package PokemonJava;

import java.util.Scanner;
import java.util.Random;

public class MainLoop {
	Player player;
	Trainer[] trainers;
	Scanner scanner;

	public MainLoop(Player player, Trainer[] trainers, Scanner scanner) {
		this.player = player;
		this.trainers = trainers;
		this.scanner = scanner;
	}

	public void start_loop() {
		this.loop();
	}

	private void loop() {
		String selection_string = new String(""
		+ "What would you like to do?\n"
		+ "(1) Battle\n"
		+ "(2) Party\n"
		+ "(3) Heal\n"
		+ "(4) Exit"
		);
		while (true) {
			if (this.player.check_blackout()) {
				System.out.println("All your pokemon fainted! You blacked out!");
				this.exit();
			}
			System.out.println(selection_string);

			String user_input = this.scanner.nextLine();
			if (user_input.equals("1")) {
				this.battle(player, trainers);
			}
			else if (user_input.equals("2")) {
				this.party(player);
			}
			else if (user_input.equals("3")) {
				this.heal(player);
			}
			else if (user_input.equals("4")) {
				this.exit();
			}
			else {
				throw new Error("Invalid selection");
			}
		}
	}

	private void battle(Player player, Trainer[] trainers) {
		Random rng = new Random();
		Trainer opponent = trainers[rng.nextInt(trainers.length)];
		Battle battle = new Battle(player, opponent, this.scanner);

		Trainer winner = battle.start_battle();
		System.out.println(String.format("%s has won the battle!", winner.name));
		if (winner == player) {
			Pokemon winning_pokemon = player.get_lead();
			winning_pokemon.level_up();
			System.out.println(String.format("%s has levelled up to level %d!", winning_pokemon.get_name(), winning_pokemon.get_level()));
		}
		Pokemon opponent_pokemon = opponent.get_lead();
		opponent_pokemon.full_heal(); // heals opponent team :)
	}

	private void party(Player player) {
		System.out.print(player.print_party());
	}

	private void heal(Player player) {
		player.get_party().heal();
		System.out.println("All your pokemon were fully healed!");
	}
	
	private void exit() {
		this.scanner.close();
		System.exit(0);
	}
}
