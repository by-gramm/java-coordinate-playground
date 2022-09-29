package coordinate_calculator;

import coordinate_calculator.domain.Line;

import java.io.IOException;

import static coordinate_calculator.CoordinateCalculator.*;

public class CoordinateMain {

    public static void main(String[] args) throws IOException {
        Line line = start();

        showResult(line);
    }
}
