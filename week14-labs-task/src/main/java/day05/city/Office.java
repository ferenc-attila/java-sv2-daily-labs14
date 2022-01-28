package day05.city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        checkNumberOfTables(area, numberOfTablesPerLevel);
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        checkNumberOfTables(area, numberOfTablesPerLevel);
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    private void checkNumberOfTables(int area, int numberOfTablesPerLevel) {
        if (numberOfTablesPerLevel > area / 2 || numberOfTablesPerLevel < area / 5) {
            throw new IllegalArgumentException("Invalid number of tables!");
        }
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return ((getLevels() - 1) * numberOfTablesPerLevel);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
