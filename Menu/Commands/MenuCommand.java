package PokemonJava.Menu.Commands;

import PokemonJava.Status;

public abstract class MenuCommand {
    protected String command_name;

    public abstract void execute(Status status);

	public String get_command_name() {
		return (this.command_name);
	}
}
