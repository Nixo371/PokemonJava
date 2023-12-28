package PokemonJava;

import java.util.Scanner;

import PokemonJava.Menu.Menu;
import PokemonJava.Pokemon.Pokemon;
import PokemonJava.Trainer.Player;
import PokemonJava.Trainer.Trainer;

public class Status {

	private Scanner scanner;
	private Pokemon player_pokemon;
	private Pokemon enemy_pokemon;
	private Player player;
	private Trainer enemy;
	private boolean in_battle;
	private Menu menu;
	private	int	move;

	public Status(Player player) {
		this.player_pokemon = null;
		this.enemy_pokemon = null;
		this.player = player;
		this.enemy = null;
		this.in_battle = false;
		this.menu = null;
		this.move = 0;
	}

	public Pokemon get_player_pokemon() {
		return (this.player_pokemon);
	}

	public void set_player_pokemon(Pokemon pokemon) {
		this.player_pokemon = pokemon;
	}

	public Pokemon get_enemy_pokemon() {
		return (this.enemy_pokemon);
	}

	public void set_enemy_pokemon(Pokemon pokemon) {
		this.enemy_pokemon = pokemon;
	}

	public Player get_player() {
		return (this.player);
	}

	public Trainer get_enemy() {
		return (this.enemy);
	}

	public void set_enemy(Trainer enemy) {
		this.enemy = enemy;
	}

	public Boolean is_in_battle() {
		return (this.in_battle);
	}

	public void set_in_battle(Boolean in_battle) {
		this.in_battle = in_battle;
	}

	public Menu get_menu() {
		return (this.menu);
	}

	public void set_menu(Menu menu) {
		this.menu = menu;
	}

	public Scanner get_scanner() {
		return (this.scanner);
	}

	public void set_scanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public int get_move_slot() {
		return (this.move);
	}

	public void set_move_slot(int move) {
		this.move = move;
	}
}
