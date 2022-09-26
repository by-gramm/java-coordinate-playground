package fuel_injection;

public class Sonata extends Car {

    private final double distance;

    public Sonata(double distance) {
        this.distance = distance;
    }

    @Override
    double getEfficiency() {
        return 10.0;
    }

    @Override
    double getDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return "Sonata";
    }
}
