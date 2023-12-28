package PokemonJava.Menu.Commands;

import java.util.Scanner;

import PokemonJava.Status;
import PokemonJava.Menu.Menu;

public class ExitCommand extends MenuCommand {
	
	public ExitCommand() {
		this.command_name = "Exit";
	}
	
	@Override
	public void execute(Status status) {
		if (status.get_menu().get_previous_menu() != null) {
			Menu back = status.get_menu();
			status.set_menu(back.get_previous_menu());
			back = null;
		} else {
			confirmExit(status);
		}
	}

	private void confirmExit(Status status) {
		Scanner scanner = status.get_scanner();

		System.out.println("Are you sure you want to exit? (y/N)");
		String user_input = scanner.nextLine().toUpperCase();
		if (user_input.equals("Y")) {
			scanner.close();
			System.exit(0);
		} else {
			System.out.println("Exit aborted");
		}
	}
}
