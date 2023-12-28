package PokemonJava.Menu.Commands;

import java.util.Scanner;

import PokemonJava.Status;
import PokemonJava.Menu.Menu;
import PokemonJava.Menu.MenuType;

public class StatsCommand extends MenuCommand {
    
    public StatsCommand() {
        this.command_name = "Stats";
    }
    
    @Override
    public void execute(Status status) {
        Scanner scanner = status.get_scanner();

		System.out.println("What pokemon would you like to inspect?");
		System.out.print("PokemonJava> ");

		String user_input = scanner.nextLine();
		int selection = Integer.parseInt(user_input);

		if (selection < 1 || selection > status.get_player().get_party().length()) {
			throw new Error("Not a valid selection!");
		}

		this.print_stats(status, selection);

		Menu stats_menu = new Menu(status, MenuType.STATS_MENU, status.get_menu());
		status.set_menu(stats_menu);
    }

	private void print_stats(Status status, int slot) {
		int[] stats = status.get_player().get_party().get_pokemon(slot).get_stats().get_stats();
		int[] ivs = status.get_player().get_party().get_pokemon(slot).get_stats().get_ivs().get_stats();
		int[] base = status.get_player().get_party().get_pokemon(slot).get_stats().get_base_stats().get_stats();
		String[] stat_strings = new String[] {"HP: ", "ATT: ", "DEF: ", "SPD: ", "SP: "};

		String name = status.get_player().get_party().get_pokemon(slot).get_name();
		
		System.out.print("----------------------------------------\n|");
		for (int i = 0; i < (38 - name.length()) / 2; i++) {
			System.out.print(" ");
		}
		System.out.print(name);
		for (int i = 0; i < (38 - name.length()) / 2; i++) {
			System.out.print(" ");
		}
		if ((38 - name.length() % 2 == 1))
			System.out.print(" ");
		System.out.print("|\n----------------------------------------\n");

		for (int i = 0; i < 5; i++) {
			StringBuilder sb = new StringBuilder();

			sb.append("| ");
			sb.append(stat_strings[i]);
			sb.append(stats[i]);
			for (int j = sb.toString().length(); j < 12; j++) {
				sb.append(" ");
			}
			sb.append("( Base: ");
			// Show Base stats
			sb.append(base[i]);
			for (int j = sb.toString().length(); j < 25; j++) {
				sb.append(" ");
			}
			sb.append("IV: ");
			// Show IV stats
			if (ivs[i] < 10)
				sb.append(" ");
			sb.append(ivs[i]);
			sb.append(" )");
			for (int j = sb.toString().length(); j < 38; j++) {
				sb.append(" ");
			}
			sb.append("|\n");
			System.out.print(sb.toString());
		}
		System.out.print("----------------------------------------\n");
	}
}
