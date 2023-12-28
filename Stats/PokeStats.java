package PokemonJava.Stats;

public class PokeStats extends Stats {

    private BaseStats base_stats;
    private IndividualValues ivs;

    public PokeStats(BaseStats base, IndividualValues ivs) {
        super(0, 0, 0, 0, 0);
        this.base_stats = base;
        this.ivs = ivs;
    }
    
    public BaseStats get_base_stats() {
        return (this.base_stats);
    }

    public IndividualValues get_ivs() {
        return (this.ivs);
    }

    public void update_stats(int level) {
        calculate_stats(this.base_stats, this.ivs, level);
    }

    private void calculate_stats(BaseStats base, IndividualValues ivs, int level) {
        set_hp(calculate_health(base.get_hp(), ivs.get_hp(), level));
        set_attack(calculate_stat(base.get_attack(), ivs.get_attack(), level));
        set_defense(calculate_stat(base.get_defense(), ivs.get_defense(), level));
        set_speed(calculate_stat(base.get_speed(), ivs.get_speed(), level));
        set_special(calculate_stat(base.get_special(), ivs.get_special(), level));
    }

    private int calculate_health(int base, int iv, int level) {
        float health1 = (base + iv) * 2;
        int health_final = (int) Math.floor((health1 * level) / 100) + level + 10;

        return (health_final);
    }

    private int calculate_stat(int base, int iv, int level) {
        float stat1 = (base + iv) * 2;
        int stat_final = (int) Math.floor((stat1 * level) / 100) + 5;

        return (stat_final);
    }
}
