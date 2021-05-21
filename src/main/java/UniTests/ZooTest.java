package UniTests;

import Animals.Animal;
import Behaviors.Behaviors;
import Places.Place;
import Zoo.Zoo;
import org.junit.Before;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class ZooTest {
    private Zoo testZoo;
    @Before
    public void initialize() {
        testZoo = new Zoo();
    }
    @BeforeEach
    public void setZoo() {
        testZoo = new Zoo();
    }

    @ParameterizedTest
    @MethodSource("testPlaceProvider")
    public void addNewPlace(Place place) {
        testZoo.addPlace(place);

        assertTrue(testZoo.getPlaces().contains(place));
    }

    public static Stream<Place> testPlaceProvider() {
        return Stream.of(
                new Place(1, "The best ever cage for little girls", 2, List.of(Behaviors.values())),
                new Place(2, "The blue lagoon", 3, List.of(Behaviors.values())),
                new Place(3, "Gay room", 5, List.of(Behaviors.values())),
                new Place(4, "Simple cage", 6, List.of(Behaviors.values()))
        );
    }



    @Test
    public void getPlaceByName() {
        Place expectedPlace = new Place(1, "NAME", 10, Arrays.stream(Behaviors.values()).toList());
        Place unExpectedPlace = new Place(2, "NAME2", 20, Arrays.stream(Behaviors.values()).toList());

        testZoo.getPlaces().addAll(List.of(expectedPlace, unExpectedPlace));

        Place actualPlace = getTestPlaceByName("NAME");

        assertEquals(expectedPlace, actualPlace);
        assertNotEquals(expectedPlace, unExpectedPlace);

    }

    public Place getTestPlaceByName(String name) {
        var opt = testZoo.getPlaces().stream().filter(place1 -> name.equals(place1.name)).findFirst();
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new NoSuchElementException();
    }

}