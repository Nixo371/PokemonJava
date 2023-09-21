package PokemonJava;

public class Player extends Trainer {
	public Player(String name)
	{
		this.name = name;
	}

	public int add_pokemon(Pokemon pokemon) {
		int result = this.party.add_pokemon(pokemon);
		if (result == 0) {
			System.out.println("You don't have room in your party!");
			return (0);
		}
		System.out.println(String.format("%s was inserted into slot %d!", pokemon.get_name(), result));
		return (1);
	}
}
