package fuel_injection;

public class K5 extends AbstractCar {

    private static final double DISTANCE_PER_LITER = 13.0;

    private K5(double distance) {
        super(distance, "K5", DISTANCE_PER_LITER);
    }

    public static K5 of(double distance) {
        return new K5(distance);
    }

}
