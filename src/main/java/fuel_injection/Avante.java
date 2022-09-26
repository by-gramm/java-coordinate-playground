package fuel_injection;

public class Avante extends Car {

    private final double distance;

    public Avante(double distance) {
        this.distance = distance;
    }

    @Override
    double getEfficiency() {
        return 15.0;
    }

    @Override
    double getDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return "Avante";
    }

}
