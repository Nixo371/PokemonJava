package PokemonJava.Pokemon;

import PokemonJava.Stats.BaseStats;
import PokemonJava.Stats.IndividualValues;
import PokemonJava.Stats.PokeStats;
import PokemonJava.Stats.StatsFinder;

public class Pokemon {
	private PokeStats stats;

	private String name;
	private int id;
	private int level;
	private int max_hp;
	private int hp;
	private int experience;
	private boolean fainted;
	private Move[] moves = new Move[4];
	private Type type1;
	private Type type2;

	public Pokemon(int id, int level) {
		this.id = id;
		this.level = level;
		this.fainted = false;

		StatsFinder stats_finder = new StatsFinder();
		BaseStats base_stats = stats_finder.get_base_stats(id);
		IndividualValues ivs = new IndividualValues();
		this.name = stats_finder.get_name(id);

		this.stats = new PokeStats(base_stats, ivs);
		this.stats.update_stats(level);
		this.type1 = stats_finder.get_type1(id);
		this.type2 = stats_finder.get_type2(id);

		this.max_hp = this.stats.get_hp();
		this.hp = this.max_hp;
	}

	public int use_move(int slot) {
		if (moves[slot - 1] == null) {
			return (0); // not a move
		}
		if (moves[slot - 1].use() == 0) {
			return (1); // no more pp available
		}
		return (moves[slot - 1].get_power());
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

	public int set_move(Move move, int slot) {
		if (this.moves[slot - 1] != null) {
			return (0); // slot already populated
		}
		this.moves[slot - 1] = move;
		return (1); // success
	}

	public int unset_move(int slot) {
		if (this.moves[slot - 1] == null) {
			return (0); // no move in slot
		}
		this.moves[slot - 1] = null;
		return (1); // success
	}

	public int swap_moves(int slot1, int slot2) {
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
		this.stats.update_stats(level);
		this.max_hp = this.stats.get_hp();
	}

	public boolean has_fainted() {
		return (this.fainted);
	}

	public String get_name() {
		return (this.name);
	}

	public int get_level() {
		return (this.level);
	}

	public int get_hp() {
		return (this.hp);
	}

	public int get_max_hp() {
		return (this.max_hp);
	}

	public int get_experience() {
		return (this.experience);
	}

	public PokeStats get_stats() {
		return (this.stats);
	}

	public Move get_move(int slot) {
		return (moves[slot - 1]);
	}

	public Move[] get_moves() {
		return (moves);
	}

	public Type get_type1() {
		return (this.type1);
	}

	public Type get_type2() {
		return (this.type2);
	}

	public Pokemon clone() {
		Pokemon clone = new Pokemon(this.id, this.level);
		
		clone.hit(this.max_hp - this.hp);
		clone.check_fainted();
		for (int i = 0; i < moves.length; i++) {
			clone.set_move(moves[i].clone(), i + 1);
		}
		return (clone);
	}

	
}
