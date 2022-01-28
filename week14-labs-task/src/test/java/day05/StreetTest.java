package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreetTest {

    @Test
    void getSoldHousesTest() {
        Street street = new Street();
        street.createMapOfSoldHouses(Path.of("src/test/resources/streets.txt"));
        System.out.println(street.getSoldHouses());
    }

    @Test
    void countEvenNumbersInStreetTest() {
        Street street = new Street();
        street.createMapOfSoldHouses(Path.of("src/test/resources/streets.txt"));
        assertEquals(2, street.countEvenNumbersInStreet("Kossuth"));
        assertEquals(3, street.countEvenNumbersInStreet("Petofi"));
    }
}