package coordinate_calculator;

import coordinate_calculator.domain.Line;
import coordinate_calculator.domain.Point;
import coordinate_calculator.utils.LineUtils;
import coordinate_calculator.view.InputView;
import coordinate_calculator.view.ResultView;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class CoordinateCalculator {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static Line start() throws IOException {
        String coordinateInput = inputView.takeCoordinates();
        return createPoints(coordinateInput);
    }

    public static void showResult(Line line) {
        Point point1 = line.getPoint1();
        Point point2 = line.getPoint2();

        resultView.showCoordinates(Arrays.asList(point1, point2));
        resultView.showDistance(line);
    }

    private static Line createPoints(String coordinateInput)
            throws IOException {

        try {
            return LineUtils.toLine(coordinateInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return start();
        }
    }
}
