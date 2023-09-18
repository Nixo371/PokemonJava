package PokemonJava;

public class Player {
	Pokemon[] party = new Pokemon[6];

	public Player()
	{

	}

	public int add_pokemon(Pokemon pokemon)
	{
		for (int i = 0; i < this.party.length; i++) {
			if (this.party[i] == null) {
				this.party[i] = pokemon;
				return (i + 1); // success (what slot it was inserted in)
			}
		}
		return (0); // party full
	}

	public int swap_pokemon(int slot1, int slot2)
	{
		if (this.party[slot1 - 1] == null || this.party[slot2 - 1] == null) {
			return (0); // cannot switch with no pokemon
		}
		Pokemon tmp = this.party[slot1 - 1];
		this.party[slot1 - 1] = this.party[slot2 - 1];
		this.party[slot2 - 1] = tmp;
		return (1); // success!
	}

	public String get_party()
	{
		String return_string = new String("----------------------------------------\n|              Your Party              |\n----------------------------------------\n");
		for (int i = 0; i < this.party.length; i++) {
			if (this.party[i] != null) {
				String party_member = new String(String.format("| %d. %s - Lv. %d", i + 1, this.party[i].get_name(), this.party[i].get_level()));
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
}
