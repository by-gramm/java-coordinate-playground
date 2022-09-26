package fuel_injection;

public class CarEfficiency {

    private final double efficiency;

    private CarEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public static CarEfficiency of(double efficiency) {
        return new CarEfficiency(efficiency);
    }

    public double getEfficiency() {
        return this.efficiency;
    }
}

