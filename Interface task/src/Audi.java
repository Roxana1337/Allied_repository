//first implementation of the interface

public class Audi implements Cars {
    @Override
    public String transmission() {
        return "manual";
    }

    @Override
    public String driveSystem() {
        return "2WD";
    }

    public Audi() {
        System.out.println("New Audi created");
    }

    @Override
    public String fuelType() {
        return "diesel";
    }

}
