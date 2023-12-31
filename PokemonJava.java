package PokemonJava;

import java.util.Scanner;

import PokemonJava.Pokemon.Move;
import PokemonJava.Pokemon.Pokemon;
import PokemonJava.Trainer.Player;
import PokemonJava.Trainer.Trainer;

public class PokemonJava {
	public static void main(String[] args)
	{
		Player player = new Player("Nico");
		Trainer[] trainers = new Trainer[2];
		trainers[0] = new Trainer();
		trainers[1] = new Trainer();

		MainLoop main_loop = new MainLoop(player);

		Pokemon bulbasaur = new Pokemon(1, 5);
		Pokemon charmander = new Pokemon(4, 5);
		Pokemon squirtle = new Pokemon(7, 5);

		bulbasaur.set_move(new Move("Tackle", 33, 40, 35), 1);
		charmander.set_move(new Move("Scratch", 10, 40, 35), 1);
		squirtle.set_move(new Move("Tackle", 33, 40, 35), 1);

		
		System.out.println("Pick a pokemon!");
		System.out.println("(1) Bulbasaur");
		System.out.println("(2) Charmander");
		System.out.println("(3) Squirtle");
		System.out.print("=> ");

		Scanner scanner = new Scanner(System.in);

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

		main_loop.start_loop(scanner);
	}
}