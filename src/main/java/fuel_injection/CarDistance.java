package fuel_injection;

public class CarDistance {

    private final double distance;

    private CarDistance(double distance) {
        this.distance = distance;
    }

    public static CarDistance of(double distance) {
        return new CarDistance(distance);
    }

    public double getDistance() {
        return this.distance;
    }
}
