package fuel_injection;

public abstract class AbstractCar implements Car {

    private final String name;
    private final double distance;
    private final double efficiency;

    public AbstractCar(double distance, String name, double efficiency) {
        this.distance = distance;
        this.name = name;
        this.efficiency = efficiency;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getChargeQuantity() {
        return this.distance / this.efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s : %d리터\n", this.name, (int) getChargeQuantity());
    }
}
