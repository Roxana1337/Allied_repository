//second implementation of the interface

public class Ford implements Cars {
    @Override
    public String transmission() {
        return "automatic";
    }

    @Override
    public String driveSystem() {
        return "4WD";
    }

    @Override
    public String fuelType() {
        return "gasoline";
    }

}
