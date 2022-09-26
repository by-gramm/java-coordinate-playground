package fuel_injection;

public class K5 extends Car {

    private final double distance;

    public K5(double distance) {
        this.distance = distance;
    }

    @Override
    double getEfficiency() {
        return 13.0;
    }

    @Override
    double getDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return "K5";
    }

}
