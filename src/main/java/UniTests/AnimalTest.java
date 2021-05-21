package UniTests;

import Animals.Animal;
import Behaviors.Behaviors;
import Places.Place;
import Zoo.Zoo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    private Place place;

    @BeforeEach
    public void setZoo() {
        place = new Place(1, "NAME", 10, Arrays.stream(Behaviors.values()).toList());

    } @Test
    public void getAnimalByName() {
        Animal expectedAnimal = new Animal(1, 1, 10, "Name");
        Animal unExpectedAnimal = new Animal(2, 1, 10, "2");

        place.animals.addAll(List.of(expectedAnimal, unExpectedAnimal));

        Animal actualAnimal = getTestAnimalByName("NAME");

        assertEquals(expectedAnimal, actualAnimal);
        assertNotEquals(expectedAnimal, unExpectedAnimal);

    }
    @ParameterizedTest
    @MethodSource("testAnimalProvider")
    public void addNewAnimal(Animal animal) {

        place.animals.add(animal);

        assertTrue(place.animals.contains(animal));
    }

    public static Stream<Animal> testAnimalProvider() {
        return Stream.of(
                new Animal(1, 1, 10, "1"),
                new Animal(2, 1, 10, "2"),
                new Animal(3, 2, 10, "3"),
                new Animal(4, 2, 10, "4"),
                new Animal(5, 2, 10, "5")
        );
    }
    public Animal getTestAnimalByName(String name) {
        var opt = place.animals.stream().filter(place1 -> name.equals(place1.getName())).findFirst();
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new NoSuchElementException();
    }
}
