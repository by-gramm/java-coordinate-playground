package fuel_injection;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<Car> carList = new ArrayList<>();

    private RentCompany() {
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public String generateReport() {
        StringBuffer reportString = new StringBuffer();

        carList.forEach(car -> {
            reportString.append(car.toString());
        });

        return reportString.toString();
    }

    public void addCar(Car car) {
        carList.add(car);
    }
}
