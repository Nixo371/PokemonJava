package PokemonJava;

import java.util.Scanner;

public class PokemonJava {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		Player player = new Player("Nico");
		Trainer[] trainers = new Trainer[2];
		trainers[0] = new Trainer();
		trainers[1] = new Trainer();

		MainLoop main_loop = new MainLoop(player, trainers, scanner);

		Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, 5);
		Pokemon charmander = new Pokemon("Charmander", 4, 5);
		Pokemon squirtle = new Pokemon("Squirtle", 7, 5);

		Move tackle = new Move("Tackle", 1, 4, 35);
		Move scratch = new Move("Scratch", 2, 5, 25);

		bulbasaur.set_move(tackle.clone(), 1);
		charmander.set_move(scratch.clone(), 1);
		squirtle.set_move(tackle.clone(), 1);

		
		System.out.println("Pick a pokemon!");
		System.out.println("(1) Bulbasaur");
		System.out.println("(2) Charmander");
		System.out.println("(3) Squirtle");
		System.out.print("=> ");

		String player_selection = scanner.nextLine();
		if (player_selection.equals("1")) {
			player.add_pokemon(bulbasaur);
			trainers[0].add_pokemon(charmander);
			trainers[1].add_pokemon(squirtle);
		}
		else if (player_selection.equals("2")) {
			player.add_pokemon(charmander);
			trainers[0].add_pokemon(squirtle);
			trainers[1].add_pokemon(bulbasaur);
		}
		else if (player_selection.equals("3")) {
			player.add_pokemon(squirtle);
			trainers[0].add_pokemon(bulbasaur);
			trainers[1].add_pokemon(charmander);
		}
		else {
			scanner.close();
			throw new Error("Nope");
		}

		main_loop.start_loop();
	}
}