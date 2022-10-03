package coordinate_calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rectangle extends Shape {

    private static final int NUMBER_OF_RECTANGLE_POINTS = 4;

    private final double width;
    private final double height;

    private Rectangle(List<Point> points) {
        super(points);

        List<Double> xList = points.stream()
                .map(Point::getX)
                .collect(Collectors.toList());
        List<Double> yList = points.stream()
                .map(Point::getY)
                .collect(Collectors.toList());

        this.width = Collections.max(xList) - Collections.min(xList);
        this.height = Collections.max(yList) - Collections.min(yList);
    }

    public static Rectangle create(List<Point> points) {
        if (!isQuadrangle(points)) {
            throw new IllegalArgumentException("직사각형의 점의 개수는 4개여야 합니다.");
        }
        if (!isUnique(points)) {
            throw new IllegalArgumentException("직사각형을 이루는 좌표는 중복될 수 없습니다.");
        }
        if (!isRectangle(points)) {
            throw new IllegalArgumentException("직사각형 이외의 사각형은 만들 수 없습니다.");
        }

        return new Rectangle(points);
    }

    public double getArea() {
        return this.width * this.height;
    }

    private static boolean isQuadrangle(List<Point> points) {
        return points.size() == NUMBER_OF_RECTANGLE_POINTS;
    }

    private static boolean isRectangle(List<Point> points) {
        List<Double> xList = points.stream()
                .map(Point::getX)
                .collect(Collectors.toList());

        List<Double> yList = points.stream()
                .map(Point::getY)
                .collect(Collectors.toList());

        return isTwoPairs(xList) && isTwoPairs(yList);
    }

    private static boolean isTwoPairs(List<Double> values) {
        List<Double> sortedValues = values.stream()
                .sorted()
                .collect(Collectors.toList());

        return Objects.equals(sortedValues.get(0), sortedValues.get(1)) &&
                Objects.equals(sortedValues.get(2), sortedValues.get(3));
    }

}
