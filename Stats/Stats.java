package PokemonJava.Stats;

public abstract class Stats {

	private int hp;
	private int attack;
	private int defense;
	private int sp_attack;
	private int sp_defense;
	private int speed;
	private int[] stats;

	public Stats(int hp, int attack, int defense, int sp_attack, int sp_defense, int speed) {
		set_hp(hp);
		set_attack(attack);
		set_defense(defense);
		set_sp_attack(sp_attack);
		set_sp_defense(sp_defense);
		set_speed(speed);
		this.stats = new int[] {hp, attack, defense, sp_attack, sp_defense, speed};
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

	public void set_sp_attack(int sp_attack) {
		this.sp_attack = sp_attack;
		stats[3] = sp_attack;
	}

	public void set_sp_defense(int sp_defense) {
		this.sp_defense = sp_defense;
		stats[4] = sp_defense;
	}

	public void set_speed(int speed) {
		this.speed = speed;
		stats[5] = speed;
	}

	public int get_health() {
		return (this.hp);
	}

	public int get_attack() {
		return (this.attack);
	}

	public int get_defense() {
		return (this.defense);
	}

	public int get_sp_attack() {
		return (this.sp_attack);
	}

	public int get_sp_defense() {
		return (this.sp_defense);
	}

	public int get_speed() {
		return (this.speed);
	}

	public int[] get_stats() {
		return (this.stats);
	}
}
