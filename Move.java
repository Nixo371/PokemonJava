package PokemonJava;

public class Move {
	private String name;
	private int id;
	private int damage;
	private int max_pp;
	private int pp;

	public Move(String name, int id, int damage, int max_pp)
	{
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.max_pp = max_pp;
		this.pp = max_pp;
	}

	public int use() {
		if (this.pp <= 0) {
			return (0); // cannot use this move, out of PP
		}
		this.pp--;
		return (1); // success
	}

	public String get_name() {
		return (this.name);
	}

	public int get_id() {
		return (this.id);
	}

	public int get_damage() {
		return (this.damage);
	}

	public int get_max_pp() {
		return (this.max_pp);
	}

	public int get_pp() {
		return (this.pp);
	}
}
