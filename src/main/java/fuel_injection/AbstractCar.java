package fuel_injection;

public abstract class AbstractCar implements Car {

    private final CarName name;
    private final CarDistance distance;
    private final CarEfficiency efficiency;

    public AbstractCar(double distance, String name, double efficiency) {
        this.distance = CarDistance.of(distance);
        this.name = CarName.of(name);
        this.efficiency = CarEfficiency.of(efficiency);
    }

    @Override
    public CarName getName() {
        return this.name;
    }

    @Override
    public double getChargeQuantity() {
        return this.distance.getDistance() / this.efficiency.getEfficiency();
    }

    @Override
    public String toString() {
        return String.format("%s : %d리터\n", this.name.getName(), (int) getChargeQuantity());
    }
}
