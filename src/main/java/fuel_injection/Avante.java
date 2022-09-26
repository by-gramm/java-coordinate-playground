package fuel_injection;

public class Avante extends AbstractCar {

    private static final double DISTANCE_PER_LITER = 15.0;

    private Avante(double distance) {
        super(distance, "Avante", DISTANCE_PER_LITER);
    }

    public static Avante of(double distance) {
        return new Avante(distance);
    }

}
