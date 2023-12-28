package PokemonJava.Menu.Commands;

import PokemonJava.Status;
import PokemonJava.Menu.Menu;
import PokemonJava.Menu.MenuType;
import PokemonJava.Trainer.Party;

public class PartyCommand extends MenuCommand {

    public PartyCommand() {
        this.command_name = "Party";
    }
    
    @Override
    public void execute(Status status) {
		Menu party_menu = new Menu(status, MenuType.PARTY_MENU, status.get_menu());

		this.print_party(status);

		status.set_menu(party_menu);
    }

	private void print_party(Status status) {
		Party party = status.get_player().get_party();
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------\n|              Your Party              |\n----------------------------------------\n");
		for (int i = 1; i < 7; i++) {
			if (party.get_pokemon(i) != null) {
				StringBuilder pokemon = new StringBuilder();
				pokemon.append("| " + i + ". ");
				pokemon.append(party.get_pokemon(i).get_name());
				pokemon.append(" - Lv. " + party.get_pokemon(i).get_level());
				pokemon.append(" - ");
				pokemon.append(party.get_pokemon(i).get_hp() + "/" + party.get_pokemon(i).get_max_hp());
				pokemon.append(" HP");
				sb.append(pokemon.toString());
				for (int j = pokemon.toString().length(); j < 39; j++) {
					sb.append(" ");
				}
				sb.append("|\n");
				pokemon = null;
			}
		}
		sb.append("----------------------------------------\n");
		System.out.print(sb.toString());
	} 
    
}
