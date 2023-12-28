package PokemonJava.Menu.Commands;

import PokemonJava.DamageCalculator;
import PokemonJava.Status;
import PokemonJava.Battle.Battle;
import PokemonJava.Pokemon.Pokemon;

public class AttackMoveCommand extends MenuCommand {

	@Override
	public void execute(Status status) {
		DamageCalculator dmg_calc = new DamageCalculator();
		Battle battle = new Battle(status.get_player(), status.get_enemy());
		Pokemon player_pokemon = status.get_player_pokemon();
		Pokemon enemy_pokemon = status.get_enemy_pokemon();

		int damage = dmg_calc.calculate_damage(player_pokemon, enemy_pokemon, player_pokemon.get_move(status.get_move_slot()));;
		while (damage == -1) {
			System.out.println("This is not a valid move!");
			status.get_menu().show();
			status.get_menu().get_user_input();
			damage = dmg_calc.calculate_damage(player_pokemon, enemy_pokemon, player_pokemon.get_move(status.get_move_slot()));
		}
		enemy_pokemon.hit(damage);
		this.print_attack(player_pokemon, enemy_pokemon, status.get_move_slot(), damage);
		if (battle.is_battle_over(status.get_player(), status.get_enemy())) {
			status.set_in_battle(false);
			status.set_menu(status.get_menu().get_previous_menu());
			this.end_battle(status, battle);
			return;
		}
		this.enemy_turn(status);
	}

	private void print_attack(Pokemon attacker, Pokemon defender, int move_slot, int damage_dealt) {
		System.out.println(String.format("%s used %s!", attacker.get_name(), attacker.get_move(move_slot).get_name()));
		System.out.println(String.format("%s was hit for %d damage!", defender.get_name(), damage_dealt));
		
	}

	private void enemy_turn(Status status) {
		DamageCalculator dmg_calc = new DamageCalculator();
		Pokemon player_pokemon = status.get_player_pokemon();
		Pokemon enemy_pokemon = status.get_enemy_pokemon();

		int damage = dmg_calc.calculate_damage(enemy_pokemon, player_pokemon, enemy_pokemon.get_move(1));
		player_pokemon.hit(damage);
		this.print_attack(enemy_pokemon, player_pokemon, 1, damage);
	}

	private void end_battle(Status status, Battle battle) {
		if (battle.end_battle(status.get_player(), status.get_enemy()) == status.get_player()) {
			System.out.println("You won the battle!");
			System.out.println("Your " + status.get_player_pokemon().get_name() + " levelled up!");
			status.get_player_pokemon().level_up();
		}
		else {
			System.out.println("You lost the battle!");
		}
	}
}
