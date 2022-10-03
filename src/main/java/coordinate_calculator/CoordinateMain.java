package coordinate_calculator;

import coordinate_calculator.domain.Point;
import coordinate_calculator.domain.Shape;

import java.io.IOException;
import java.util.List;

import static coordinate_calculator.CoordinateCalculator.*;

public class CoordinateMain {

    public static void main(String[] args) throws IOException {
        List<Point> points = start();

        Shape shape = Shape.of(points);

        showResult(shape);
    }
}
