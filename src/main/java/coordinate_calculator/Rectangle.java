package coordinate_calculator;

import coordinate_calculator.domain.Point;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Rectangle {

    public static final int NUMBER_OF_RECTANGLE_POINTS = 4;
    private static final int[][] idxArray = {
        {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}
    };

    private final List<Point> points;

    private Rectangle(List<Point> points) {
        this.points = points;
    }

    public static Rectangle of(List<Point> points) {
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
        return getWidth() * getHeight();
    }

    private static boolean isUnique(List<Point> points) {
        for (int arrIdx = 0; arrIdx < 6; arrIdx++) {
            int idx1 = idxArray[arrIdx][0];
            int idx2 = idxArray[arrIdx][1];

            if (points.get(idx1).equals(points.get(idx2))) {
                return false;
            }
        }

        return true;
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
        for (Double value : values) {
            if (Collections.frequency(values, value) != 2) {
                return false;
            }
        }

        return true;
    }

    private double getWidth() {
        List<Double> xValues = this.points
                .stream()
                .map(Point::getX)
                .distinct()
                .collect(Collectors.toList());

        return Math.abs(xValues.get(0) - xValues.get(1));
    }

    private double getHeight() {
        List<Double> yValues = this.points
                .stream()
                .map(Point::getY)
                .distinct()
                .collect(Collectors.toList());

        return Math.abs(yValues.get(0) - yValues.get(1));
    }

}
