package day05.city;

public abstract class Building {

    private int area;
    private int levels;
    private Address address;

    protected Building(int area, Address address) {
        this.area = area;
        this.address = address;
        this.levels = 1;
    }

    protected Building(int area, int levels, Address address) {
        this(area, address);
        this.levels = levels;
    }

    public abstract int calculateNumberOfPeopleCanFit();

    public int getFullArea() {
        return area * levels;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public Address getAddress() {
        return address;
    }
}
