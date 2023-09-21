package PokemonJava;

public class Trainer {
	String name;
	Party party;

	public Trainer() {
		this.name = "Random Pokemon Trainer";
		party = new Party();
	}

	public int add_pokemon(Pokemon pokemon) {
		return (this.party.add_pokemon(pokemon));
	}

	public int swap_pokemon(int slot1, int slot2) {
		return (this.party.swap_pokemon(slot1, slot2));
	}

	public String print_party() {
		return (this.party.print_party());
	}

	public boolean check_blackout() {
		boolean blackout = false;
		for (Pokemon pokemon : this.party.get_all_pokemon()) {
			if (pokemon != null) {
				blackout = blackout || pokemon.check_fainted();
			}
		}
		return (blackout);
	}

	public Party get_party() {
		return (this.party);
	}

	public Pokemon get_lead() {
		return (this.party.get_pokemon(1));
	}
}
