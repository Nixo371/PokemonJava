package PokemonJava.Trainer;

import PokemonJava.Pokemon.Pokemon;

public class Party {
	Pokemon[] party;

	public Party() {
		party = new Pokemon[6];
	}

	public String print_party() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------\n|              Your Party              |\n----------------------------------------\n");
		for (int i = 0; i < this.party.length; i++) {
			if (this.party[i] != null) {
				String party_member = new String(String.format("| %d. %s - Lv. %d - %d/%d HP", i + 1, this.party[i].get_name(), this.party[i].get_level(), this.party[i].get_hp(), this.party[i].get_max_hp()));
				sb.append(party_member);
				for (int j = party_member.length(); j < 39; j++) {
					sb.append(" ");
				}
				sb.append("|\n");
				party_member = null;
			}
		}
		sb.append("----------------------------------------\n");
		return (sb.toString());
	}

	public String pokemon_stats(int slot) {
		if (this.party[slot - 1] == null) {
			System.out.println("Error: No pokemon in slot " + slot);
			return (null);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------\n|");
		String pokemon_name = new String(this.party[slot - 1].get_name() + " - Lv. " + this.party[slot - 1].get_level());
		int	spacing = (38 - pokemon_name.length()) / 2;
		for (int i = 0; i < spacing; i++) {
			sb.append(" ");
		}
		sb.append(pokemon_name);
		for (int i = 0; i < spacing; i++) {
			sb.append(" ");
		}
		if (pokemon_name.length() % 2 == 1) {
			sb.append(" ");
		}
		sb.append("|\n----------------------------------------\n");
		return (sb.toString());
	}

	public int add_pokemon(Pokemon pokemon) {
		for (int i = 0; i < this.party.length; i++) {
			if (this.party[i] == null) {
				this.party[i] = pokemon;
				return (i + 1); // success (what slot it was inserted in)
			}
		}
		return (0); // party full
	}

	public void heal() {
		for (Pokemon pokemon : party) {
			if (pokemon != null) {
				pokemon.full_heal();
			}
		}
	}

	public void full_heal() {
		for (Pokemon pokemon : party) {
			if (pokemon != null) {
				pokemon.full_heal();
				// TODO: remove status effects when implemented
			}
		}
	}

	public int swap_pokemon(int slot1, int slot2) {
		if (this.party[slot1 - 1] == null || this.party[slot2 - 1] == null) {
			return (0); // cannot switch with no pokemon
		}
		Pokemon tmp = this.party[slot1 - 1];
		this.party[slot1 - 1] = this.party[slot2 - 1];
		this.party[slot2 - 1] = tmp;
		return (1); // success!
	}

	public int length() {
		int i = 0;
		while (party[i] != null) {
			i++;
		}
		return (i);
	}

	public Pokemon get_pokemon(int slot) {
		return (party[slot - 1]);
	}

	public Pokemon[] get_all_pokemon() {
		return (party);
	}
}
