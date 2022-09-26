package fuel_injection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {
    private static final String NEWLINE = "\n";

    @Test
    public void report() {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성

        company.addCar(Sonata.of(150));
        company.addCar(K5.of(260));
        company.addCar(Sonata.of(120));
        company.addCar(Avante.of(300));
        company.addCar(K5.of(390));

        String report = company.generateReport();

        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                "K5 : 20리터" + NEWLINE +
                "Sonata : 12리터" + NEWLINE +
                "Avante : 20리터" + NEWLINE +
                "K5 : 30리터" + NEWLINE
        );
    }
}