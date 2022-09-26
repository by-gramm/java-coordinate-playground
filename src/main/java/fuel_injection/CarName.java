package fuel_injection;

public class CarName {

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return this.name;
    }
}

