package coordinate_calculator.utils;

import coordinate_calculator.domain.Point;

public class PointUtils {

    public static Point toPoint(String inputString) {
        String[] numbers = stripBracket(inputString).split(",");
        return Point.of(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
    }

    private static String stripBracket(String inputString) {
        return inputString.replaceAll("[()]", "");
    }
}
