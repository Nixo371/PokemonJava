package PokemonJava.Pokemon;

public class Stats {
	
	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private int special;
	private int[] stats;

	public Stats(int hp, int attack, int defense, int speed, int special) {
		stats = new int[5];
		set_hp(hp);
		set_attack(attack);
		set_defense(defense);
		set_speed(speed);
		set_special(special);
	}

	public void set_hp(int hp) {
		this.hp = hp;
		stats[0] = hp;
	}

	public void set_attack(int attack) {
		this.attack = attack;
		stats[1] = attack;
	}

	public void set_defense(int defense) {
		this.defense = defense;
		stats[2] = defense;
	}

	public void set_speed(int speed) {
		this.speed = speed;
		stats[3] = speed;
	}

	public void set_special(int special) {
		this.special = special;
		stats[4] = special;
	}

	public int get_hp() {
		return (this.hp);
	}

	public int get_attack() {
		return (this.attack);
	}

	public int get_defense() {
		return (this.defense);
	}

	public int get_speed() {
		return (this.speed);
	}

	public int get_special() {
		return (this.special);
	}

	public int[] get_stats() {
		return (this.stats);
	}
}
