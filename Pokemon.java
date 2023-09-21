package PokemonJava;

public class Pokemon {
	private String name;
	private int id;
	private int level;
	private int max_hp;
	private int hp;
	private boolean fainted;
	private Move[] moves = new Move[4];

	public Pokemon(String name, int id, int level)
	{
		this.name = name;
		this.id = id;
		this.level = level;
		this.max_hp = level * 5;
		this.hp = max_hp;
		this.fainted = false;
	}

	public int use_move(int slot) {
		if (moves[slot - 1] == null) {
			return (0); // not a move
		}
		if (moves[slot - 1].use() == 0) {
			return (1); // no more pp available
		}
		return (moves[slot - 1].get_damage());
	}

	public int full_heal() {
		int diff = this.max_hp - this.hp;
		this.hp = this.max_hp;
		for (Move move : moves) {
			if (move != null) {
				move.reset_pp();
			}
		}
		this.fainted = false;
		return (diff);
	}

	public int heal(int amount) {
		int diff = amount;
		this.hp += amount;
		if (this.hp > this.max_hp) {
			diff = amount - (this.hp - this.max_hp);
			this.hp = this.max_hp;
		}
		return (diff);
	}

	public void hit(int amount) {
		this.hp -= amount;
	}

	public boolean check_fainted() {
		if (this.hp <= 0) {
			this.fainted = true;
		}
		return (this.fainted);
	}

	public int set_move(Move move, int slot)
	{
		if (this.moves[slot - 1] != null) {
			return (0); // slot already populated
		}
		this.moves[slot - 1] = move;
		return (1); // success
	}

	public int unset_move(int slot)
	{
		if (this.moves[slot - 1] == null) {
			return (0); // no move in slot
		}
		this.moves[slot - 1] = null;
		return (1); // success
	}

	public int swap_moves(int slot1, int slot2)
	{
		if (this.moves[slot1 - 1] == null && this.moves[slot2 - 1] == null) {
			return (0); // both slots are unpopulated
		}
		Move tmp = this.moves[slot1 - 1];
		this.moves[slot1 - 1] = this.moves[slot2 - 1];
		this.moves[slot2 - 1] = tmp;
		return (1); // success
	}

	public void level_up() {
		this.level++;
		this.max_hp += 5;
		this.hp += 5;
	}

	public String print_move_selection() {
		String move_selection_string = new String("----------------------------------------\n|             Select  Move             |\n----------------------------------------\n");
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != null) {
				String move_string = new String(String.format("| (%d) %s - %d ATT - %d/%d PP", i + 1, moves[i].get_name(), moves[i].get_damage(), moves[i].get_pp(), moves[i].get_max_pp()));
				move_selection_string = move_selection_string.concat(move_string);
				for (int j = move_string.length(); j < 39; j++) {
					move_selection_string = move_selection_string.concat(" ");
				}
			} else {
				move_selection_string = move_selection_string.concat(String.format("| (%d) ---                              ", i + 1));
			}
			move_selection_string = move_selection_string.concat("|\n");
		}
		return (move_selection_string.concat("----------------------------------------\n"));
	}

	public boolean has_fainted()
	{
		return (this.fainted);
	}

	public String get_name()
	{
		return (this.name);
	}

	public int get_level()
	{
		return (this.level);
	}

	public int get_hp()
	{
		return (this.hp);
	}

	public int get_max_hp()
	{
		return (this.max_hp);
	}

	public Move get_move(int slot)
	{
		return (moves[slot - 1]);
	}

	public Move[] get_moves()
	{
		return (moves);
	}

	public Pokemon clone() {
		Pokemon clone = new Pokemon(this.name, this.id, this.level);
		
		clone.hit(this.max_hp - this.hp);
		clone.check_fainted();
		for (int i = 0; i < moves.length; i++) {
			clone.set_move(moves[i].clone(), i + 1);
		}
		return (clone);
	}

	
}
