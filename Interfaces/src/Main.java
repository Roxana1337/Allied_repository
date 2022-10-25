public class Main {
    public static void main(String[] args) {
        Cars car;
        car = new Ford();
        System.out.println("The first car in the Showroom is a Ford: "
                + car.transmission() + " " + car.driveSystem() + " " + car.fuelType());
        car = new Audi();
        System.out.println("The second car in the showroom is an Audi: "
                + car.transmission() + " " + car.driveSystem() + " " + car.fuelType());
        boolean kia1 = Kia.has3doors(3);
        boolean kia2 = Kia.has3doors(0);
        System.out.println(kia1);
        System.out.println(kia2);

    }
}



