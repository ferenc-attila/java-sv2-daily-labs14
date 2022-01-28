package day05.city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {

    List<Building> buildings = new ArrayList<>();
    private String name;
    private long fullArea;

    public City(String name, long area) {
        this.name = name;
        this.fullArea = area;
    }

    public void addBuilding(Building building) {
        checkFullArea(building);
        buildings.add(building);
    }

    private void checkFullArea(Building building) {
        int sum = building.getArea();
        for (Building actual : buildings) {
            sum += actual.getArea();
        }
        if (sum > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    public Building findHighestBuilding() {
        Building highestBuilding = buildings.get(0);
        for (Building actual : buildings) {
            if (actual.getLevels() > highestBuilding.getLevels()) {
                highestBuilding = actual;
            }
        }
        return highestBuilding;
    }

    public Building findHighestBuildingStream() {
        return buildings.stream()
                .max(Comparator.comparingInt(Building::getLevels)).orElseThrow(() -> new IllegalArgumentException("Empty list."));
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> buildingsInTheStreet = new ArrayList<>();
        for (Building actual : buildings) {
            if (street.equals(actual.getAddress().getStreet())) {
                buildingsInTheStreet.add(actual);
            }
        }
        return buildingsInTheStreet;
    }

    public List<Building> findBuildingsByStreetStream(String street) {
        return buildings.stream()
                .filter(building -> building.getAddress().getStreet().equals(street))
                .toList();
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building actual : buildings) {
            if (actual.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereBuildingWithMorePeopleThanStream(int numberOfPeople) {
        return buildings.stream()
                .anyMatch(building -> building.calculateNumberOfPeopleCanFit() > numberOfPeople);
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
