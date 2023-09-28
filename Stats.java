package PokemonJava;

public class Stats {
	
	private int health;
	private int attack;
	private int defense;

	private BaseStats base_stats;
	private IndividualValues ivs;

	public Stats() {
		
	}

	public Stats(BaseStats base, IndividualValues ivs) {
		this.health = base.get_health() + ivs.get_health();
		this.attack = base.get_attack() + ivs.get_attack();
		this.defense = base.get_defense() + ivs.get_defense();

		this.base_stats = base;
		this.ivs = ivs;
	}

	public void update_stats() {
		this.health = this.base_stats.get_health() + this.ivs.get_health();
		this.attack = this.base_stats.get_attack() + this.ivs.get_attack();
		this.defense = this.base_stats.get_defense() + this.ivs.get_defense();
	}

	public void set_health(int health) {
		this.health = health;
	}

	public void set_attack(int attack) {
		this.attack = attack;
	}

	public void set_defense(int defense) {
		this.defense = defense;
	}

	public int get_health() {
		return (this.health);
	}

	public int get_attack() {
		return (this.attack);
	}

	public int get_defense() {
		return (this.defense);
	}

	public BaseStats get_base_stats() {
		return (this.base_stats);
	}

	public IndividualValues get_ivs() {
		return (this.ivs);
	}
}
