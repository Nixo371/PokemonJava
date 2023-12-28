package PokemonJava.Menu;

import PokemonJava.Status;
import PokemonJava.Battle.Battle;
import PokemonJava.Pokemon.Move;
import PokemonJava.Pokemon.Pokemon;

public class BattleMenu extends Menu {

	public BattleMenu(Status status, MenuType menu_type, Menu previous_menu) {
		super(status, menu_type, previous_menu);
	}

	@Override
	public void show() {
		Battle battle = new Battle(status.get_player(), status.get_enemy());
		System.out.print(battle.get_battle_display(status.get_player_pokemon(), status.get_enemy_pokemon()));
		Pokemon pokemon = this.status.get_player().get_lead();
		Move[] moves = pokemon.get_moves();

		System.out.print("----------------------------------------\n|             Select  Move             |\n----------------------------------------\n");
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != null) {
				System.out.print(moves[i].get_attack_menu_string(i));
				for (int j = moves[i].get_attack_menu_string(i).length(); j < 39; j++) {
					System.out.print(" ");
				}
			} else {
				System.out.print("| (");
				System.out.print(i + 1);
				System.out.print(") ---                              ");
			}
			System.out.print("|\n");
		}
		System.out.print("----------------------------------------\n");
		System.out.print("PokemonJava> ");
	}
}
