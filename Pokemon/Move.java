package PokemonJava.Pokemon;

public class Move {
    private String name;
	private int id;
	private int power;
	private int max_pp;
	private int pp;
	private int attack_type; // 0 = physical, 1 = special, 2 = status
	private Type type;

	public Move(String name, int id, int power, int max_pp)
	{
		this.name = name;
		this.id = id;
		this.power = power;
		this.max_pp = max_pp;
		this.pp = max_pp;
		this.attack_type = 0;
		this.type = Type.NORMAL;
	}

	public int use() {
		if (this.pp <= 0) {
			return (0); // cannot use this move, out of PP
		}
		this.pp--;
		return (1); // success
	}

	public void reset_pp() {
		this.pp = this.max_pp;
	}

	public String get_name() {
		return (this.name);
	}

	public int get_id() {
		return (this.id);
	}

	public int get_power() {
		return (this.power);
	}

	public int get_max_pp() {
		return (this.max_pp);
	}

	public int get_pp() {
		return (this.pp);
	}

	public int get_attack_type() {
		return (this.attack_type);
	}

	public Type get_type() {
		return (this.type);
	}

	public String get_attack_menu_string(int i) {
		StringBuilder sb = new StringBuilder();

		sb.append("| (");
		sb.append(i + 1);
		sb.append(") ");
		sb.append(this.name);
		sb.append(" - ");
		sb.append(this.power);
		sb.append(" ATT - ");
		sb.append(this.pp);
		sb.append("/");
		sb.append(this.max_pp);

		return (sb.toString());
	}

	public Move clone() {
		Move clone = new Move(this.name, this.id, this.power, this.max_pp);
		for (int i = 0; i < this.max_pp - this.pp; i++) {
			clone.use();
		}
		return (clone);
	}
}
