package day05.city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, Address address) {
        super(area, address);
    }

    public Home(int area, int levels, Address address) {
        super(area, address);
        checkLevels(levels);
        setLevels(levels);
    }

    private void checkLevels(int levels) {
        if (levels > 3) {
            throw new IllegalArgumentException("Too much levels!");
        }
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getArea() * getLevels()) / SQUARE_METERS_NEED_PER_PERSON;
    }
}
