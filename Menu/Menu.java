package PokemonJava.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PokemonJava.Status;
import PokemonJava.Menu.Commands.AttackMoveCommand;
import PokemonJava.Menu.Commands.BattleCommand;
import PokemonJava.Menu.Commands.PartyCommand;
import PokemonJava.Menu.Commands.StatsCommand;
import PokemonJava.Menu.Commands.HealCommand;
import PokemonJava.Menu.Commands.ExitCommand;
import PokemonJava.Menu.Commands.MenuCommand;

public class Menu {
	protected Status status;
	protected String user_input;
	protected Menu previous_menu;
	protected MenuType menu_type;


	public Menu(Status status, MenuType menu_type) {
		this.status = status;
		this.previous_menu = null;
		this.menu_type = menu_type;
	}

	public Menu(Status status, MenuType menu_type, Menu previous_menu) {
		this.status = status;
		this.previous_menu = previous_menu;
		this.menu_type = menu_type;
	}

	public Menu get_previous_menu() {
		return (this.previous_menu);
	}

	protected List<MenuCommand> available_commands() {
		List<MenuCommand> availableCommands = new ArrayList<MenuCommand>();
		switch (this.menu_type) {
			case MAIN_MENU:
				availableCommands.add(new BattleCommand());
				availableCommands.add(new PartyCommand());
				availableCommands.add(new ExitCommand());
				break;
			case BATTLE_MENU:
				availableCommands.add(new AttackMoveCommand());
				availableCommands.add(new AttackMoveCommand());
				availableCommands.add(new AttackMoveCommand());
				availableCommands.add(new AttackMoveCommand());
				availableCommands.add(new ExitCommand());
				break;
			case PARTY_MENU:
				availableCommands.add(new HealCommand());
				availableCommands.add(new StatsCommand());
				availableCommands.add(new ExitCommand());
				break;
			default:
				availableCommands.add(new ExitCommand());
		}

		return (availableCommands);
	}

	public void show() {
		int i = 1;

		System.out.println("What would you like to do?");
		List<MenuCommand> availableCommands = this.available_commands();
		for (MenuCommand command : availableCommands) {
			System.out.println("(" + i + ") " + command.get_command_name());
			i++;
		}
		System.out.print("PokemonJava> ");
	}

	public void get_user_input() {
		Scanner scanner = this.status.get_scanner();

		this.user_input = scanner.nextLine();
		this.status.set_move_slot(Integer.parseInt(this.user_input));
	}

	public void execute_command() {
		List<MenuCommand> availableCommands = this.available_commands();
		MenuCommand command = availableCommands.get(Integer.parseInt(this.user_input) - 1);
		command.execute(this.status);
		this.status.set_move_slot(0);
	}

}
