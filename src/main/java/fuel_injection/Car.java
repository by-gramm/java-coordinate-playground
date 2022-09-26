package fuel_injection;

public abstract class Car {
    private static final String NEWLINE = System.getProperty("line.separator");

    abstract double getEfficiency();

    abstract double getDistance();

    abstract String getName();

    double getChargeQuantity() {
        return getDistance() / getEfficiency();
    }

    @Override
    public String toString() {
        return getName() + " : " + (int) getChargeQuantity() + "리터" + NEWLINE;
    }
}