package PokemonJava.Menu.Commands;

import PokemonJava.Status;

public class HealCommand extends MenuCommand {
    
    public HealCommand() {
        this.command_name = "Heal";
    }
    
    @Override
    public void execute(Status status) {
        status.get_player().get_party().heal();
    }
}
