package coordinate_calculator.utils;

import coordinate_calculator.domain.Line;
import coordinate_calculator.domain.Point;

public class LineUtils {

    public static Line toLine(String inputString) {
        String[] points = inputString.split("-");

        Point point1 = PointUtils.toPoint(points[0]);
        Point point2 = PointUtils.toPoint(points[1]);

        return Line.of(point1, point2);
    }
}
