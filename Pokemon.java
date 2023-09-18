package PokemonJava;

public class Pokemon {
	String name;
	int id;
	int level;
	int max_hp;
	int hp;
	boolean fainted;
	Move[] moves = new Move[4];

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

	public String modify_hp(int amount) {
		this.hp += amount;
		if (this.hp <= 0) {
			this.fainted = true;
			return (String.format("%s has fainted!", this.name));
		}
		if (this.hp > this.max_hp) {
			this.hp = this.max_hp;
		}
		if (amount > 0) {
			return (String.format("%s has healed %d HP! (%d/%d)", this.name, amount, this.hp, this.max_hp));
		}
		if (amount < 0) {
			return (String.format("%s has been hit for %d HP! (%d/%d)", this.name, -amount, this.hp, this.max_hp));
		}
		this.hp = this.max_hp;
		return (String.format("%s was fully healed! (%d/%d)", this.name, this.hp, this.max_hp));
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
}
