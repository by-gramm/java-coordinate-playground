package fuel_injection;

public class Sonata extends AbstractCar {

    private static final double DISTANCE_PER_LITER = 10.0;

    private Sonata(double distance) {
        super(distance, "Sonata", DISTANCE_PER_LITER);
    }

    public static Sonata of(double distance) {
        return new Sonata(distance);
    }

}
