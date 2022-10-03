package coordinate_calculator.utils;

import coordinate_calculator.domain.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointUtils {

    public static List<Point> toPoints(String inputString) {
        return Arrays.stream(inputString.split("-"))
                .map(PointUtils::toPoint)
                .collect(Collectors.toList());
    }

    public static Point toPoint(String inputString) {
        String[] numbers = stripBracket(inputString).split(",");
        return Point.of(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
    }

    private static String stripBracket(String inputString) {
        return inputString.replaceAll("[()]", "");
    }
}
