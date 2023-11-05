package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("unused")
public class AnimalUtils {
    private static final int MAX_SAFETY_HEIGHT = 100;

    public static List<Animal> getSortedList(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> getWeightStatistics(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> getTypeStatistics(List<Animal> animals) {
        var result = new HashMap<Animal.Type, Integer>();
        animals.forEach(animal -> result.merge(animal.type(), 1, Integer::sum));
        return result;
    }

    public static Animal getAnimalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max((Comparator.comparingInt(o -> o.name().length())))
            .get();
    }

    public static Animal.Sex getSexStatistics(List<Animal> animals) {
        return animals.stream()
            .filter(o -> o.sex().equals(Animal.Sex.M)).count() * 2 >= animals.size()
            ? Animal.Sex.M
            : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> getMostHeavyAnimalOfEachType(List<Animal> animals) {
        var result = new HashMap<Animal.Type, Animal>();
        animals.forEach(animal -> {
            if (result.containsKey(animal.type())) {
                if (result.get(animal.type()).weight() < animal.weight()) {
                    result.put(animal.type(), animal);
                }
            } else {
                result.put(animal.type(), animal);
            }
        });
        return result;
    }

    public static Animal getKthOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed()).skip(k - 1)
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    public static Optional<Animal> getMostHeavyAnimalAmongLowOnes(List<Animal> animals, int k) {
        return animals.stream()
            .filter(o -> o.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer getPawsCount(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> getAnimalsWithPawsNotEqualAge(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    public static List<Animal> getDangerousAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > MAX_SAFETY_HEIGHT)
            .toList();
    }

    public static Integer getCountAnimalsWeightMoreThanHeight(List<Animal> animals) {
        return Math.toIntExact(animals.stream().filter(animal -> animal.weight() > animal.height()).count());
    }

    public static List<Animal> getAnimalsWithMoreThanTwoWordsName(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split("\\s+").length > 2)
            .toList();
    }

    public static Boolean isThereDogWithBiggerHeight(List<Animal> animals, int k) {
        return animals.stream().anyMatch(animal -> animal.type().equals(Animal.Type.DOG) && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> getSummaryWeightOfEachTypeAnimalsWhoHasAgeBetween(
        List<Animal> animals,
        int lowBound,
        int highBound
    ) {
        var result = new HashMap<Animal.Type, Integer>();

        animals.stream()
            .filter(animal -> lowBound <= animal.age() && animal.age() <= highBound)
            .forEach(animal -> result.merge(animal.type(), animal.weight(), Integer::sum));

        return result;
    }

    public static List<Animal> getMegaSortedListOfAnimals(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .toList();
    }

    public static Boolean areSpidersBitingMoreThanDogs(List<Animal> animals) {
        long countBitingSpiders = animals.stream()
            .filter(animal -> animal.bites() && animal.type().equals(Animal.Type.SPIDER)).count();
        long countBitingDogs = animals.stream()
            .filter(animal -> animal.bites() && animal.type().equals(Animal.Type.DOG)).count();
        return countBitingSpiders > countBitingDogs;
    }

    @SafeVarargs
    public static Animal getMostHeavyFish(List<Animal>... animalsLists) {
        return Arrays.stream(animalsLists)
            .flatMap(animalsList -> animalsList.stream()
                .filter(animal -> animal.type().equals(Animal.Type.FISH)))
            .max(Comparator.comparingInt(Animal::weight))
            .orElseThrow(RuntimeException::new);
    }
}
