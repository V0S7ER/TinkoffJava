package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    private static final int CAT_PAW_COUNT = 4;
    private static final int DOG_PAW_COUNT = 4;
    private static final int BIRD_PAW_COUNT = 2;
    private static final int FISH_PAW_COUNT = 0;
    private static final int SPIDER_PAW_COUNT = 8;

    public int paws() {

        return switch (type) {
            case CAT -> CAT_PAW_COUNT;
            case DOG -> DOG_PAW_COUNT;
            case BIRD -> BIRD_PAW_COUNT;
            case FISH -> FISH_PAW_COUNT;
            case SPIDER -> SPIDER_PAW_COUNT;
        };
    }
}
