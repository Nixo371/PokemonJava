package PokemonJava.Pokemon;

import PokemonJava.Stats.BaseStats;
import PokemonJava.Stats.IndividualValues;

public class PokeStats {

    private BaseStats base_stats;
    private IndividualValues ivs;

    public PokeStats(BaseStats base, IndividualValues ivs) {
        this.base_stats = base;
        this.ivs = ivs;
    }

    public BaseStats get_base_stats() {
        return (this.base_stats);
    }

    public IndividualValues get_ivs() {
        return (this.ivs);
    }
}
