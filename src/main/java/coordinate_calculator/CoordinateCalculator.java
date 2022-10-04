package coordinate_calculator;

import coordinate_calculator.domain.Point;
import coordinate_calculator.domain.Shape;
import coordinate_calculator.utils.PointUtils;
import coordinate_calculator.view.InputView;
import coordinate_calculator.view.ResultView;

import java.io.IOException;
import java.util.List;

public class CoordinateCalculator {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static List<Point> start() throws IOException {
        String coordinateInput = inputView.takeCoordinates();
        return createPoints(coordinateInput);
    }

    public static void showResult(Shape shape) {
        resultView.showCoordinates(shape.getPoints());

        resultView.showResult(shape);
    }

    private static List<Point> createPoints(String coordinateInput) throws IOException {

        try {
            return PointUtils.toPoints(coordinateInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return start();
        }
    }
}
