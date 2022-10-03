package coordinate_calculator.domain;

import java.util.List;

public class Line extends Shape {

    private static final int NUMBER_OF_LINE_POINTS = 2;

    private Line(List<Point> points) {
        super(points);
    }

    public static Line create(List<Point> points) {
        if (points.size() != NUMBER_OF_LINE_POINTS) {
            throw new IllegalArgumentException("직선은 2개의 좌표로 구성되어야 합니다.");
        }
        if (points.get(0).equals(points.get(1))) {
            throw new IllegalArgumentException("직선을 이루는 두 좌표는 달라야 합니다.");
        }

        return new Line(points);
    }

    public double getDistance() {
        Point point1 = getPoints().get(0);
        Point point2 = getPoints().get(1);

        return point1.getDistance(point2);
    }
}
