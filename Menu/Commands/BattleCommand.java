package PokemonJava.Menu.Commands;

import java.util.Random;

import PokemonJava.Status;
import PokemonJava.Menu.BattleMenu;
import PokemonJava.Menu.MenuType;
import PokemonJava.Pokemon.Move;
import PokemonJava.Pokemon.Pokemon;
import PokemonJava.Trainer.Trainer;

public class BattleCommand extends MenuCommand {

    public BattleCommand() {
        this.command_name = "Battle";
    }
    
    @Override
    public void execute(Status status) {
		Random rng = new Random();
		Trainer enemy = new Trainer();
		Pokemon enemy_pokemon = new Pokemon(rng.nextInt(150) + 1, status.get_player().get_party().get_pokemon(1).get_level());
		enemy_pokemon.set_move(new Move("Tackle", 33, 40, 35), 1);

		enemy.add_pokemon(enemy_pokemon);
		status.set_enemy(enemy);
		status.set_enemy_pokemon(enemy_pokemon);
		status.set_player_pokemon(status.get_player().get_lead());
		status.set_in_battle(true);

		BattleMenu battle_menu = new BattleMenu(status, MenuType.BATTLE_MENU, status.get_menu());
		status.set_menu(battle_menu);
    }
    
}
