package PokemonJava;

public class Party {
	Pokemon[] party;

	public Party() {
		party = new Pokemon[6];
	}

	public String print_party() {
		String return_string = new String("----------------------------------------\n|              Your Party              |\n----------------------------------------\n");
		for (int i = 0; i < this.party.length; i++) {
			if (this.party[i] != null) {
				String party_member = new String(String.format("| %d. %s - Lv. %d - %d/%d HP", i + 1, this.party[i].get_name(), this.party[i].get_level(), this.party[i].get_hp(), this.party[i].get_max_hp()));
				return_string = return_string + party_member;
				for (int j = party_member.length(); j < 39; j++) {
					return_string += " ";
				}
				return_string += "|\n";
				party_member = null;
			}
		}
		return (return_string + "----------------------------------------\n");
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

	public int swap_pokemon(int slot1, int slot2) {
		if (this.party[slot1 - 1] == null || this.party[slot2 - 1] == null) {
			return (0); // cannot switch with no pokemon
		}
		Pokemon tmp = this.party[slot1 - 1];
		this.party[slot1 - 1] = this.party[slot2 - 1];
		this.party[slot2 - 1] = tmp;
		return (1); // success!
	}

	public Pokemon get_pokemon(int slot) {
		return (party[slot - 1]);
	}

	public Pokemon[] get_all_pokemon() {
		return (party);
	}
}
