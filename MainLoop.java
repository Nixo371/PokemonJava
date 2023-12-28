package PokemonJava;

import java.util.Scanner;

import PokemonJava.Menu.Menu;
import PokemonJava.Menu.MenuType;
import PokemonJava.Trainer.Player;

public class MainLoop {
	private Status status;
	private Player player;
	private Menu menu;

	public MainLoop(Player player) {
		this.player = player;
		this.status = new Status(this.player);
		this.menu = new Menu(this.status, MenuType.MAIN_MENU, null);
		this.status.set_menu(this.menu);
	}

	public void start_loop(Scanner scanner) {
		this.status.set_scanner(scanner);
		this.loop(this.status);
	}	

	private void loop(Status state) {
		while (true) {
			if (this.player.check_blackout()) {
				System.out.println("All your pokemon fainted! You blacked out!");
				this.blackout();
			}
			this.menu.show();
			this.menu.get_user_input();
			this.menu.execute_command();
			this.menu = this.status.get_menu();
		}
	}

	public void set_menu(Menu menu) {
		this.menu = menu;
	}

	private void blackout() {
		System.out.println("You have been sent back to the Pokemon Center!");
		this.player.get_party().full_heal();
		this.reset_menu();
		this.set_menu(new Menu(this.status, MenuType.MAIN_MENU));
	}

	private void reset_menu() {
		while (this.menu.get_previous_menu() != null) {
			this.menu = this.menu.get_previous_menu();
		}
		this.menu = null;
	}
}
