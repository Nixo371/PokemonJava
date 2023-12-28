package PokemonJava.Pokemon;

public enum Type {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON;

    public Type get_type_from_string(String str) {
        String type = str.toUpperCase();

        return (Type.valueOf(type));
    }
}
