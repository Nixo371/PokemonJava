package PokemonJava;

import java.util.Scanner;

public class PokemonJava {
	public static void main(String[] args)
	{
		Player player = new Player();

		Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, 5);
		Pokemon charmander = new Pokemon("Charmander", 4, 5);
		Pokemon squirtle = new Pokemon("Squirtle", 7, 5);

		bulbasaur.set_move(new Move("Tackle", 1, 4, 35), 1);
		charmander.set_move(new Move("Scratch", 2, 5, 25), 1);
		squirtle.set_move(new Move("Tackle", 1, 4, 35), 1);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Pick a pokemon!");
		System.out.println("1. Bulbasaur");
		System.out.println("2. Charmander");
		System.out.println("3. Squirtle");

		String player_selection = scanner.nextLine();
		if (player_selection.equals("1")) {
			player.add_pokemon(bulbasaur);
		}
		else if (player_selection.equals("2")) {
			player.add_pokemon(charmander);
		}
		else if (player_selection.equals("3")) {
			player.add_pokemon(squirtle);
		}
		else {
			scanner.close();
			throw new Error("Nope");
		}

		System.out.println(player.get_party());
		scanner.close();
	}
}