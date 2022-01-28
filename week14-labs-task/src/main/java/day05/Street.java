package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Street {

    private Map<String, List<Integer>> soldHouses = new HashMap<>();

    public void createMapOfSoldHouses(Path path) {
        Map<String, List<Integer>> streets = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                putValuesToMap(streets, line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!");
        }
        soldHouses = streets;
    }

    private void putValuesToMap(Map<String, List<Integer>> streets, String line) {
        String[] row = line.split(" ");
        int number = Integer.parseInt(row[1]);
        if (!streets.containsKey(row[0])) {
            streets.put(row[0], new ArrayList<>(List.of(2 - number)));
        } else {
            streets.get(row[0]).add(streets.get(row[0]).stream()
                    .filter(i -> i % 2 == number)
                    .mapToInt(i -> i)
                    .max().orElse(-number) + 2);
        }
    }

    public long countEvenNumbersInStreet(String street) {
        return soldHouses.get(street).stream()
                .filter(i -> i % 2 == 0)
                .count();
    }

    public Map<String, List<Integer>> getSoldHouses() {
        return soldHouses;
    }
}
